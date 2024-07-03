package com.example.supergame.repository.enemies;

import com.example.supergame.model.database.EnemyName;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnemyNamesRepository extends MongoRepository<EnemyName, String> {
}
