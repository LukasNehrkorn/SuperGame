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

    @PutMapping("/buy/primaryWeapon")
    public RangeWeapon buyPrimaryWeapon() {
        return (RangeWeapon) shopService.buyWeapon(WeaponType.PRIMARY);
    }

    @PutMapping("/buy/secondaryWeapon")
    public RangeWeapon buySecondaryWeapon() {
        return (RangeWeapon) shopService.buyWeapon(WeaponType.SECONDARY);
    }

    @PutMapping("/buy/meeleWeapon")
    public MeleeWeapon buyMeleeWeapon() {
        return (MeleeWeapon) shopService.buyWeapon(WeaponType.MELEE);
    }

    @PutMapping("/sell/")
    public Inventory sellItem(@RequestBody Item item) {
        return shopService.sellItem(item);
    }
}
