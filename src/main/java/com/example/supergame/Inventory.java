package com.example.supergame;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "inventories")
public class Inventory {
    @Id
    private Long id;

    private Long playerId;

    // private Item items;

    private int money;
}
