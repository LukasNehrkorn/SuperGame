package com.example.supergame.model.database;

import com.example.supergame.model.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    private List<Item> items;

    private int money;

}
