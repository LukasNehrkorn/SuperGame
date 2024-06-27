package com.example.supergame.repository;

import com.example.supergame.model.database.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player,String> {

}
