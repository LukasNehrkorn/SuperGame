package com.example.supergame.model.database;

import com.example.supergame.model.dto.item.Weapon;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "enemyDetails")
@AllArgsConstructor
public class EnemyDetails {

    @Id
    private String id;

    private Weapon weapon;

    private int maxHp;

    private int currentHp;

    private int accuracy;

    private int money;

    private boolean isBoss;
}
