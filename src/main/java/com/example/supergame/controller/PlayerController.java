package com.example.supergame.controller;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.database.Player;
import com.example.supergame.model.dto.PlayerInfo;
import com.example.supergame.model.dto.PlayerStatus;
import com.example.supergame.model.dto.Spell;
import com.example.supergame.model.dto.item.Item;
import com.example.supergame.service.PlayerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // ---- PLAYER INFO ----
    @RequestMapping(value = "/savegames/{desktopName}")
    public List<PlayerInfo> getSavegames(@PathVariable String desktopName) {
        return playerService.getAllSavegamesByDesktopName(desktopName);
    }

    @GetMapping("/{id}")
    public PlayerInfo getPlayerInfo(@PathVariable String id) {
        return playerService.getPlayerInfo(id);
    }

    @PostMapping("/newPlayer")
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

    // ---- PLAYER INVENTORY ----
    @PutMapping("/{id}/inventory/buy/")
    public Inventory buyItem(@PathVariable String id, @RequestBody Item item) {
        return playerService.buyItem(id, item);
    }

    @PutMapping("/{id}/inventory/sell/{index}")
    public Inventory sellItem(@PathVariable String id, @PathVariable int index) {
        return playerService.sellItem(id, index);
    }

    // ---- SPELLS ----
    @GetMapping("/{id}/spells")
    public List<Spell> getPlayerSpells(@PathVariable String id) {
        return playerService.getSpells(id);
    }
}
