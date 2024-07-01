package com.example.supergame.model;

import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import com.example.supergame.model.dto.item.Weapon;
import com.example.supergame.model.enums.Rarity;
import com.example.supergame.model.enums.WeaponCategory;
import com.example.supergame.model.enums.WeaponType;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeaponFactoryTest {
    private WeaponFactory weaponFactory;

    @BeforeEach
    void setUp() {
        weaponFactory = new WeaponFactory();
    }

    @Test
    void createRandomMeleeWeapon() {

    }

    @Test
    void createRandomRangeSecondaryWeapon() {
    }

    @Test
    void createRandomRangePrimaryWeapon() {
    }

    @Test
    void setWeaponNameForMeleeWeaponTest() {
        //given
        List<Weapon> expectedWeaponList = new ArrayList<>();
        Weapon expected = new MeleeWeapon("Knife", 0, 0, 0, WeaponCategory.MELEE, null, 0);
        expectedWeaponList.add(expected);
        //when
        MeleeWeapon actually = weaponFactory.createRandomMeleeWeapon(expectedWeaponList);
        //then
        assertEquals(expected.getName(), actually.getName());
    }

    @Test
    void setWeaponNameForSecondaryWeaponTest() {
        //given
        List<Weapon> expectedWeaponList = new ArrayList<>();
        Weapon expected = new MeleeWeapon("Pistol", 0, 0, 0, WeaponCategory.SECONDARY, null, 0);
        expectedWeaponList.add(expected);
        //when
        RangeWeapon actually = weaponFactory.createRandomRangeSecondaryWeapon(expectedWeaponList);
        //then
        assertEquals(expected.getName(), actually.getName());
    }

    @Test
    void setWeaponNameForPrimaryWeaponTest() {
        //given
        List<Weapon> expectedWeaponList = new ArrayList<>();
        Weapon expected = new MeleeWeapon("AK", 0, 0, 0, WeaponCategory.PRIMARY, null, 0);
        expectedWeaponList.add(expected);
        //when
        RangeWeapon actually = weaponFactory.createRandomRangePrimaryWeapon(expectedWeaponList);
        //then
        assertEquals(expected.getName(), actually.getName());
    }

    @Test
    void raritySelectionForCommonTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("raritySelection", int.class);
        method.setAccessible(true);
        //when
        Rarity actually = (Rarity) method.invoke(weaponFactory, 32);
        //then
        assertEquals(Rarity.COMMON, actually);
    }

    @Test
    void raritySelectionForRareTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("raritySelection", int.class);
        method.setAccessible(true);
        //when
        Rarity actually = (Rarity) method.invoke(weaponFactory, 70);
        //then
        assertEquals(Rarity.RARE, actually);
    }

    @Test
    void raritySelectionForLegendaryTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("raritySelection", int.class);
        method.setAccessible(true);
        //when
        Rarity actually = (Rarity) method.invoke(weaponFactory, 95);
        //then
        assertEquals(Rarity.LEGENDARY, actually);
    }

    @Test
    void setSecondaryWeaponTypePistolTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setSecondaryWeaponType", int.class);
        method.setAccessible(true);
        //when
        WeaponType actually = (WeaponType) method.invoke(weaponFactory, 1);
        //then
        assertEquals(WeaponType.PISTOL, actually);
    }

    @Test
    void setSecondaryWeaponTypeSawedOffShotgunTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setSecondaryWeaponType", int.class);
        method.setAccessible(true);
        //when
        WeaponType actually = (WeaponType) method.invoke(weaponFactory, 2);
        //then
        assertEquals(WeaponType.SAWED_OFF_SHOTGUN, actually);
    }

    @Test
    void setSecondaryWeaponTypeRevolverTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setSecondaryWeaponType", int.class);
        method.setAccessible(true);
        //when
        WeaponType actually = (WeaponType) method.invoke(weaponFactory, 3);
        //then
        assertEquals(WeaponType.REVOLVER, actually);
    }

    @Test
    void setTypeForPrimaryWeaponAssaultRifleTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setTypeForPrimaryWeapon", int.class);
        method.setAccessible(true);
        //when
        WeaponType actually = (WeaponType) method.invoke(weaponFactory, 1);
        //then
        assertEquals(WeaponType.ASSAULT_RIFLE, actually);
    }

    @Test
    void setTypeForPrimaryWeaponShotgunTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setTypeForPrimaryWeapon", int.class);
        method.setAccessible(true);
        //when
        WeaponType actually = (WeaponType) method.invoke(weaponFactory, 2);
        //then
        assertEquals(WeaponType.SHOTGUN, actually);
    }

    @Test
    void setTypeForPrimaryWeaponSniperTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setTypeForPrimaryWeapon", int.class);
        method.setAccessible(true);
        //when
        WeaponType actually = (WeaponType) method.invoke(weaponFactory, 3);
        //then
        assertEquals(WeaponType.SNIPER, actually);
    }

    @Test
    void setTypeForPrimaryWeaponBoltActionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setTypeForPrimaryWeapon", int.class);
        method.setAccessible(true);
        //when
        WeaponType actually = (WeaponType) method.invoke(weaponFactory, 4);
        //then
        assertEquals(WeaponType.BOLT_ACTION_RIFLE, actually);
    }

    @Test
    void setAmmunitionForPistolTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setAmmunition", RangeWeapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, null, WeaponType.PISTOL, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertEquals(16, actually.getMaxAmmunition());
        assertTrue((0 <= actually.getAmmunitionInWeapon()) || (16 >= actually.getAmmunitionInWeapon()));
    }

    @Test
    void setAmmunitionForRevolverTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setAmmunition", RangeWeapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, null, WeaponType.REVOLVER, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertEquals(6, actually.getMaxAmmunition());
        assertTrue((0 <= actually.getAmmunitionInWeapon()) || (6 >= actually.getAmmunitionInWeapon()));
    }

    @Test
    void setAmmunitionForSawedOffShotgunTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setAmmunition", RangeWeapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, null, WeaponType.SAWED_OFF_SHOTGUN, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertEquals(2, actually.getMaxAmmunition());
        assertTrue((0 <= actually.getAmmunitionInWeapon()) || (2 >= actually.getAmmunitionInWeapon()));
    }

    @Test
    void setAmmunitionForAssaultRifleTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setAmmunition", RangeWeapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, null, WeaponType.ASSAULT_RIFLE, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertEquals(24, actually.getMaxAmmunition());
        assertTrue((0 <= actually.getAmmunitionInWeapon()) || (24 >= actually.getAmmunitionInWeapon()));
    }

    @Test
    void setAmmunitionForBoltActionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setAmmunition", RangeWeapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, null, WeaponType.BOLT_ACTION_RIFLE, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertEquals(10, actually.getMaxAmmunition());
        assertTrue((0 <= actually.getAmmunitionInWeapon()) || (10 >= actually.getAmmunitionInWeapon()));
    }

    @Test
    void setAmmunitionForShotgunTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setAmmunition", RangeWeapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, null, WeaponType.SHOTGUN, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertEquals(2, actually.getMaxAmmunition());
        assertTrue((0 <= actually.getAmmunitionInWeapon()) || (2 >= actually.getAmmunitionInWeapon()));
    }

    @Test
    void setAmmunitionForSniperTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setAmmunition", RangeWeapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, null, WeaponType.SNIPER, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertEquals(1, actually.getMaxAmmunition());
        assertTrue((0 <= actually.getAmmunitionInWeapon()) || (1 >= actually.getAmmunitionInWeapon()));
    }


    @Test
    void setWeaponStatsLegendaryTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setWeaponStats", Weapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, Rarity.LEGENDARY, WeaponType.SNIPER, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertTrue((12 <= actually.getDamage()) || (20 >= actually.getDamage()));
        assertTrue((75 <= actually.getAccuracy()) || (90 >= actually.getAccuracy()));
        assertTrue((200 <= actually.getPrice()) || (350 >= actually.getPrice()));
    }

    @Test
    void setWeaponStatsRareTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setWeaponStats", Weapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, Rarity.LEGENDARY, WeaponType.SNIPER, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertTrue((6 <= actually.getDamage()) || (11 >= actually.getDamage()));
        assertTrue((45 <= actually.getAccuracy()) || (69 >= actually.getAccuracy()));
        assertTrue((50 <= actually.getPrice()) || (150 >= actually.getPrice()));
    }

    @Test
    void setWeaponStatsCommonTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("setWeaponStats", Weapon.class);
        method.setAccessible(true);
        RangeWeapon actually = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, Rarity.LEGENDARY, WeaponType.SNIPER, 0, 0);
        //when
        method.invoke(weaponFactory, actually);
        //then
        assertTrue((3 <= actually.getDamage()) || (5 >= actually.getDamage()));
        assertTrue((20 <= actually.getAccuracy()) || (54 >= actually.getAccuracy()));
        assertTrue((30 <= actually.getPrice()) || (50 >= actually.getPrice()));
    }

    @Test
    void increaseDamageDependingOnWeaponTypeMeleeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("increaseDamageDependingOnWeaponType", Weapon.class);
        method.setAccessible(true);
        MeleeWeapon weapon = new MeleeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.MELEE, Rarity.LEGENDARY, 0);
        //when
        boolean actually = (boolean) method.invoke(weaponFactory, weapon);
        //then
        assertTrue(actually);
    }

    @Test
    void increaseDamageDependingOnWeaponTypeSecondaryTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("increaseDamageDependingOnWeaponType", Weapon.class);
        method.setAccessible(true);
        RangeWeapon weapon = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.SECONDARY, Rarity.LEGENDARY, WeaponType.SNIPER, 0, 0);
        //when
        boolean actually = (boolean) method.invoke(weaponFactory, weapon);
        //then
        assertTrue(actually);;
    }
    @Test
    void increaseDamageDependingOnWeaponTypePrimaryTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        val method = weaponFactory.getClass().getDeclaredMethod("increaseDamageDependingOnWeaponType", Weapon.class);
        method.setAccessible(true);
        RangeWeapon weapon = new RangeWeapon("TestWeapon", 0, 0, 0, WeaponCategory.PRIMARY, Rarity.LEGENDARY, WeaponType.SNIPER, 0, 0);
        //when
        boolean actually = (boolean) method.invoke(weaponFactory, weapon);
        //then
        assertTrue(actually);;
    }
}