package com.example.supergame.repository.enemies;

import com.example.supergame.model.database.EnemyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnemyDetailsRepository extends MongoRepository<EnemyDetails,String> {
}
