package com.example.demo.controllers;


import com.example.demo.models.CotizacionModel;
import com.example.demo.models.ProyectoModel;
import com.example.demo.services.CotizacionService;
import com.example.demo.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping()
    public ArrayList<ProyectoModel> obtenerProyectos(){

        return proyectoService.obtenerCotizacionesServ();
    }

    @PostMapping()
    public ProyectoModel guardarCotizacion(@RequestBody ProyectoModel proyecto){
        return this.proyectoService.guardarProyectoServ(proyecto);
    }
}
