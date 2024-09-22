package com.example.demo.repositories;

import com.example.demo.models.CotizacionModel;
import com.example.demo.models.ProyectoModel;
import org.springframework.data.repository.CrudRepository;

public interface ProyectoRepository extends CrudRepository<ProyectoModel,Long> {
}
