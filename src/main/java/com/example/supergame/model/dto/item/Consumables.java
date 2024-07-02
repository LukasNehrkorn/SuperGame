package com.example.supergame.model.dto.item;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Consumables")

public abstract class Consumables extends Item {


    Consumables(String name, int price) {
        super(name, price);
    }
}
