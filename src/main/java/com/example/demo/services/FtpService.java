package com.example.demo.services;

import com.example.demo.models.ArchivosftpModel;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTP;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.OutputStream;

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

    public List<ArchivosftpModel> listFiles() throws IOException {
        System.out.println("---- FtpService listFiles");
        FTPClient ftpClient = new FTPClient();
        List<ArchivosftpModel> fileList = new ArrayList<>();
        try {
            ftpClient.connect(ftpServer, ftpPort);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            FTPFile[] files = new FTPFile[0];files = ftpClient.listFiles("/public_html/fiscal/");
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
}