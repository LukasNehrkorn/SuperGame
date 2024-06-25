package com.example.supergame.items;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public abstract class Item {

    private String name;

    private double price;
}
