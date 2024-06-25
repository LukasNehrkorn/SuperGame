package com.example.supergame.players;

import lombok.*;

@Data
@Builder
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
