package com.example.supergame.enemys;

import com.example.supergame.inventorys.MissionInventory;
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
