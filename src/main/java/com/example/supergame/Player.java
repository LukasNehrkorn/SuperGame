package com.example.supergame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Player {
    protected String name;

    protected int maxHp;
    protected int currentHp;

    protected int maxDemonBlood;
    protected int currentDemonBlood;

    protected int accuracy;

    // protected Inventory inventory;
    // protected Spell[] spells;

    // protected MissionInventory missionInventory;
}
