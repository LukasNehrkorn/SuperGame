package com.example.supergame.players;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Angel extends Human {
    public Angel(String name, int maxHp, int currentHp, int maxDemonBlood, int currentDemonBlood, int accuracy ) {
        super(name, maxHp, currentHp, maxDemonBlood, currentDemonBlood, accuracy);
    }
}
