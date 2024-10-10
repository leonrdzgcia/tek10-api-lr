package com.example.demo.repositories;

import com.example.demo.models.CotizacionModel;
import com.example.demo.models.ProyectoModel;
import com.example.demo.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ProyectoRepository extends CrudRepository<ProyectoModel,Long> {

    @Query(value ="SELECT count(*) FROM u350426971_tek10dev.proyectos ",nativeQuery = true)
    String numeroProyectos ();


    @Query(value ="SELECT * FROM u350426971_tek10dev.proyectos where estatus = 'BORRADOR'",nativeQuery = true)
    ArrayList<ProyectoModel> obtenerProyectosBorrador ();

}
