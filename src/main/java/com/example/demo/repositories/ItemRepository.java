package com.example.demo.repositories;

import com.example.demo.models.ItemModel;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemModel, Long> {
}
