package com.example.supergame.model;

import com.example.supergame.model.item.*;


public class WeaponFactory {
    //Create a random Weapon of a special type
    public Weapon createWeapon() {
        int weaponTypeSelector = (int) (Math.random() * ((5 + 1)));
        if (weaponTypeSelector < 2) {
            return createRandomMeleeWeapon();
        } else if (weaponTypeSelector < 4) {
            return createRandomRangeSecondaryWeapon();
        } else {
            return createRandomRangePrimaryWeapon();
        }
    }
    //Create a Melee Weapon
    public MeleeWeapon createRandomMeleeWeapon() {
        MeleeWeapon meleeWeapon = new MeleeWeapon(null, 0, 0, 0, WeaponType.MELEE,
                null, 0);

        raritySelection(meleeWeapon);
        setWeaponStats(meleeWeapon);
        meleeWeapon.setAccuracy(100);
        increaseDamageDependingOnWeaponType(meleeWeapon);
        return meleeWeapon;
    }
    //Create a Secondary Weapon
    public RangeWeapon createRandomRangeSecondaryWeapon() {
        RangeWeapon secondaryWeapon = new RangeWeapon(null, 0, 0, 0, WeaponType.SECONDARY,
                null, 0, 0);

        raritySelection(secondaryWeapon);
        setWeaponStats(secondaryWeapon);
        increaseDamageDependingOnWeaponType(secondaryWeapon);
        return secondaryWeapon;
    }
    //Create a Primary Weapon
    public RangeWeapon createRandomRangePrimaryWeapon() {
        RangeWeapon primaryWeapon = new RangeWeapon(null, 0, 0, 0, WeaponType.PRIMARY,
                null, 0, 0);

        raritySelection(primaryWeapon);
        setWeaponStats(primaryWeapon);
        increaseDamageDependingOnWeaponType(primaryWeapon);
        return primaryWeapon;
    }
    //Set the Rarity of the Weapon
    public void raritySelection(Weapon weapon) {
        int weaponRaritySelector = (int) (Math.random() * ((100 + 1)));
        if (weaponRaritySelector < 60) {
            weapon.setRarity(Rarity.COMMON);
        } else if (weaponRaritySelector < 90) {
            weapon.setRarity(Rarity.RARE);
        } else {
            weapon.setRarity(Rarity.LEGENDARY);
        }
    }
    //Set the Weapon stats
    public void setWeaponStats(Weapon weapon) {
        if (weapon.getRarity().equals(Rarity.COMMON)) {
            weapon.setDamage((Math.random() * ((5 + 3) + 1)));
            weapon.setAccuracy((Math.random() * ((54 + 20) + 1)));
            weapon.setPrice((Math.random() * ((50 + 30) + 1)));
        } else if (weapon.getRarity().equals(Rarity.RARE)) {
            weapon.setDamage((Math.random() * ((11 + 6) + 1)));
            weapon.setAccuracy((Math.random() * ((69 + 45) + 1)));
            weapon.setPrice((Math.random() * ((150 + 50) + 1)));
        } else if (weapon.getRarity().equals(Rarity.LEGENDARY)) {
            weapon.setDamage((Math.random() * ((20 + 12) + 1)));
            weapon.setAccuracy((Math.random() * ((95 + 75) + 1)));
            weapon.setPrice((Math.random() * ((350 + 200) + 1)));
        }
    }
    //Gives a Damage budd depending on the Weapon Type
    public void increaseDamageDependingOnWeaponType(Weapon weapon) {
        if (weapon.getWeaponType().equals(WeaponType.MELEE)) {
            double newDamage = weapon.getDamage() / 0.4;
            weapon.setDamage(newDamage);
        } else if (weapon.getWeaponType().equals(WeaponType.SECONDARY)) {
            double newDamage = weapon.getDamage() / 0.3;
            weapon.setDamage(newDamage);
        } else if (weapon.getWeaponType().equals(WeaponType.PRIMARY)) {
            double newDamage = weapon.getDamage() / 0.2;
            weapon.setDamage(newDamage);
        }


    }
}
