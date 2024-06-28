package com.example.supergame.service;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.dto.item.*;
import com.example.supergame.model.dto.Shop;
import com.example.supergame.repository.ConsumablesRepository;
import com.example.supergame.repository.WeaponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private final WeaponsRepository weaponsRepository;
    private final ConsumablesRepository consumablesRepository;

    private Shop currentShop;

    @Autowired
    public ShopService(WeaponsRepository weaponsRepository, ConsumablesRepository consumablesRepository) {
        this.weaponsRepository = weaponsRepository;
        this.consumablesRepository = consumablesRepository;

        createRandomShop();
    }

    public Shop getShop() {
        return null;
    }

    public Weapon buyWeapon(WeaponType weaponType) {
        return null;
    }

    public Inventory sellItem(Item item) {
        return null;
    }

    private void createRandomShop() {

    }
}
