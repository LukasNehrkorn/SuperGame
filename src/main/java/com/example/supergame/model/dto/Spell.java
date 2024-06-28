package com.example.supergame.model.dto;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Spell {

    @Id
    private String id;
    private String spellName;
    private String spellDescription;
    private int damageToEnemy;
    private int demonBloodCost;
}
