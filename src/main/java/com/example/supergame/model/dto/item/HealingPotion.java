package com.example.supergame.model.dto.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealingPotion extends Consumables {

    private int healing;

    HealingPotion(String name, double price, int healing) {
        super(name, price);
        this.healing = healing;
    }
}
