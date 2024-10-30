package com.example.demo.controllers;

import com.example.demo.models.ConsumoModel;
import com.example.demo.models.ProyectoModel;
import com.example.demo.services.ConsumoService;
import com.example.demo.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/consumo")
public class ConsumoController {

    @Autowired
    ConsumoService consumoService;

    @GetMapping()
    public ArrayList<ConsumoModel> obtenerProyectos(){
        return consumoService.obtenerConsumoServ();
    }

    @PostMapping()
    public ConsumoModel guardarConsumo(@RequestBody ConsumoModel consumo){
        return this.consumoService.guardarProyectoServ(consumo);
    }
}
