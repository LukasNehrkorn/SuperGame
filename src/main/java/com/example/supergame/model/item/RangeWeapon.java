package com.example.supergame.model.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RangeWeapon extends Weapon {

    private int maxAmmunition;

    private int ammunitionInWeapon;

    public RangeWeapon(String name, double price, double damage, double accuracy, WeaponType weaponType, Rarity rarity, int maxAmmunition, int ammunition) {
        super(name, price, damage, accuracy, weaponType, rarity);
        this.maxAmmunition = maxAmmunition;
        this.ammunitionInWeapon = ammunition;
    }
}
