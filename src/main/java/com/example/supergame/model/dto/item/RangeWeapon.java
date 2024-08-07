package com.example.supergame.model.dto.item;

import com.example.supergame.model.enums.Rarity;
import com.example.supergame.model.enums.WeaponCategory;
import com.example.supergame.model.enums.WeaponType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RangeWeapon extends Weapon {

    private int maxAmmunition;

    private int ammunitionInWeapon;

    private WeaponType weaponType;

    public RangeWeapon(String name, int price, double damage, double accuracy, WeaponCategory weaponCategory,
                       Rarity rarity, WeaponType weaponType, int maxAmmunition, int ammunition) {
        super(name, price, damage, accuracy, weaponCategory, rarity);
        this.weaponType = weaponType;
        this.maxAmmunition = maxAmmunition;
        this.ammunitionInWeapon = ammunition;
    }
}
