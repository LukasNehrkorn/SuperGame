package com.example.supergame.controller;

import com.example.supergame.model.Inventory;
import com.example.supergame.model.Spell;
import com.example.supergame.model.dto.PlayerInfo;
import com.example.supergame.model.dto.PlayerStatus;
import com.example.supergame.service.PlayerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // ---- PLAYER INFO ----
    @GetMapping("/{id}")
    public PlayerInfo getPlayerInfo(@PathVariable String id) {
        return playerService.getPlayerInfo(id);
    }

    @PostMapping("/")
    public void newPlayer(@RequestBody String playerInfoJSON) {
        Gson gson = new Gson();
        PlayerInfo playerInfo = gson.fromJson(playerInfoJSON, PlayerInfo.class);
        playerService.createNewPlayer(playerInfo);
    }

    @PutMapping("/{id}")
    public void updatePlayerInfo(@PathVariable String id, @RequestBody String playerInfoJSON) {
        Gson gson = new Gson();
        PlayerInfo playerInfo = gson.fromJson(playerInfoJSON, PlayerInfo.class);
        if (!Objects.equals(id, playerInfo.getId()))
            throw new RuntimeException("PathVariable id and RequestBody id are not the same!");
        playerService.updatePlayerInfo(playerInfo);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
    }

    // ---- PLAYER STATUS ----
    @GetMapping("/{id}/status")
    public PlayerStatus getPlayerStatus(@PathVariable String id) {
        return playerService.getPlayerStatus(id);
    }

    @PutMapping("/{id}/status")
    public void updatePlayerStatus(@PathVariable String id, @RequestBody String playerStatusJSON) {
        Gson gson = new Gson();
        PlayerStatus playerStatus = gson.fromJson(playerStatusJSON, PlayerStatus.class);
        playerService.updatePlayerStatus(id, playerStatus);
    }

    // ---- INVENTORY ----
    @GetMapping("/{id}/inventory/")
    public Inventory getPlayerInventory(@PathVariable String id) {
        return playerService.getInventory(id);
    }

    // ---- SPELLS ----
    @GetMapping("/{id}/spells")
    public List<Spell> getPlayerSpells(@PathVariable String id) {
        return playerService.getSpells(id);
    }

    @PutMapping("/{id}/spells")
    public void newPlayerSpell(@PathVariable String id, @RequestBody String spellJSON) {
    }

    @DeleteMapping("/{id}/spells/{spellIndex}")
    public void deletePlayerSpell(@PathVariable String id, @PathVariable int spellIndex) {
    }

    // ---- MISSION INVENTORY ----
    @GetMapping("/{id}/missionInventory/")
    public void getPlayerMissionInventory(@PathVariable String id) {
    }
}
