package com.example.supergame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MissionInventory {
    // private PrimaryWeapon primaryWeapon;
    // private SecondaryWeapon secondaryWeapon;
    // private MeleeWeapon meleeWeapon;

    private int numOfHealingPotions;
    private int numOfDemonBloodPotions;

    private int moneyEarned;
}
