package com.example.supergame.service;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.dto.Shop;
import com.example.supergame.model.dto.item.Item;
import com.example.supergame.model.dto.item.Weapon;
import com.example.supergame.model.enums.WeaponCategory;
import com.example.supergame.repository.ConsumablesRepository;
import com.example.supergame.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private final WeaponRepository weaponsRepository;
    private final ConsumablesRepository consumablesRepository;

    private Shop currentShop;

    @Autowired
    public ShopService(WeaponRepository weaponsRepository, ConsumablesRepository consumablesRepository) {
        this.weaponsRepository = weaponsRepository;
        this.consumablesRepository = consumablesRepository;

        createRandomShop();
    }

    public Shop getShop() {
        return null;
    }

    public Weapon buyWeapon(WeaponCategory weaponCategory) {
        return null;
    }

    public Inventory sellItem(Item item) {
        return null;
    }

    private void createRandomShop() {

    }
}
