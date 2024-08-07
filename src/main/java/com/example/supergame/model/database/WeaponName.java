package com.example.supergame.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weapons")
@Getter
@Builder
@AllArgsConstructor
public class WeaponName {
    private String name;
    private String weaponType;
}
