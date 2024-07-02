package com.example.supergame.model.dto;

import com.example.supergame.model.database.SpellDetails;
import com.example.supergame.model.database.SpellName;
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

    public SpellName toSpellName() {
        return SpellName.builder()
                .id(id)
                .spellName(spellName)
                .build();
    }

    public SpellDetails toSpellDetails() {
        return SpellDetails.builder()
                .id(id)
                .spellDescription(spellDescription)
                .damageToEnemy(damageToEnemy)
                .demonBloodCost(demonBloodCost)
                .build();
    }
}
