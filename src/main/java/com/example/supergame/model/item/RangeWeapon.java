package com.example.supergame.model.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RangeWeapon extends Weapon{

    private int maxAmmunition;

    private int ammunition;

    public RangeWeapon(String name, double price, double damage, double accuracy, WeaponType weaponType, int maxAmmunition, int ammunition) {
        super(name, price, damage, accuracy, weaponType);
        this.maxAmmunition = maxAmmunition;
        this.ammunition = ammunition;
    }
}
