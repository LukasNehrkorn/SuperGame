package com.example.supergame.model.dto.item;


import com.example.supergame.model.enums.Rarity;
import com.example.supergame.model.enums.WeaponCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection ="Weapons")
public abstract class Weapon extends Item {

    private double damage;

    private double accuracy;

    private WeaponCategory weaponCategory;

    private Rarity rarity;

    public Weapon(String name, double price, double damage, double accuracy, WeaponCategory weaponCategory, Rarity rarity) {
        super(name, price);
        this.damage = damage;
        this.accuracy = accuracy;
        this.weaponCategory = weaponCategory;
        this.rarity = rarity;
    }
}
