package com.example.supergame;

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

    // protected MissionInventory missionInventory;
}
