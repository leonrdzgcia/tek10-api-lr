package com.example.demo.services;

import com.example.demo.models.ConsumoModel;
import com.example.demo.models.ProyectoModel;
import com.example.demo.repositories.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConsumoService {

    @Autowired
    ConsumoRepository consumoRepository;

    public ArrayList<ConsumoModel> obtenerConsumoServ(){
        System.out.println(" LOG obtener consumo diesel service");
        return (ArrayList<ConsumoModel>) consumoRepository.findAll();
    }

    public ConsumoModel guardarProyectoServ(ConsumoModel consumo){
        return consumoRepository.save(consumo);
    }
}
