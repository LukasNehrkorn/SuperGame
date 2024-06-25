package com.example.supergame.inventorys;

import com.example.supergame.items.Item;
import lombok.*;

@Data
@Builder
public class Inventory {

    private int playerId;

    private Item[] items;

    private int money;
}
