package com.example.supergame.inventorys;

import com.example.supergame.items.MeleeWeapon;
import com.example.supergame.items.RangeWeapon;
import lombok.*;

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
