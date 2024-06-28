package com.example.supergame.repository;

import com.example.supergame.model.database.SpellName;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellNameRepository extends MongoRepository<SpellName, String> {
}
