package com.example.supergame.controller;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.dto.item.Item;
import com.example.supergame.model.dto.Shop;
import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import com.example.supergame.model.dto.item.WeaponType;
import com.example.supergame.service.ShopService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/")
    public Shop getShop() {
        return shopService.getShop();
    }

    @PutMapping("/{playerId}/buy/primaryWeapon/")
    public RangeWeapon buyPrimaryWeapon(@PathVariable String playerId) {
        return (RangeWeapon) shopService.buyWeapon(playerId, WeaponType.PRIMARY);
    }

    @PutMapping("/{playerId}/buy/secondaryWeapon/")
    public RangeWeapon buySecondaryWeapon(@PathVariable String playerId) {
        return (RangeWeapon) shopService.buyWeapon(playerId, WeaponType.SECONDARY);
    }

    @PutMapping("/{playerId}/buy/meeleWeapon/")
    public MeleeWeapon buyMeleeWeapon(@PathVariable String playerId) {
        return (MeleeWeapon) shopService.buyWeapon(playerId, WeaponType.MELEE);
    }

    @PutMapping("/{playerId}/sell/{index}/")
    public Inventory sellItem(@PathVariable String playerId, @PathVariable int index) {
        return shopService.sellItem(playerId, index);
    }
}
