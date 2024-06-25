package com.example.supergame.missionInventory;

import lombok.*;

@Data
@Builder
public class MissionInventory {
    // private PrimaryWeapon primaryWeapon;
    // private SecondaryWeapon secondaryWeapon;
    // private MeleeWeapon meleeWeapon;

    private int numOfHealingPotions;
    private int numOfDemonBloodPotions;

    private int moneyEarned;
}
