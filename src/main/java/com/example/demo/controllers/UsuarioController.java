package com.example.demo.controllers;


import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        System.out.println(" ----  obtener UsuarioController --");
        return usuarioService.obtenerUsuariosServ();
    }

    @GetMapping("/totalusuarios")
    public String obtenerNumeroUsuarios(){
        return usuarioService.obtenerNumeroUsuariosSer();
    }

    @GetMapping("/correo")
    public ArrayList<UsuarioModel> obtenerProyectosNum(@RequestParam String correo){
        return usuarioService.obtenerCorreoUsuarioServ(correo);
    }



    @PostMapping()
    public UsuarioModel guardarCotizacion(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuarioServ(usuario);
    }

    @GetMapping("/validar")
    public int verificarUsuario(@RequestParam String correo) {
        System.out.println("Entra controller verificarUsuario");
        return usuarioService.validarCorreoUsuarioServ(correo);
    }

    @GetMapping("/autorizar")
    public int autorizarUsuario(@RequestParam String correo) {
        System.out.println("Entra controller verificarUsuario");
        return usuarioService.autorizarCorreoUsuarioServ(correo);
    }

    @PostMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarRegistro(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
        System.out.println("PostMapping(/actualizar/{id");
        System.out.println(id);
        System.out.println(usuario);
        try {
            UsuarioModel actualizado = usuarioService.actualizaruUsuario(id, usuario);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el registro");
        }
    }

}
