package com.example.supergame.service;

import com.example.supergame.model.WeaponFactory;
import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.database.Player;
import com.example.supergame.model.database.WeaponName;
import com.example.supergame.model.dto.Shop;
import com.example.supergame.model.dto.item.Item;
import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import com.example.supergame.model.dto.item.Weapon;
import com.example.supergame.model.enums.WeaponCategory;
import com.example.supergame.repository.items.WeaponNamesRepository;
import com.example.supergame.repository.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final WeaponNamesRepository weaponsRepository;

    private Shop currentShop;

    @Autowired
    public ShopService(PlayerRepository playerRepository, WeaponNamesRepository weaponsRepository) {
        this.weaponsRepository = weaponsRepository;
    }

    public Shop getShop() {
        if (currentShop == null) createRandomShop();
        return currentShop;
    }

    private void createRandomShop() {
        List<WeaponName> weaponNames = weaponsRepository.findAll();

        WeaponFactory weaponFactory = new WeaponFactory();
        RangeWeapon primaryWeapon = weaponFactory.createRandomRangePrimaryWeapon(weaponNames);
        RangeWeapon secondaryWeapon = weaponFactory.createRandomRangeSecondaryWeapon(weaponNames);
        MeleeWeapon meleeWeapon = weaponFactory.createRandomMeleeWeapon(weaponNames);

        currentShop = new Shop(primaryWeapon, secondaryWeapon, meleeWeapon);
    }
}
