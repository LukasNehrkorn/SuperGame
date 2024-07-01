package com.example.supergame.model;


import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import com.example.supergame.model.dto.item.Weapon;
import com.example.supergame.model.enums.Rarity;
import com.example.supergame.model.enums.WeaponCategory;
import com.example.supergame.model.enums.WeaponType;
import org.testcontainers.shaded.com.google.common.annotations.VisibleForTesting;


import java.util.ArrayList;
import java.util.List;

import static com.mongodb.internal.VisibleForTesting.AccessModifier.*;

public class WeaponFactory {

    //Selects the type of weapon
    public Weapon createWeapon(List<Weapon> weaponList) {
        int weaponTypeSelector = randomizer("Rarity");
        if (weaponTypeSelector < 2) {
            return createRandomMeleeWeapon(weaponList);
        } else if (weaponTypeSelector < 4) {
            return createRandomRangeSecondaryWeapon(weaponList);
        } else {
            return createRandomRangePrimaryWeapon(weaponList);
        }
    }

    //Creates a random melee weapon
    public MeleeWeapon createRandomMeleeWeapon(List<Weapon> weaponList) {
        MeleeWeapon meleeWeapon = new MeleeWeapon(null, 0, 0, 100, WeaponCategory.MELEE,
                raritySelection(randomizer("Rarity")), 0);

        setWeaponName(meleeWeapon, weaponList);
        setWeaponStats(meleeWeapon);
        increaseDamageDependingOnWeaponType(meleeWeapon);
        return meleeWeapon;
    }

    //Creates a random Secondary Weapon

    public RangeWeapon createRandomRangeSecondaryWeapon(List<Weapon> weaponList) {
        RangeWeapon secondaryWeapon = new RangeWeapon(null, 0, 0, 0, WeaponCategory.SECONDARY,
                raritySelection(randomizer("Rarity")), setSecondaryWeaponType(randomizer("Secondary")), 0, 0);

        setWeaponName(secondaryWeapon, weaponList);
        setAmmunition(secondaryWeapon);
        setWeaponStats(secondaryWeapon);
        increaseDamageDependingOnWeaponType(secondaryWeapon);
        return secondaryWeapon;
    }
    //Creates a random Primary Weapon

    public RangeWeapon createRandomRangePrimaryWeapon(List<Weapon> weaponList) {
        RangeWeapon primaryWeapon = new RangeWeapon(null, 0, 0, 0, WeaponCategory.PRIMARY,
                raritySelection(randomizer("Rarity")), setTypeForPrimaryWeapon(randomizer("Primary")), 0, 0);
        setWeaponName(primaryWeapon, weaponList);
        setAmmunition(primaryWeapon);
        setWeaponStats(primaryWeapon);
        increaseDamageDependingOnWeaponType(primaryWeapon);
        return primaryWeapon;
    }

    private int randomizer(String kind) {
        switch (kind) {
            case "Rarity" : return  (int) (Math.random() * ((100 + 1)));
            case "Type" : return (int) (Math.random() * ((5 + 1)));
            case "Secondary" : return (int) (Math.random() * ((3)) + 1);
            case "Primary" : return (int) (Math.random() * ((4)) + 1);
            default: return 0;
        }
    }

    //Set a Name for the Weapon
    private void setWeaponName(Weapon weapon, List<Weapon> weaponList) {
        List<String> weaponNames = new ArrayList<>();
            for (Weapon weaponFromDB : weaponList) {
                if (weaponFromDB.getWeaponCategory().equals(weapon.getWeaponCategory())) {
                    weaponNames.add(weaponFromDB.getName());
                }
            }
        int namePickNumber = (int) (Math.random() * (weaponNames.size()));
        weapon.setName(weaponNames.get(namePickNumber));
    }


    //Set the Rarity of the Weapon
    private Rarity raritySelection(int weaponRaritySelector) {
        if (weaponRaritySelector > 90) {
            return Rarity.LEGENDARY;
        } else if (weaponRaritySelector > 60) {
            return Rarity.RARE;
        } else {
            return Rarity.COMMON;
        }
    }

    //Set Weapon type for Secondary Weapon
    private WeaponType setSecondaryWeaponType(int secondaryWeaponTypeSelector) {
        if (secondaryWeaponTypeSelector == 1) {
            return WeaponType.PISTOL;
        } else if (secondaryWeaponTypeSelector == 2) {
            return WeaponType.SAWED_OFF_SHOTGUN;
        } else {
            return WeaponType.REVOLVER;
        }
    }

    //Set Weapon type for Primary Weapon
    private WeaponType setTypeForPrimaryWeapon(int primaryWeaponTypeSelector) {
        if (primaryWeaponTypeSelector == 1) {
            return WeaponType.ASSAULT_RIFLE;
        } else if (primaryWeaponTypeSelector == 2) {
            return WeaponType.SHOTGUN;
        } else if (primaryWeaponTypeSelector == 3) {
            return WeaponType.SNIPER;
        } else {
            return WeaponType.BOLT_ACTION_RIFLE;
        }
    }

    //Sets max Ammunition-Stats for Range Weapons
    private void setAmmunition(RangeWeapon rangeWeapon) {
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
    private void setWeaponStats(Weapon weapon) {
        if (weapon.getRarity().equals(Rarity.LEGENDARY)) {
            weapon.setDamage((Math.random() * ((20 + 12))));
            weapon.setAccuracy((Math.random() * ((95 + 75) + 75)));
            weapon.setPrice((Math.random() * ((350 + 200) + 200)));
        } else if (weapon.getRarity().equals(Rarity.RARE)) {
            weapon.setDamage((Math.random() * ((11 + 6) + 1)));
            weapon.setAccuracy((Math.random() * ((69 + 45) + 1)));
            weapon.setPrice((Math.random() * ((150 + 50) + 1)));
        } else {
            weapon.setDamage((Math.random() * ((5 + 3) + 1)));
            weapon.setAccuracy((Math.random() * ((54 + 20) + 1)));
            weapon.setPrice((Math.random() * ((50 + 30) + 1)));
        }
    }

    //Gives a damage increase depending on the weapon type
    /**
     * This Method increases the Damage of a Weapon depending on the Weapon Type
     *
     * @param weapon weapon that get increased
     */
    private boolean increaseDamageDependingOnWeaponType(Weapon weapon) {
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
