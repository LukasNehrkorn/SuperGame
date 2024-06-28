package com.example.supergame.model;


import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import com.example.supergame.model.dto.item.Weapon;
import com.example.supergame.model.enums.Rarity;
import com.example.supergame.model.enums.WeaponCategory;
import com.example.supergame.model.enums.WeaponType;

import java.util.ArrayList;
import java.util.List;

public class WeaponFactory {

    //Selects the type of weapon
    public Weapon createWeapon(List<Weapon> weaponList) {
//        int weaponTypeSelector = (int) (Math.random() * ((5 + 1)));
        int weaponTypeSelector = 1;
        if (weaponTypeSelector < 2) {
            return createRandomMeleeWeapon(weaponList);
        } else if (weaponTypeSelector < 4) {
            return createRandomRangeSecondaryWeapon();
        } else {
            return createRandomRangePrimaryWeapon();
        }
    }

    //Creates a random melee weapon
    public MeleeWeapon createRandomMeleeWeapon(List<Weapon> weaponList) {
        MeleeWeapon meleeWeapon = new MeleeWeapon(null, 0, 0, 100, WeaponCategory.MELEE,
                raritySelection(), 0);

        setWeaponStats(meleeWeapon);
        setWeaponName(meleeWeapon, weaponList);
        increaseDamageDependingOnWeaponType(meleeWeapon);
        return meleeWeapon;
    }

    //Creates a random Secondary Weapon
    public RangeWeapon createRandomRangeSecondaryWeapon() {
        RangeWeapon secondaryWeapon = new RangeWeapon(null, 0, 0, 0, WeaponCategory.SECONDARY,
                raritySelection(), setSecondaryWeaponType(), 0, 0);

        setAmmunition(secondaryWeapon);
        setWeaponStats(secondaryWeapon);
        increaseDamageDependingOnWeaponType(secondaryWeapon);
        return secondaryWeapon;
    }

    //Creates a random Primary Weapon
    public RangeWeapon createRandomRangePrimaryWeapon() {
        RangeWeapon primaryWeapon = new RangeWeapon(null, 0, 0, 0, WeaponCategory.PRIMARY,
                raritySelection(), setTypeForPrimaryWeapon(), 0, 0);
        setAmmunition(primaryWeapon);
        setWeaponStats(primaryWeapon);
        increaseDamageDependingOnWeaponType(primaryWeapon);
        return primaryWeapon;
    }

    //Set a Name for the Weapon
    public void setWeaponName(Weapon weapon, List<Weapon> weaponList) {
        List<String> weaponNames = new ArrayList<>();
        if (weapon.getWeaponCategory().equals(WeaponCategory.MELEE)) {
            for (Weapon weaponFromDB : weaponList) {
                if (weaponFromDB.getWeaponCategory().equals(WeaponCategory.MELEE)) {
                    weaponNames.add(weaponFromDB.getName());
                }
            }
        } else if (weapon.getWeaponCategory().equals(WeaponCategory.SECONDARY)) {
            for (Weapon weaponFromDB : weaponList) {
                if (weaponFromDB.getWeaponCategory().equals(WeaponCategory.SECONDARY)) {
                    weaponNames.add(weaponFromDB.getName());
                }
            }
        } else if (weapon.getWeaponCategory().equals(WeaponCategory.PRIMARY)) {
            for (Weapon weaponFromDB : weaponList) {
                if (weaponFromDB.getWeaponCategory().equals(WeaponCategory.PRIMARY)) {
                    weaponNames.add(weaponFromDB.getName());
                }
            }
        }
        int namePickNumber = (int) (Math.random() * (weaponNames.size()));
        weapon.setName(weaponNames.get(namePickNumber));
    }


    //Set the Rarity of the Weapon
    public Rarity raritySelection() {
        int weaponRaritySelector = (int) (Math.random() * ((100 + 1)));
        if (weaponRaritySelector < 60) {
            return Rarity.COMMON;
        } else if (weaponRaritySelector < 90) {
            return Rarity.RARE;
        } else {
            return Rarity.LEGENDARY;
        }
    }

    //Set Weapon type for Secondary Weapon
    public WeaponType setSecondaryWeaponType() {
        int secondaryWeaponTypeSelector = (int) (Math.random() * ((3)) + 1);
        if (secondaryWeaponTypeSelector == 1) {
            return WeaponType.PISTOL;
        } else if (secondaryWeaponTypeSelector == 2) {
            return WeaponType.SAWED_OFF_SHOTGUN;
        } else if (secondaryWeaponTypeSelector == 3) {
            return WeaponType.REVOLVER;
        }
        return null;
    }

