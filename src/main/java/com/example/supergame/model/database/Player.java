package com.example.supergame.model.database;

import com.example.supergame.model.Job;
import com.example.supergame.model.Race;
import com.example.supergame.model.dto.PlayerInfo;
import com.example.supergame.model.dto.PlayerStatus;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "players")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {

    private String id;

    private String name;

    private Race race;

    private Job job;

    private int maxHp;

    private int currentHp;

    private int maxDemonBlood;

    private int currentDemonBlood;

    private int accuracy;

    private Inventory inventory;

    private List<String> spells;

    private MissionInventory missionInventory;

    public Player(String name, Race race, Job job) {
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

    public Player(PlayerInfo info) {
        this.name = info.getName();
        this.race = Race.valueOf(info.getRace());
        this.job = Job.valueOf(info.getJob());
        this.maxHp = 100;
        this.currentHp = maxHp;
        this.maxDemonBlood = 100;
        this.currentDemonBlood = maxDemonBlood;
        this.accuracy = 100;
        this.inventory = new Inventory();
        this.spells = null;
        this.missionInventory = null;
    }

    public PlayerInfo getPlayerInfo() {
        return new PlayerInfo(id, name, race.toString(), job.toString());
    }

    public PlayerStatus getPlayerStatus() {
        return new PlayerStatus(maxHp, currentHp, maxDemonBlood, currentDemonBlood, accuracy);
    }
}
