package com.example.supergame.testdata;

import com.example.supergame.model.Job;
import com.example.supergame.model.Race;
import com.example.supergame.model.database.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TestDataFactory {
    public SpellName getSpellName() {
        return SpellName.builder()
                .id("667d5a103da5309d83b96ccd")
                .spellName("Barrier of the shadows")
                .build();
    }

    public SpellDetails getSpellDetails() {
        return SpellDetails.builder()
                .id("667d5a103da5309d83b96ccd")
                .spellDescription("A Spell that envelops the caster in a protective shadow, that blocks damage")
                .damageToEnemy(0)
                .demonBloodCost(50)
                .build();
    }

    public Player getPlayer() {
        List<String> spells = new ArrayList<>();
        spells.add("667d5a103da5309d83b96ccd");

        return Player.builder()
                .id("667c0f650666f16dac81f91b")
                .name("Lukas")
                .race(Race.HUMAN)
                .job(Job.MEDIC)
                .maxHp(100)
                .currentHp(100)
                .maxDemonBlood(100)
                .currentDemonBlood(100)
                .accuracy(100)
                .inventory(new Inventory())
                .spells(spells)
                .missionInventory(new MissionInventory())
                .build();
    }
}
