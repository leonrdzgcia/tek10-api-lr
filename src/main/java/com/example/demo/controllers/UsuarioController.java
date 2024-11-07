package com.example.demo.controllers;


import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
