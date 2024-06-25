package com.example.supergame.items;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Weapon extends Item {
    private double damage;
    private double accuracy;
    private WeaponType weaponType;

    public Weapon(String name, double price, double damage, double accuracy, WeaponType weaponType) {
        super(name, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.weaponType = weaponType;
    }
}
