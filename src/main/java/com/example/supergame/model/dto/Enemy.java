package com.example.supergame.model.dto;

import com.example.supergame.model.database.MissionInventory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Enemy {

    protected int name;

    protected int maxHp;

    protected int currentHp;

    protected int damage;

    protected int accuracy;

    protected MissionInventory missionInventory;
}
