package com.example.supergame.model.database;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Spells")
@Getter
@Setter
@Builder
public class SpellName {
    @Id
    private String id;
    private String spellName;
}
