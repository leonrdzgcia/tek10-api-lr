package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HolaController {
    @GetMapping()
    public String inicio(){
        return "Tek api disponible, al 18-08-24";
    }
}