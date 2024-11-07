package com.example.demo.services;

import com.example.demo.models.ArchivosftpModel;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTP;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.File;

@Service
public class FtpService {
    @Value("${ftp.server}")
    private String ftpServer;
    @Value("${ftp.port}")
    private int ftpPort;
    @Value("${ftp.username}")
    private String ftpUsername;
    @Value("${ftp.password}")
    private String ftpPassword;
    /*@Value("${ftp.base.directory}")
    private String ftpBaseDirectory;*/

    public boolean uploadFiles(List<String> filePaths) {
        System.out.println("-- FtpService uploadFiles");
        FTPClient ftpClient = new FTPClient();
        boolean allFilesUploaded = true;
        try {
            // Conectar al servidor FTP
            System.out.println("-- FtpService 1");
            ftpClient.connect(ftpServer, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            System.out.println("-- FtpService 2");
            // Cambiar al directorio remoto donde se subirán los archivos
            //ftpClient.changeWorkingDirectory(remoteDirectory);
            ftpClient.changeWorkingDirectory("/public_html/documentos/");
            // Subir cada archivo de la lista
            for (String filePath : filePaths) {
                System.out.println("-- FtpService 3");
                File localFile = new File(filePath);
                try (FileInputStream inputStream = new FileInputStream(localFile)) {
                    boolean uploaded = ftpClient.storeFile(localFile.getName(), inputStream);
                    if (!uploaded) {
                        allFilesUploaded = false;
                        System.out.println("Failed to upload file: " + localFile.getName());
                    }
                }
            }
            System.out.println("-- FtpService 4");
        } catch (IOException e) {
            e.printStackTrace();
            allFilesUploaded = false;
        } finally {
            // Cerrar la conexión
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return allFilesUploaded;
    }
    public List<ArchivosftpModel> listFiles() throws IOException {
        System.out.println("---- FtpService listFiles");
        FTPClient ftpClient = new FTPClient();
        List<ArchivosftpModel> fileList = new ArrayList<>();
        try {
            ftpClient.connect(ftpServer, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            FTPFile[] files = new FTPFile[0];files = ftpClient.listFiles("/public_html/documentos/");
            System.out.println("CADENAS BACJ");
            System.out.println(files);
            System.out.println(files.length);
            int cont = 0;
            for (int i = 0; i < files.length; i++) {
                System.out.println("INICIO FOR "+ i);
                //System.out.println( i + "/"+files[i].getName());
                if (files[i].getName().toString().equals(".") || files[i].getName().toString().equals("..")){
                    System.out.println( i + "/"+files[i].getName());
                    //fileList.add(new ArchivosftpModel(i, files[i].getName()));
                }else{
                    //System.out.println( i + "/"+files[i].getName());
                    fileList.add(new ArchivosftpModel(cont, files[i].getName()));
                    cont++;
                }
                System.out.println("FIN FOR ");
            }
        } finally {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        }
        return fileList;
    }
    public boolean downloadFile(String remoteFilePath, String downloadPath) {
        System.out.println("---- FtpService downloadFile");
        System.out.println(remoteFilePath);
        System.out.println(downloadPath);
        FTPClient ftpClient = new FTPClient();
        boolean success = false;
        try {
            System.out.println("---- FtpService 1");
            // Conectar al servidor FTP
            ftpClient.connect(ftpServer, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            System.out.println("---- FtpService 2");
            // Configurar tipo de archivo a binario
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            // Descargar el archivo
            System.out.println("---- FtpService 3");
            try (OutputStream outputStream = new FileOutputStream(downloadPath)) {
                System.out.println("---- FtpService 4");
                success = ftpClient.retrieveFile(remoteFilePath, outputStream);
            }
        } catch (IOException e) {
            System.out.println("---- FtpService IOException");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                    System.out.println("---- FtpService cerro conexion");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return success;
    }
    public boolean createDirectory(String rfcRfQ, String usuario ) {
        System.out.println("-- FtpService createDirectory: " );
        FTPClient ftpClient = new FTPClient();
        boolean directoryCreated = false;
        String remoteDirectoryPath="";
        try {
            // Conectar al servidor FTP
            ftpClient.connect(ftpServer, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            if (usuario == "CLIENTE"){
                remoteDirectoryPath = "/public_html/documentos/proveedores/"+rfcRfQ;
                directoryCreated = ftpClient.makeDirectory(remoteDirectoryPath);

            }else if (usuario == "PROVEEDOR"){
                remoteDirectoryPath = "/public_html/documentos/clientes/"+rfcRfQ;
                directoryCreated = ftpClient.makeDirectory(remoteDirectoryPath);
            }else if (usuario == "RFQ"){
                remoteDirectoryPath = "/public_html/proyectos/"+rfcRfQ;

            }

            // Crear la carpeta en el servidor FTP
            //directoryCreated = ftpClient.makeDirectory(remoteDirectoryPath);
            if (directoryCreated) {
                System.out.println("Directory created successfully: " + remoteDirectoryPath);
            } else {
                System.out.println("Failed to create directory: " + remoteDirectoryPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return directoryCreated;
    }

}