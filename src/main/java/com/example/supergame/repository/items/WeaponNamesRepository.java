package com.example.supergame.repository.items;

import com.example.supergame.model.database.WeaponName;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponNamesRepository extends MongoRepository<WeaponName, String> {
}
