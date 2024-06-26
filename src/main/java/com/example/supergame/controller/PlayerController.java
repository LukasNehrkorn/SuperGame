package com.example.supergame.controller;

import com.example.supergame.model.dto.NewPlayerData;
import com.example.supergame.model.Player;
import com.example.supergame.model.item.Item;
import com.example.supergame.service.PlayerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable String id) {
        return service.getPlayer(id);
    }

    @PostMapping("/")
    public Player newPlayer(@RequestBody String newPlayerRequestBodyJSON) {
        try {
            return service.newPlayer(NewPlayerData.fromJSON(newPlayerRequestBodyJSON));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable String id) {
        service.deletePlayer(id);
    }
}
