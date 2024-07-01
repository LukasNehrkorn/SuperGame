package com.example.supergame.controller;


import com.example.supergame.model.dto.item.Weapon;
import com.example.supergame.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weapon")
public class WeaponController {
    private final WeaponService weaponService;

    @Autowired
    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping("/randomWeapon")
    public Weapon getPlayerInfo() {
        return weaponService.getRandomWeapon();
    }
}
