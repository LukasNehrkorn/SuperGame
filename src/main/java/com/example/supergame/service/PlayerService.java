package com.example.supergame.service;

import com.example.supergame.model.dto.NewPlayerData;
import com.example.supergame.model.Player;
import com.example.supergame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public Player getPlayer(String id) {
        return repository.findById(id).get();
    }

    public Player newPlayer(NewPlayerData newPlayerRequestBody) {
        Player player = Player.createNewPlayer(newPlayerRequestBody);
        return repository.save(player);
    }

    public void deletePlayer(String id) {
        repository.deleteById(id);
    }

}
