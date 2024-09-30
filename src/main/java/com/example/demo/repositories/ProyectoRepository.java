package com.example.demo.repositories;

import com.example.demo.models.CotizacionModel;
import com.example.demo.models.ProyectoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProyectoRepository extends CrudRepository<ProyectoModel,Long> {

    @Query(value ="SELECT count(*) FROM u350426971_tek10dev.proyectos ",nativeQuery = true)
    String numeroProyectos ();
}
