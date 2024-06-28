package com.example.supergame.model.database;

import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionInventory {

    private RangeWeapon primaryWeapon;

    private RangeWeapon secondaryWeapon;

    private MeleeWeapon meleeWeapon;

    private int numOfHealingPotions;

    private int numOfDemonBloodPotions;

    private int moneyEarned;

    private int ammunition;
}
