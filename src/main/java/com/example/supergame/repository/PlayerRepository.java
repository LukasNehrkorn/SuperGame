package com.example.supergame.repository;

import com.example.supergame.model.database.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player,String> {
}
