package com.example.supergame.inventorys.missionInventory;

import com.example.supergame.items.MeleeWeapon;
import com.example.supergame.items.RangeWeapon;
import lombok.*;
import org.w3c.dom.ranges.Range;

@Data
@Builder
public class MissionInventory {

     private RangeWeapon primaryWeapon;

     private RangeWeapon secondaryWeapon;

     private MeleeWeapon meleeWeapon;

    private int numOfHealingPotions;

    private int numOfDemonBloodPotions;

    private int moneyEarned;
}
