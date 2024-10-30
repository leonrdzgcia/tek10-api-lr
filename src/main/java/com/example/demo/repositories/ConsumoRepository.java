package com.example.demo.repositories;

import com.example.demo.models.ConsumoModel;
import com.example.demo.models.ProyectoModel;
import org.springframework.data.repository.CrudRepository;

public interface ConsumoRepository extends CrudRepository<ConsumoModel,Long> {
}
