package com.example.supergame.service;

import com.example.supergame.model.Job;
import com.example.supergame.model.Race;
import com.example.supergame.model.Spell;
import com.example.supergame.model.database.Player;
import com.example.supergame.model.database.SpellDetails;
import com.example.supergame.model.database.SpellName;
import com.example.supergame.model.dto.PlayerInfo;
import com.example.supergame.model.dto.PlayerStatus;
import com.example.supergame.repository.PlayerRepository;
import com.example.supergame.repository.SpellDetailsRepository;
import com.example.supergame.repository.SpellNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final SpellNameRepository spellNameRepository;
    private final SpellDetailsRepository spellDetailsRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, SpellNameRepository spellNameRepository, SpellDetailsRepository spellDetailsRepository) {
        this.playerRepository = playerRepository;
        this.spellNameRepository = spellNameRepository;
        this.spellDetailsRepository = spellDetailsRepository;
    }

    // ---- PLAYER INFO ----
    public PlayerInfo getPlayerInfo(String id) {
        return playerRepository.findById(id).get().getPlayerInfo();
    }

    public PlayerInfo createNewPlayer(PlayerInfo playerInfo) {
        return playerRepository.save(new Player(playerInfo)).getPlayerInfo();
    }

    public PlayerInfo updatePlayerInfo(String id, PlayerInfo playerInfo) {
        Player player = playerRepository.findById(playerInfo.getId()).get();
        player.setName(playerInfo.getName());
        if (playerInfo.getRace() != null) player.setRace(Race.valueOf(playerInfo.getRace()));
        if (playerInfo.getJob() != null) player.setJob(Job.valueOf(playerInfo.getJob()));
        return playerRepository.save(player).getPlayerInfo();
    }

    public void deletePlayer(String id) {
        playerRepository.deleteById(id);
    }

    // ---- PLAYER STATUS ----
    public PlayerStatus getPlayerStatus(String id) {
        return playerRepository.findById(id).get().getPlayerStatus();
    }

    public PlayerStatus updatePlayerStatus(String id, PlayerStatus playerStatus) {
        Player player = playerRepository.findById(id).get();
        player.setMaxHp(playerStatus.getMaxHp());
        player.setCurrentHp(playerStatus.getCurrentHp());
        player.setMaxDemonBlood(playerStatus.getMaxDemonBlood());
        player.setCurrentDemonBlood(player.getCurrentDemonBlood());
        player.setAccuracy(playerStatus.getAccuracy());
        return playerRepository.save(player).getPlayerStatus();
    }

    // ---- PLAYER SPELLS ----
    public List<Spell> getSpells(String id) {
        List<String> spellIds = playerRepository.findById(id).get().getSpells();

        if (spellIds == null) return new ArrayList<>();

        List<Spell> spells = new ArrayList<>();

        for (String spellId : spellIds) {
            SpellName spellName = spellNameRepository.findById(spellId).get();
            SpellDetails spellDetails = spellDetailsRepository.findById(spellId).get();

            spells.add(Spell.builder().id(spellId).spellName(spellName
                            .getSpellName())
                    .spellDescription(spellDetails.getSpellDescription())
                    .damageToEnemy(spellDetails.getDamageToEnemy())
                    .demonBloodCost(spellDetails.getDemonBloodCost())
                    .build());
        }

        return spells;
    }
}
