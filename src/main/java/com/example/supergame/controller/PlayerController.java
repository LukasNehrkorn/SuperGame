package com.example.supergame.controller;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.database.MissionInventory;
import com.example.supergame.model.Spell;
import com.example.supergame.model.dto.PlayerInfo;
import com.example.supergame.model.dto.PlayerStatus;
import com.example.supergame.model.dto.SpellId;
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
    public PlayerInfo newPlayer(@RequestBody PlayerInfo playerInfo) {
        return playerService.createNewPlayer(playerInfo);
    }

    @PutMapping("/{id}")
    public PlayerInfo updatePlayerInfo(@PathVariable String id, @RequestBody PlayerInfo playerInfo) {
        return playerService.updatePlayerInfo(id, playerInfo);
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
    public void updatePlayerStatus(@PathVariable String id, @RequestBody PlayerStatus playerStatus) {
        playerService.updatePlayerStatus(id, playerStatus);
    }

    // ---- SPELLS ----
    @GetMapping("/{id}/spells")
    public List<Spell> getPlayerSpells(@PathVariable String id) {
        return playerService.getSpells(id);
    }
}
