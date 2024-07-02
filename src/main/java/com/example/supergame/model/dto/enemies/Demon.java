package com.example.supergame.model.dto.enemies;

import com.example.supergame.model.database.MissionInventory;

public class Demon extends Enemy {

    public Demon(String name, int maxHp, int currentHp, int damage, int accuracy, MissionInventory missionInventory) {
        super(name, maxHp, currentHp, damage, accuracy, missionInventory);
    }
}
