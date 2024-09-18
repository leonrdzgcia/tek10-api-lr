package com.example.demo.services;

import com.example.demo.models.CotizacionModel;
import com.example.demo.repositories.CotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CotizacionService {

    @Autowired
    CotizacionRepository cotizacionRepository;

    public ArrayList<CotizacionModel> obtenerCotizacionesServ(){
        System.out.println(" LOG obtenerCotizacionesServ");
        return (ArrayList<CotizacionModel>) cotizacionRepository.findAll();
    }

    public CotizacionModel guardarCotizacionServ(CotizacionModel cotizacion){
        return cotizacionRepository.save(cotizacion);
    }



}
