package com.example.supergame.model.database;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SpellDetails")
@Getter
@Setter
@Builder
public class SpellDetails {
    @Id
    private String id;
    private String spellDescription;
    private int damageToEnemy;
    private int demonBloodCost;
}
