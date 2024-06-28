package com.example.supergame.model.item;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Weapon extends Item {

    private double damage;

    private double accuracy;

    private WeaponCategory weaponCategory;

    private Rarity rarity;

    public Weapon(String name, double price, double damage, double accuracy, WeaponCategory weaponCategory, Rarity rarity) {
        super(name, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.weaponCategory = weaponCategory;
        this.rarity = rarity;
    }
}
