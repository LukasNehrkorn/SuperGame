package com.example.supergame.spells;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Spell {

    private String spellName;
    private int damageToEnemy;
    private int demonBloodCost;
}
