package com.example.supergame.repository;

import com.example.supergame.model.dto.item.Consumables;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsumablesRepository extends MongoRepository<Consumables, String> {
}
