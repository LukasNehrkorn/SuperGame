package com.example.supergame.service;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.database.Player;
import com.example.supergame.model.dto.item.*;
import com.example.supergame.model.dto.Shop;
import com.example.supergame.repository.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final PlayerRepository playerRepository;

    private Shop currentShop;

    @Autowired
    public ShopService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

        createRandomShop();
    }

    public Shop getShop() {
        return currentShop;
    }

    public Weapon buyWeapon(String playerId, WeaponType weaponType) {
        Player player = playerRepository.findById(playerId).get();
        Inventory inventory = player.getInventory();

        Weapon weaponToBuy = weaponType == WeaponType.PRIMARY ? currentShop.getPrimaryWeapon() : weaponType == WeaponType.SECONDARY ? currentShop.getSecondaryWeapon() : currentShop.getMeleeWeapon();

        if (weaponToBuy.getPrice() > inventory.getMoney()) throw new RuntimeException("Price exceeds players funds!");
        inventory.setMoney(inventory.getMoney() - weaponToBuy.getPrice());

        inventory.getItems().add(weaponToBuy);

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
        //TODO: Connection to WeaponFactory
    }
}
