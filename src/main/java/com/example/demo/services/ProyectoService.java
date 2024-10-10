package com.example.demo.services;

import com.example.demo.models.CotizacionModel;
import com.example.demo.models.ProyectoModel;
import com.example.demo.repositories.CotizacionRepository;
import com.example.demo.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

    public ArrayList<ProyectoModel> obtenerCotizacionesServ(){
        System.out.println(" LOG obtenerCotizacionesServ");
        return (ArrayList<ProyectoModel>) proyectoRepository.findAll();
    }

    public ArrayList<ProyectoModel> obtenerBorradorServ(){
        System.out.println(" LOG obtenerCotizacionesServ");
        return (ArrayList<ProyectoModel>) proyectoRepository.obtenerProyectosBorrador();
    }

    public String numeroProyectos(){
        System.out.println(" LOG numeroProyectos");
        return  proyectoRepository.numeroProyectos();
    }

    public ProyectoModel guardarProyectoServ(ProyectoModel proyecto){
        return proyectoRepository.save(proyecto);
    }
}
