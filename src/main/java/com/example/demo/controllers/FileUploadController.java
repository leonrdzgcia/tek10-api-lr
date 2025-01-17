package com.example.demo.controllers;

import com.example.demo.models.ArchivosftpModel;
import com.example.demo.services.FtpService;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController

public class FileUploadController {
    @Value("${ftp.server}")
    private String ftpServer;
    @Value("${ftp.port}")
    private int ftpPort;
    @Value("${ftp.username}")
    private String ftpUsername;
    @Value("${ftp.password}")
    private String ftpPassword;
    private List<ArchivosftpModel> sfiles;
    private static final String UPLOAD_DIR = "/public_html/documentos/uploads/";


    @Autowired
    private FtpService ftpService;

    @GetMapping("/crear")
    public boolean crearCarpeta(
            @RequestParam("rfcRfQ") String rfcRfQ,
            @RequestParam("usuario") String usuario) throws IOException {
        try {
            //ftpService.createDirectory("/public_html/documentos/proveedores/1/");
            ftpService.createDirectory(rfcRfQ,usuario);
            return true;
        } finally {
        }
    }

    @PostMapping("/uploads")
    public ResponseEntity<String> uploadFiles(@RequestBody List<String> filePaths) {
        //boolean success = ftpService.uploadFiles(filePaths, remoteDirectory);
        boolean success = ftpService.uploadFiles(filePaths);
        if (success) {
            return ResponseEntity.ok("All files uploaded successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to upload some or all files.");
        }


    }

    @PostMapping("/uploadFiles")
    public ResponseEntity<String> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        StringBuilder result = new StringBuilder();
        int contador = 0 ;
        System.out.println(files);
        System.out.println(files.length);
        for (MultipartFile file : files) {
            System.out.println("Contador - "+contador);
            FTPClient ftpClient = new FTPClient();
            System.out.println(ftpServer + ftpPort + ftpUsername + ftpPassword);
            try (InputStream inputStream = file.getInputStream()) {
                ftpClient.connect(ftpServer, ftpPort);
                ftpClient.login(ftpUsername, ftpPassword);
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                boolean uploaded = ftpClient.storeFile("/public_html/documentos/"+ file.getOriginalFilename(), inputStream);
                contador++;
                /*if (uploaded) {
                    System.out.println("Archivo subido exitosamente 20");
                    return new ResponseEntity<>("Archivo subido exitosamente", HttpStatus.OK);
                } else {
                    System.out.println("Error al subir el archivo");
                    return new ResponseEntity<>("Error al subir el archivo", HttpStatus.INTERNAL_SERVER_ERROR);
                }*/

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al conectar con el servidor FTP");
                return new ResponseEntity<>("Error al conectar con el servidor FTP", HttpStatus.INTERNAL_SERVER_ERROR);
            } finally {

                try {
                    if (ftpClient.isConnected()) {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }


        return ResponseEntity.ok(result.toString());
    }



    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Archivo no válido", HttpStatus.BAD_REQUEST);
        }
        FTPClient ftpClient = new FTPClient();
        System.out.println(ftpServer + ftpPort + ftpUsername + ftpPassword);
        try (InputStream inputStream = file.getInputStream()) {
            ftpClient.connect(ftpServer, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //boolean uploaded = ftpClient.storeFile("/domains/asesoriascedemusa.com/public_html/assets/img/" + file.getOriginalFilename(), inputStream);
            boolean uploaded = ftpClient.storeFile("/public_html/documentos/"
                    + file.getOriginalFilename(), inputStream);
            if (uploaded) {
                System.out.println("Archivo subido exitosamente 20");
                return new ResponseEntity<>("Archivo subido exitosamente", HttpStatus.OK);
            } else {
                System.out.println("Error al subir el archivo");
                return new ResponseEntity<>("Error al subir el archivo", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al conectar con el servidor FTP");
            return new ResponseEntity<>("Error al conectar con el servidor FTP", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    @GetMapping("/download")
    public ResponseEntity<String> downloadFile(
            @RequestParam String remoteFilePath,
            @RequestParam String downloadPath) {
        boolean success = ftpService.downloadFile(remoteFilePath, downloadPath);
        if (success) {
            return ResponseEntity.ok("File downloaded successfully to " + downloadPath);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to download file.");
        }
    }
    @GetMapping("/listFiles")
    public List<String> listFiles() throws IOException {
        System.out.println("-- listFiles ");
        FTPClient ftpClient = new FTPClient();
        List<String> fileNames = new ArrayList<>();
        try {
            ftpClient.connect(ftpServer, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory("/domains/asesoriascedemusa.com/public_html/assets/vid/");
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        } finally {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        }
        return fileNames;
    }
    @GetMapping("/deleteFileG")
    public String eliminarArchivosG(@RequestParam("src") String src) {
        boolean flag;
        try {
            flag = this.deleteFile(src);
            //System.out.println("-- deleteFile ");
            if (flag) {
                System.out.println(flag);
                return "Archivo eliminado";
            } else {
                System.out.println(flag);
                return "Archivo no se a eliminado";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }//return "Received: eliminarArchivosP";
    }
    @PostMapping("/deleteFileP")
    public String eliminarArchivosP(@RequestParam("src") String src) {
        boolean flag;
        try {
            flag = this.deleteFile(src);
            //System.out.println("-- deleteFile ");
            if (flag) {
                System.out.println(flag);
                return "Archivo eliminado";
            } else {
                System.out.println(flag);
                return "Archivo no se a eliminado";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }//return "Received: eliminarArchivosP";
    }
    public boolean deleteFile(String remoteFilePath) throws IOException {
        System.out.println(remoteFilePath);
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(ftpServer, ftpPort);
        ftpClient.login(ftpUsername, ftpPassword);
        ftpClient.enterLocalPassiveMode();
        System.out.println("-- deleteFile 5");
        boolean deleted = ftpClient.deleteFile(remoteFilePath);
        System.out.println("-- deleteFile 6");
        System.out.println(deleted);
        /*if (!deleted) {throw new IOException("Could not delete file: " + ftpClient.getReplyString());}*/
        System.out.println("-- deleteFile 7");
        ftpClient.logout();
        ftpClient.disconnect();
        return deleted;
    }

    /*@GetMapping("/archivos")
    public List<ArchivosftpModel> obtenerListaImagenes() throws IOException {
        try {
            List<ArchivosftpModel> fileList = ftpService.listFiles();
            return fileList;
        } finally {
        }
    }*/
}
