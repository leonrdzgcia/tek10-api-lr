package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


import java.util.Properties;

@Service
public class EmailService {

    private final String username = "leonardo.rodriguez@tek10.mx";
    private final String password = "Umm89618tek";

    @Autowired
    private JavaMailSender mailSender;

    // Método para enviar un correo de confirmación
    public void enviarCorreoConfirmacion(String para, String token) {
        System.out.println("--email enviarCorreoConfirmacion ");
        System.out.println(para);
        System.out.println(token);
        //String urlConfirmacion = "http://localhost:4200/confirmar-registro?token=" + token;


        //String urlConfirmacion = "http://localhost:4200/auth/detalle?correo=" + para;
        String urlConfirmacion =    "https://dev.tek10.mx/auth/detalle?correo=" + para;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(para);
        email.setSubject("Confirmación de Registro");
        email.setText("Por favor, confirma tu cuenta haciendo clic en el siguiente enlace: " + urlConfirmacion);
        mailSender.send(email);
    }

    public boolean sendEmail(String toEmail, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.office365.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
