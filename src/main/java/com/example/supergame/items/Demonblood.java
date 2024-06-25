package com.example.supergame.items;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Demonblood extends Consumables{

    private int selfDamage;
    private int amount;

    Demonblood(String name, double price, int selfDamage, int amount) {
        super(name, price);
        this.selfDamage = selfDamage;
        this.amount = amount;
    }
}
