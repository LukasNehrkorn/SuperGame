package com.example.supergame.repository;

import com.example.supergame.model.database.SpellDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellDetailsRepository extends MongoRepository<SpellDetails, String> {
}
