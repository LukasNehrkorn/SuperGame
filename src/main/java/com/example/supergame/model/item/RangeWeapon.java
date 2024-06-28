package com.example.supergame.model.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RangeWeapon extends Weapon {

    private int maxAmmunition;

    private int ammunitionInWeapon;

    private WeaponType weaponType;

    public RangeWeapon(String name, double price, double damage, double accuracy, WeaponCategory weaponCategory,
                       Rarity rarity, WeaponType weaponType, int maxAmmunition, int ammunition) {
        super(name, price, damage, accuracy, weaponCategory, rarity);
        this.weaponType = weaponType;
        this.maxAmmunition = maxAmmunition;
        this.ammunitionInWeapon = ammunition;
    }
}
