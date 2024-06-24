package com.example.supergame;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    private int id;

    private int playerId;

    // private Item items;

    private int money;
}
