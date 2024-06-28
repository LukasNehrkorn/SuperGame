package com.example.supergame.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerInfo {
    private String id;
    private String name;
    private String race;
    private String job;

}
