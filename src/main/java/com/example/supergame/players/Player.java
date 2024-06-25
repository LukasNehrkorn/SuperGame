package com.example.supergame.players;

import com.example.supergame.inventorys.Inventory;
import com.example.supergame.inventorys.MissionInventory;
import com.example.supergame.spells.Spell;
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

     private Inventory inventory;

     private Spell[] spells;

     private MissionInventory missionInventory;
}
