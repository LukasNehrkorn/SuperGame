package com.example.supergame.service;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.database.Player;
import com.example.supergame.model.database.SpellDetails;
import com.example.supergame.model.database.SpellName;
import com.example.supergame.model.dto.PlayerInfo;
import com.example.supergame.model.dto.PlayerStatus;
import com.example.supergame.model.dto.Spell;
import com.example.supergame.model.dto.item.Item;
import com.example.supergame.model.enums.Job;
import com.example.supergame.model.enums.Race;
import com.example.supergame.repository.player.PlayerRepository;
import com.example.supergame.repository.player.SpellDetailsRepository;
import com.example.supergame.repository.player.SpellNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<PlayerInfo> getAllSavegamesByDesktopName(String desktopName) {
        List<Player> players = playerRepository.findAll();
        List<PlayerInfo> playerInfos = new ArrayList<>();
        for (Player player : players) {
            if (Objects.equals(player.getDesktopName(), desktopName)) playerInfos.add(player.getPlayerInfo());
        }
        return playerInfos;
    }

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

    // ---- PLAYER INVENTORY ----
    public Inventory buyItem(String id, Item item) {
        Player player = playerRepository.findById(id).get();
        Inventory inventory = player.getInventory();

        if (item.getPrice() > inventory.getMoney()) throw new RuntimeException("Price exceeds players funds!");
        inventory.setMoney(inventory.getMoney() - item.getPrice());

        inventory.getItems().add(item);
        return playerRepository.save(player).getInventory();
    }

    public Inventory sellItem(String id, int index) {
        Player player = playerRepository.findById(id).get();
        Inventory inventory = player.getInventory();

        List<Item> items = inventory.getItems();
        Item item = items.get(index);

        int price = item.getPrice() / 5;
        int currentMoney = inventory.getMoney();
        inventory.setMoney(currentMoney + price);

        items.remove(item);

        return playerRepository.save(player).getInventory();
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