    //Set Weapon type for Primary Weapon
    public WeaponType setTypeForPrimaryWeapon() {
        int primaryWeaponTypeSelector = (int) (Math.random() * ((4)) + 1);
        if (primaryWeaponTypeSelector == 1) {
            return WeaponType.ASSAULT_RIFLE;
        } else if (primaryWeaponTypeSelector == 2) {
            return WeaponType.SHOTGUN;
        } else if (primaryWeaponTypeSelector == 3) {
            return WeaponType.SNIPER;
        } else if (primaryWeaponTypeSelector == 4) {
            return WeaponType.BOLT_ACTION_RIFLE;
        }
        return null;
    }

    //Sets max Ammunition-Stats for Range Weapons
    public void setAmmunition(RangeWeapon rangeWeapon) {
        if (rangeWeapon.getWeaponType().equals(WeaponType.PISTOL)) {
            int pistolMagazineSize = 16;
            rangeWeapon.setMaxAmmunition(pistolMagazineSize);
            rangeWeapon.setAmmunitionInWeapon((int) (Math.random() * pistolMagazineSize));
        } else if (rangeWeapon.getWeaponType().equals(WeaponType.REVOLVER)) {
            int revolverMagazineSize = 6;
            rangeWeapon.setMaxAmmunition(revolverMagazineSize);
            rangeWeapon.setAmmunitionInWeapon((int) (Math.random() * revolverMagazineSize));
        } else if (rangeWeapon.getWeaponType().equals(WeaponType.SAWED_OFF_SHOTGUN)) {
            int swardOffShotgunMagazineSize = 2;
            rangeWeapon.setMaxAmmunition(swardOffShotgunMagazineSize);
            rangeWeapon.setAmmunitionInWeapon((int) (Math.random() * swardOffShotgunMagazineSize));
        } else if (rangeWeapon.getWeaponType().equals(WeaponType.ASSAULT_RIFLE)) {
            int assaultRifleMagazineSize = 24;
            rangeWeapon.setMaxAmmunition(assaultRifleMagazineSize);
            rangeWeapon.setAmmunitionInWeapon((int) (Math.random() * assaultRifleMagazineSize));
        } else if (rangeWeapon.getWeaponType().equals(WeaponType.BOLT_ACTION_RIFLE)) {
            int boltActionMagazineSize = 10;
            rangeWeapon.setMaxAmmunition(boltActionMagazineSize);
            rangeWeapon.setAmmunitionInWeapon((int) (Math.random() * boltActionMagazineSize));
        } else if (rangeWeapon.getWeaponType().equals(WeaponType.SHOTGUN)) {
            int shotgunMagazineSize = 2;
            rangeWeapon.setMaxAmmunition(shotgunMagazineSize);
            rangeWeapon.setAmmunitionInWeapon((int) (Math.random() * shotgunMagazineSize));
        } else if (rangeWeapon.getWeaponType().equals(WeaponType.SNIPER)) {
            int sniperMagazineSize = 1;
            rangeWeapon.setMaxAmmunition(sniperMagazineSize);
            rangeWeapon.setAmmunitionInWeapon((int) (Math.random() * sniperMagazineSize));
        }
    }

    //Sets stats for the Weapon depending on the Rarity
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
            weapon.setDamage((Math.random() * ((20 + 12))));
            weapon.setAccuracy((Math.random() * ((95 + 75) + 75)));
            weapon.setPrice((Math.random() * ((350 + 200) + 200)));
        }
    }

    //Gives a damage increase depending on the weapon type

    /**
     * This Method increases the Damage of a Weapon depending on the Weapon Type
     * @param weapon weapon that get increased
     */
    public boolean increaseDamageDependingOnWeaponType(Weapon weapon) {
        boolean success = false;
        if (weapon.getWeaponCategory().equals(WeaponCategory.MELEE)) {
            double newDamage = weapon.getDamage() / 0.4;
            weapon.setDamage(newDamage);
            success = true;
        } else if (weapon.getWeaponCategory().equals(WeaponCategory.SECONDARY)) {
            double newDamage = weapon.getDamage() / 0.3;
            weapon.setDamage(newDamage);
            success = true;
        } else if (weapon.getWeaponCategory().equals(WeaponCategory.PRIMARY)) {
            double newDamage = weapon.getDamage() / 0.2;
            weapon.setDamage(newDamage);
            success = true;
        }

        return success;
    }
}
