package com.example.demo.controllers;

import com.example.demo.models.CotizacionModel;
import com.example.demo.models.ItemModel;
import com.example.demo.services.CotizacionService;
import com.example.demo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping()
    public ArrayList<ItemModel> obtenerItems(){

        return itemService.obtenerItemsServ();
    }

    @PostMapping()
    public ItemModel guardarItem(@RequestBody ItemModel item){
        return this.itemService.guardarItemServ(item);
    }


}
