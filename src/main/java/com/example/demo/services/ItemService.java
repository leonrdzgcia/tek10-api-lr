package com.example.demo.services;

import com.example.demo.models.CotizacionModel;
import com.example.demo.models.ItemModel;
import com.example.demo.repositories.CotizacionRepository;
import com.example.demo.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public ArrayList<ItemModel> obtenerItemsServ(){
        return (ArrayList<ItemModel>) itemRepository.findAll();
    }

    public ItemModel guardarItemServ(ItemModel item){
        return itemRepository.save(item);
    }
}
