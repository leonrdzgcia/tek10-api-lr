package com.example.demo.controllers;

import com.example.demo.services.CorreosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/correo")
public class CorreosController {

    @Autowired
    private CorreosService correoService;

    // Endpoint para enviar un correo
    @PostMapping("/enviar")
    public String enviarCorreo(@RequestParam String destinatario,
                               @RequestParam String asunto,
                               @RequestParam String mensaje) {
        correoService.enviarCorreo(destinatario, asunto, mensaje);
        return "Correo enviado exitosamente a " + destinatario;
    }

    /*@PostMapping("/restablecer")
    public String restablecerContraseña(@RequestParam("email") String email) {
        try {
            restablecerContrasenaService.enviarCorreoRestablecimiento(email);
            return "Correo de restablecimiento enviado";
        } catch (Exception e) {
            return "Error al enviar el correo de restablecimiento: " + e.getMessage();
        }
    }
    @GetMapping("/restablecer")
    public String mostrarFormularioRestablecimiento(@RequestParam("token") String token) {
        Optional<UsuarioMailModel> usuario = restablecerContrasenaService.obtenerUsuarioPorToken(token);
        if (usuario.isPresent()) {
            // Aquí podrías devolver una página HTML para que el usuario ingrese la nueva contraseña
            return "Formulario de restablecimiento de contraseña";
        } else {
            return "Token de restablecimiento inválido";
        }
    }
    @PostMapping("/actualizar")
    public String actualizarContraseña(@RequestParam("token") String token, @RequestParam("nuevaContraseña") String nuevaContraseña) {
        Optional<UsuarioMailModel> optionalUsuario = restablecerContrasenaService.obtenerUsuarioPorToken(token);
        if (optionalUsuario.isPresent()) {
            UsuarioMailModel usuario = optionalUsuario.get();
            restablecerContrasenaService.actualizarContrasena(usuario, nuevaContraseña);
            return "Contraseña actualizada correctamente";
        } else {
            return "Token de restablecimiento inválido";
        }
    }*/
}
