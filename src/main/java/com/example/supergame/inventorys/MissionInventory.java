package com.example.supergame.inventorys;

import com.example.supergame.items.MeleeWeapon;
import com.example.supergame.items.RangeWeapon;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MissionInventory {

     private RangeWeapon primaryWeapon;

     private RangeWeapon secondaryWeapon;

     private MeleeWeapon meleeWeapon;

    private int numOfHealingPotions;

    private int numOfDemonBloodPotions;

    private int moneyEarned;

    private int ammunition;
}
