package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class CorreosService {

    @Autowired
    private JavaMailSender mailSender;

    // Método para enviar un correo
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        /*SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(destinatario);
        email.setSubject(asunto);
        email.setText(mensaje);
        email.setFrom("leonardo.rodriguez@nonicode.com");*/
        // Opcional: el remitente del correo
        //mailSender.send(email);

        sendEmail("leongzagza@gmail.com",
                "Prueba correo ",
                "Correo para restablecer contraseña");
    }

    public static void sendEmail(String to, String subject, String body) {
        SimpleMailMessage mensaje = new SimpleMailMessage();

        Properties props = new Properties();
        System.out.println("--- sendEmail 1 ");
        props.put("mail.smtp.host", "smtp.hostinger.com"); // Cambia esto a tu servidor SMTP
        props.put("mail.smtp.socketFactory.port", "465"); // El puerto SMTP
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Usar STARTTLS

        // Autenticación
        final String username = "leonardo.rodriguez@nonicode.com"; // Cambia esto a tu correo electrónico
        final String password = "Umm896118non@"; // Cambia esto a tu contraseña
        System.out.println("--- sendEmail 2");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            System.out.println("--- sendEmail 3");

            Message message = new MimeMessage(session);//Crear un mensaje
            message.setFrom(new InternetAddress("leongzagza@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));// Cambia esto a tu correo electrónico
            message.setSubject(subject);
            message.setText(body);
            System.out.println("--- sendEmail 4 ");
            Transport.send(message);// Enviar el mensaje
            System.out.println("Correo enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Llamar al método para enviar el correo electrónico
        // correo destino / asunto del correo / cuerpo el correo
        sendEmail("jonathan21dic@gmail.com",
                "Prueba correo Jonathan",
                "Correo para restablecer contraseña");
    }


}
