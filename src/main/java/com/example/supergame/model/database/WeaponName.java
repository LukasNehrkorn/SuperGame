package com.example.supergame.model.database;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeaponName {
    private String name;
    private String weaponType;
}
