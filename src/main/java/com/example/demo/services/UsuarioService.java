package com.example.demo.services;

import com.example.demo.models.ProyectoModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.ProyectoRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuariosServ(){
        System.out.println(" ----  obtenerUsuariosServ --");
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public ArrayList<UsuarioModel> obtenerCorreoUsuarioServ(String correo){
        System.out.println(" ----  obtenercCorreoUsuarioServ --");
        return (ArrayList<UsuarioModel>) usuarioRepository.usuarioCorreo(correo);
    }

    public UsuarioModel guardarUsuarioServ(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    // Método que verifica si el usuario existe por email
    public boolean verificarUsuarioPorEmail(String correo) {
        System.out.println("Entra service verificarUsuarioPorEmail");
        System.out.println(usuarioRepository.existsByCorreo(correo));
        return usuarioRepository.existsByCorreo(correo);
    }
    public int validarCorreoUsuarioServ (String correo){
        System.out.println("Entra service validarCorreoUsuarioServ");
        System.out.println(usuarioRepository.validarCorreoUsuario(correo));
        return usuarioRepository.validarCorreoUsuario(correo);
    }

    public int autorizarCorreoUsuarioServ (String correo){
        System.out.println("Entra service validarCorreoUsuarioServ");
        System.out.println(usuarioRepository.autorizarCorreoProveedor(correo));
        return usuarioRepository.autorizarCorreoProveedor(correo);
    }

    public String obtenerNumeroUsuariosSer(){
        System.out.println(" LOG numeroProyectos");
        return  usuarioRepository.numeroUsuarios();
    }

    public UsuarioModel actualizaruUsuario(Long id, UsuarioModel registro) {
        UsuarioModel existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        existente.setCodigopostal(registro.getCodigopostal());
        existente.setRfc(registro.getRfc());
        //existente.setCodigopostal(registro.getCodigopostal());
        //existente.setCampo2(registro.getCampo2());
        // Actualiza los campos necesarios
        return usuarioRepository.save(existente);
    }

}
