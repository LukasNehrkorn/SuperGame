package com.example.supergame.service;

import com.example.supergame.model.WeaponFactory;
import com.example.supergame.model.dto.item.Weapon;
import com.example.supergame.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    @Autowired
    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }
    public Weapon getRandomWeapon() {
        WeaponFactory weaponFactory = new WeaponFactory();
        Weapon weapon = weaponFactory.createWeapon(weaponRepository.findAll());
        System.out.println(weapon);
        return weapon;
    }

}

