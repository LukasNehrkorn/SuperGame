package com.example.supergame.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Spell {

    private String spellName;
    private int damageToEnemy;
    private int demonBloodCost;
}
