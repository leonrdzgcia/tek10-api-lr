package com.example.demo.controllers;

import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/correo")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-confirmacion")
    public String enviarCorreo(@RequestParam String correo) {
        System.out.println(" -- enviar-confirmacion "+correo);
        // Aquí generamos un token único para el usuario
        String token = generarTokenUnico(); // Puedes crear un método para esto.
        // Enviamos el correo de confirmación
        //emailService.enviarCorreoConfirmacion(email, token);
        emailService.enviarCorreoConfirmacion(correo, token);
        return "Correo enviado exitosamente a " + correo;
    }

    @GetMapping("/enviar-confirmaciong")
    public String enviarCorreog(@RequestParam String correo) {
        System.out.println(" --email enviar-confirmacion ");
        System.out.println(correo);
        // Aquí generamos un token único para el usuario
        String token = generarTokenUnico(); // Puedes crear un método para esto.
        // Enviamos el correo de confirmación
        //emailService.enviarCorreoConfirmacion(email, token);
        emailService.enviarCorreoConfirmacion(correo, token);

        return "Correo enviado exitosamente a " + correo;
    }

    @PostMapping("/enviar-confirmaciondos")
    public ResponseEntity<String> sendEmail(

            @RequestParam String subject,
            @RequestParam String body) {
        System.out.println(" --send sendemail");
        //System.out.println(toEmail);

        boolean isSent = emailService.sendEmail("leongarzagarza@hotmail.com",
                subject, body);

        if (isSent) {
            return ResponseEntity.ok("Email enviado con éxito.");
        } else {
            return ResponseEntity.status(500).body("Error al enviar el correo.");
        }
    }


    // Método para generar un token único (por ejemplo, UUID)
    private String generarTokenUnico() {
        return java.util.UUID.randomUUID().toString();
    }
}
