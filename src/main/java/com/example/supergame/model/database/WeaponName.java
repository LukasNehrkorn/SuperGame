package com.example.supergame.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class WeaponName {
    private String name;
    private String weaponType;
}
