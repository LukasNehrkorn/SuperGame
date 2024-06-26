package com.example.supergame.model;


import com.example.supergame.model.dto.NewPlayerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Player")
@Getter
@Setter
public class Player {

    private String name;

    private Race race;

    private Job job;

    private int maxHp;

    private int currentHp;

    private int maxDemonBlood;

    private int currentDemonBlood;

    private int accuracy;

    private Inventory inventory;

    private Spell[] spells;

    private MissionInventory missionInventory;

    private Player(String name, Race race, Job job) {
        this.name = name;
        this.race = race;
        this.job = job;
        this.maxHp = 100;
        this.currentHp = maxHp;
        this.maxDemonBlood = 100;
        this.currentDemonBlood = maxDemonBlood;
        this.accuracy = 100;
        this.inventory = new Inventory();
        this.spells = null;
        this.missionInventory = null;
    }

    public static Player createNewPlayer(NewPlayerData newPlayerRequestBody) {
        return new Player(newPlayerRequestBody.getName(), newPlayerRequestBody.getRace(), newPlayerRequestBody.getJob());
    }

}
