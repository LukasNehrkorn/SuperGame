package com.example.supergame.items;


import lombok.Builder;
import lombok.Data;


public abstract class Consumables extends Item{


    Consumables(String name, double price) {
        super(name, price);
    }
}
