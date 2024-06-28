package com.example.supergame.model.dto.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeleeWeapon extends Weapon {

    private double damageMultiplier;

    public MeleeWeapon(String name, double price, double damage, double accuracy, WeaponCategory weaponCategory, Rarity rarity, double damageMultiplier) {
        super(name, price, damage, accuracy, weaponCategory, rarity);
        this.damageMultiplier = damageMultiplier;
    }
}
