package com.example.supergame.model.dto.enemies;

import com.example.supergame.model.database.MissionInventory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Enemy {

    protected String name;

    protected int maxHp;

    protected int currentHp;

    protected int damage;

    protected int accuracy;

    protected MissionInventory missionInventory;
}
