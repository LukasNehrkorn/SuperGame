package com.example.supergame.items;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public abstract class Item {
    private String name;
    private double price;
}
