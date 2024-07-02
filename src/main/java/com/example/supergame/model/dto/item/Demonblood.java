package com.example.supergame.model.dto.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Demonblood extends Consumables {

    private int selfDamage;

    private int amount;

    Demonblood(String name, int price, int selfDamage, int amount) {
        super(name, price);
        this.selfDamage = selfDamage;
        this.amount = amount;
    }
}
