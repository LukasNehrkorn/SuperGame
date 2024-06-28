package com.example.supergame.repository;

import com.example.supergame.model.database.SpellDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpellDetailsRepository extends MongoRepository<SpellDetails, String> {
}
