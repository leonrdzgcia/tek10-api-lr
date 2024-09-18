package com.example.demo.repositories;

import com.example.demo.models.CotizacionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CotizacionRepository extends CrudRepository<CotizacionModel,Long> {
}
