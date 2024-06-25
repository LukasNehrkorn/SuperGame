package com.example.supergame.enemys;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public abstract class Enemy {
    protected int name;

    protected int maxHp;
    protected int currentHp;

    protected int damage;
    protected int accuracy;

    // protected MissionInventory missionInventory;
}
