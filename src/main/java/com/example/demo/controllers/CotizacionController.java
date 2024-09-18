package com.example.demo.controllers;

import com.example.demo.models.CotizacionModel;
import com.example.demo.services.CotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cotizacion")
public class CotizacionController {

    @Autowired
    CotizacionService cotizacionService;

    @GetMapping()
    public ArrayList<CotizacionModel> obtenerCotizaciones(){

        return cotizacionService.obtenerCotizacionesServ();
    }

    @PostMapping()
    public CotizacionModel guardarCotizacion(@RequestBody CotizacionModel cotizacion){
        return this.cotizacionService.guardarCotizacionServ(cotizacion);
    }








}
