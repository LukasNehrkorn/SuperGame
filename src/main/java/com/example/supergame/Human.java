package com.example.supergame;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Human extends Player {
    public Human(String name, int maxHp, int currentHp, int maxDemonBlood, int currentDemonBlood, int accuracy ) {
        super(name, maxHp, currentHp, maxDemonBlood, currentDemonBlood, accuracy);
    }
}
