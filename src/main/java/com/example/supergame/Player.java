package com.example.supergame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Player {
    private String name;

    private int maxHp;
    private int currentHp;

    private int maxDemonBlood;
    private int currentDemonBlood;

    private int accuracy;

    // private Inventory inventory;
    // private Spell[] spells;

    // private MissionInventory missionInventory;
}
