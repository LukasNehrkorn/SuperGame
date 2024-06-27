package com.example.supergame.model.database;

import com.example.supergame.model.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Inventory {

    private Item[] items;

    private int money;

}
