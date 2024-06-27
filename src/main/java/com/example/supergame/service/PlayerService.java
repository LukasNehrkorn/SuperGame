package com.example.supergame.service;

import com.example.supergame.model.*;
import com.example.supergame.model.dto.PlayerInfo;
import com.example.supergame.model.dto.PlayerStatus;
import com.example.supergame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    // ---- PLAYER INFO ----
    public PlayerInfo getPlayerInfo(String id) {
        Player player = repository.findById(id).get();
        return new PlayerInfo(player.getId(), player.getName(), player.getRace().toString(), player.getJob().toString());
    }

    public void createNewPlayer(PlayerInfo playerInfo) {
        repository.save(Player.createNewPlayer(playerInfo));
    }

    public void updatePlayerInfo(PlayerInfo playerInfo) {
        Player player = repository.findById(playerInfo.getId()).get();
        player.setName(playerInfo.getName());
        if (playerInfo.getRace() != null) player.setRace(Race.valueOf(playerInfo.getRace()));
        if (playerInfo.getJob() != null) player.setJob(Job.valueOf(playerInfo.getJob()));
        repository.save(player);
    }

    public void deletePlayer(String id) {
        repository.deleteById(id);
    }

    // ---- PLAYER STATUS ----
    public PlayerStatus getPlayerStatus(String id) {
        Player player = repository.findById(id).get();
        return new PlayerStatus(player.getMaxHp(), player.getCurrentHp(), player.getMaxDemonBlood(), player.getCurrentDemonBlood(), player.getAccuracy());
    }

    public void updatePlayerStatus(String id, PlayerStatus playerStatus) {
        Player player = repository.findById(id).get();
        player.setMaxHp(playerStatus.getMaxHp());
        player.setCurrentHp(playerStatus.getCurrentHp());
        player.setMaxDemonBlood(playerStatus.getMaxDemonBlood());
        player.setCurrentDemonBlood(player.getCurrentDemonBlood());
        player.setAccuracy(playerStatus.getAccuracy());
        repository.save(player);
    }

    // ---- PLAYER INVENTORY ----
    public Inventory getInventory(String id) {
        return repository.findById(id).get().getInventory();
    }

    // ---- PLAYER SPELLS ----
    public List<Spell> getSpells(String id) {
        return repository.findById(id).get().getSpells();
    }

    public void addSpell(String id, Spell spell) {
        Player player = repository.findById(id).get();

    }
}
