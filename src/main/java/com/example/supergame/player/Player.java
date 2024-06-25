package com.example.supergame.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
