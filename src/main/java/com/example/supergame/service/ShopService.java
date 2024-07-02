package com.example.supergame.service;

import com.example.supergame.model.WeaponFactory;
import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.database.Player;
import com.example.supergame.model.database.WeaponName;
import com.example.supergame.model.dto.item.*;
import com.example.supergame.model.dto.Shop;
import com.example.supergame.model.enums.WeaponCategory;
import com.example.supergame.repository.items.WeaponNamesRepository;
import com.example.supergame.repository.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final PlayerRepository playerRepository;
    private final WeaponNamesRepository weaponsRepository;

    private Shop currentShop;

    @Autowired
    public ShopService(PlayerRepository playerRepository, WeaponNamesRepository weaponsRepository) {
        this.playerRepository = playerRepository;
        this.weaponsRepository = weaponsRepository;
    }

    public Shop getShop() {
        if (currentShop == null) createRandomShop();
        return currentShop;
    }

    public Weapon buyWeapon(String playerId, WeaponCategory weaponType) {
        if (currentShop == null) createRandomShop();

        Player player = playerRepository.findById(playerId).get();
        Inventory inventory = player.getInventory();

        Weapon weaponToBuy = weaponType == WeaponCategory.PRIMARY ?
                currentShop.getPrimaryWeapon() :
                weaponType == WeaponCategory.SECONDARY ?
                        currentShop.getSecondaryWeapon() :
                        currentShop.getMeleeWeapon();

        if (weaponToBuy.getPrice() > inventory.getMoney()) throw new RuntimeException("Price exceeds players funds!");
        inventory.setMoney(inventory.getMoney() - weaponToBuy.getPrice());

        inventory.getItems().add(weaponToBuy);
        playerRepository.save(player);

        createRandomShop();

        return weaponToBuy;
    }

    public Inventory sellItem(String playerId, int index) {
        Player player = playerRepository.findById(playerId).get();
        Inventory inventory = player.getInventory();

        List<Item> items = inventory.getItems();
        Item item = items.get(index);

        int price = item.getPrice() / 5;
        int currentMoney = inventory.getMoney();
        inventory.setMoney(currentMoney + price);

        items.remove(item);

        playerRepository.save(player);

        return player.getInventory();
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
