package com.example.demo.repositories;

import com.example.demo.models.ProyectoModel;
import com.example.demo.models.UsuarioModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {

    @Query(value ="SELECT count(*) FROM u350426971_tek10dev.proyectos ",nativeQuery = true)
    String numeroProyectos ();

    @Query(value ="SELECT * FROM u350426971_tek10dev.usuarios where correo = ?1 ",nativeQuery = true)
    ArrayList<UsuarioModel> usuarioCorreo (String correo);

    @Query(value ="SELECT count(*) FROM u350426971_tek10dev.usuarios ",nativeQuery = true)
    String numeroUsuarios ();

    @Modifying
    @Transactional
    @Query(value ="update u350426971_tek10dev.usuarios set estatus = 'VALIDADO' where correo = ?1 ",
            nativeQuery = true)
    int validarCorreoUsuario (String correo);

    @Modifying
    @Transactional
    @Query(value ="update u350426971_tek10dev.usuarios set estatus = 'AUTORIZADO' where correo = ?1 ",
            nativeQuery = true)
    int autorizarCorreoProveedor (String correo);

    @Modifying
    @Transactional
    @Query(value ="update u350426971_tek10dev.usuarios set estatus = 'AUTORIZADO' where correo = ?1 ",
            nativeQuery = true)
    int actualizarUsuario (String correo,String direccion ,String nombreFiscal ,
                           String rfc ,String codigopostal ,String direccionFiscal);

    boolean existsByCorreo(String correo);

}
