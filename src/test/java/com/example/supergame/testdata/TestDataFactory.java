package com.example.supergame.testdata;

import com.example.supergame.model.dto.Shop;
import com.example.supergame.model.dto.Spell;
import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import com.example.supergame.model.dto.item.WeaponType;
import com.example.supergame.model.enums.Job;
import com.example.supergame.model.enums.Race;
import com.example.supergame.model.database.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TestDataFactory {
    public Spell getSpell() {
        return Spell.builder()
                .id("667d5a103da5309d83b96ccd")
                .spellName("Barrier of the shadows")
                .spellDescription("A Spell that envelops the caster in a protective shadow, that blocks damage")
                .damageToEnemy(0)
                .demonBloodCost(50)
                .build();
    }

    public SpellName getSpellName() {
        return getSpell().toSpellName();
    }

    public SpellDetails getSpellDetails() {
        return getSpell().toSpellDetails();
    }

    public Player getPlayer() {
        List<String> spells = new ArrayList<>();
        spells.add(getSpell().getId());

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
                .inventory(getInventory())
                .spells(spells)
                .missionInventory(new MissionInventory())
                .build();
    }

    public Inventory getInventory() {
        return new Inventory(new ArrayList<>(), 200);
    }

    public Shop getCheapShop() {
        return Shop.builder()
                .primaryWeapon(new RangeWeapon("name", 200, 20, 50, WeaponType.PRIMARY, 100, 100))
                .secondaryWeapon(new RangeWeapon("name", 200, 20, 50, WeaponType.SECONDARY, 100, 100))
                .meleeWeapon(new MeleeWeapon("name", 200, 20, 50, WeaponType.MELEE, 2))
                .build();
    }

    public Shop getExpensiveShop() {
        return Shop.builder()
                .primaryWeapon(new RangeWeapon("name", 2000, 20, 50, WeaponType.PRIMARY, 100, 100))
                .secondaryWeapon(new RangeWeapon("name", 2000, 20, 50, WeaponType.SECONDARY, 100, 100))
                .meleeWeapon(new MeleeWeapon("name", 2000, 20, 50, WeaponType.MELEE, 2))
                .build();
    }
}
