package com.example.supergame.items;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeleeWeapon extends Weapon {

    private double damageMultiplier;

    public MeleeWeapon(String name, double price, double damage, double accuracy, WeaponType weaponType, double damageMultiplier) {
        super(name, price, damage, accuracy, weaponType);
        this.damageMultiplier = damageMultiplier;
    }
}
