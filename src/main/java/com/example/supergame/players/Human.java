package com.example.supergame.players;

import com.example.supergame.inventorys.Inventory;
import com.example.supergame.inventorys.MissionInventory;
import com.example.supergame.spells.Spell;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Human extends Player {

    Human(String name, int maxHp, int currentHp, int maxDemonBlood, int currentDemonBlood, int accuracy, Inventory inventory, Spell[] spells, MissionInventory missionInventory) {
        super(name, maxHp, currentHp, maxDemonBlood, currentDemonBlood, accuracy, inventory, spells, missionInventory);
    }
}
