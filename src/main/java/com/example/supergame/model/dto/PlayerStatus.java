package com.example.supergame.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerStatus {
    private int maxHp;
    private int currentHp;
    private int maxDemonBlood;
    private int currentDemonBlood;
    private int accuracy;
}
