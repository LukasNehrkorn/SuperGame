package com.example.supergame.model.database;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "enemyNames")
@AllArgsConstructor
public class EnemyName {

    @Id
    private String id;

    private String name;

    private String enemyType;
}
