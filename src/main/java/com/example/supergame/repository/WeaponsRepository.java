package com.example.supergame.repository;

import com.example.supergame.model.dto.item.Weapon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeaponsRepository extends MongoRepository<Weapon,String> {
}
