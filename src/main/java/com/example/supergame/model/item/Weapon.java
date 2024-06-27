package com.example.supergame.model.item;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Weapon extends Item {

    private double damage;

    private double accuracy;

    private WeaponType weaponType;

    private Rarity rarity;

    public Weapon(String name, double price, double damage, double accuracy, WeaponType weaponType, Rarity rarity) {
        super(name, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.weaponType = weaponType;
        this.rarity = rarity;
    }
}
