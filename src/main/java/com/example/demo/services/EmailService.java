package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Método para enviar un correo de confirmación
    public void enviarCorreoConfirmacion(String para, String token) {
        System.out.println("-- enviarCorreoConfirmacion ");
        System.out.println(para);
        System.out.println(token);
        //String urlConfirmacion = "http://localhost:4200/confirmar-registro?token=" + token;
        //String urlConfirmacion = "http://localhost:4200/auth/detalle?correo=" + para;
        String urlConfirmacion = "http://dev.tek10.com.mx/auth/detalle?correo=" + para;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(para);
        email.setSubject("Confirmación de Registro");
        email.setText("Por favor, confirma tu cuenta haciendo clic en el siguiente enlace: " + urlConfirmacion);
        mailSender.send(email);
    }
}
