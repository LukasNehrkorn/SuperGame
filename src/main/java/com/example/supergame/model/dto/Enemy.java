package com.example.supergame.model.dto;

import com.example.supergame.model.database.EnemyDetails;
import com.example.supergame.model.database.EnemyName;
import com.example.supergame.model.dto.item.Weapon;
import com.example.supergame.model.enums.EnemyType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Enemy {

    @Id
    private String id;

    private String name;

    private EnemyType enemyType;

    private Weapon weapon;

    private int maxHp;

    private int currentHp;

    private int accuracy;

    private int money;

    public EnemyName toEnemyName() {
        return new EnemyName(id, name, enemyType.toString());
    }

    public EnemyDetails toEnemyDetails() {
        return new EnemyDetails(id, weapon, maxHp, currentHp, accuracy, money);
    }
}
