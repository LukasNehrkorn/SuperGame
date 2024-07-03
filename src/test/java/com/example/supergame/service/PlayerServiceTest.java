package com.example.supergame.service;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.database.Player;
import com.example.supergame.model.database.SpellDetails;
import com.example.supergame.model.database.SpellName;
import com.example.supergame.model.dto.PlayerInfo;
import com.example.supergame.model.dto.PlayerStatus;
import com.example.supergame.model.dto.Spell;
import com.example.supergame.repository.player.PlayerRepository;
import com.example.supergame.repository.player.SpellDetailsRepository;
import com.example.supergame.repository.player.SpellNameRepository;
import com.example.supergame.testdata.TestDataFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private SpellNameRepository spellNameRepository;

    @Mock
    private SpellDetailsRepository spellDetailsRepository;

    @InjectMocks
    private PlayerService service;

    private final TestDataFactory testDataFactory = new TestDataFactory();

    @Test
    void getPlayerInfo() {
        Player expectedPlayer = testDataFactory.getPlayer();
        when(playerRepository.findById(expectedPlayer.getId())).thenReturn(Optional.of(expectedPlayer));

        PlayerInfo actualPlayerInfo = service.getPlayerInfo(expectedPlayer.getId());

        assertEquals(expectedPlayer.getPlayerInfo(), actualPlayerInfo);
    }

    @Test
    public void createNewPlayer() {
        Player expectedPlayer = testDataFactory.getPlayer();
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(expectedPlayer);

        PlayerInfo actualPlayerInfo = service.createNewPlayer(expectedPlayer.getPlayerInfo());

        assertEquals(expectedPlayer.getName(), actualPlayerInfo.getName());
        assertEquals(expectedPlayer.getRace().toString(), actualPlayerInfo.getRace());
        assertEquals(expectedPlayer.getJob().toString(), actualPlayerInfo.getJob());
    }

    @Test
    void updatePlayerInfo() {
        Player expectedPlayer = testDataFactory.getPlayer();
        when(playerRepository.findById(expectedPlayer.getId())).thenReturn(Optional.of(expectedPlayer));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(expectedPlayer);

        PlayerInfo actualPlayerInfo = service.updatePlayerInfo(testDataFactory.getPlayer().getPlayerInfo().getId(), testDataFactory.getPlayer().getPlayerInfo());

        assertEquals(expectedPlayer.getName(), actualPlayerInfo.getName());
        assertEquals(expectedPlayer.getRace().toString(), actualPlayerInfo.getRace());
        assertEquals(expectedPlayer.getJob().toString(), actualPlayerInfo.getJob());
    }

    @Test
    void getPlayerStatus() {
        Player expectedPlayer = testDataFactory.getPlayer();
        when(playerRepository.findById(expectedPlayer.getId())).thenReturn(Optional.of(expectedPlayer));

        PlayerStatus actualPlayerStatus = service.getPlayerStatus(expectedPlayer.getId());

        assertEquals(actualPlayerStatus.getMaxHp(), expectedPlayer.getMaxHp());
        assertEquals(actualPlayerStatus.getCurrentHp(), expectedPlayer.getCurrentHp());
        assertEquals(actualPlayerStatus.getMaxDemonBlood(), expectedPlayer.getMaxDemonBlood());
        assertEquals(actualPlayerStatus.getCurrentDemonBlood(), expectedPlayer.getCurrentDemonBlood());
        assertEquals(actualPlayerStatus.getAccuracy(), expectedPlayer.getAccuracy());
    }

    @Test
    void updatePlayerStatus() {
        Player expectedPlayer = testDataFactory.getPlayer();
        when(playerRepository.findById(expectedPlayer.getId())).thenReturn(Optional.of(expectedPlayer));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(expectedPlayer);

        PlayerStatus actualPlayerStatus = service.updatePlayerStatus(expectedPlayer.getId(), expectedPlayer.getPlayerStatus());

        assertEquals(actualPlayerStatus.getMaxHp(), expectedPlayer.getMaxHp());
        assertEquals(actualPlayerStatus.getCurrentHp(), expectedPlayer.getCurrentHp());
        assertEquals(actualPlayerStatus.getMaxDemonBlood(), expectedPlayer.getMaxDemonBlood());
        assertEquals(actualPlayerStatus.getCurrentDemonBlood(), expectedPlayer.getCurrentDemonBlood());
        assertEquals(actualPlayerStatus.getAccuracy(), expectedPlayer.getAccuracy());
    }

    @Test
    void buyItemTest() {
        Player expectedPlayer = testDataFactory.getPlayer();
        when(playerRepository.findById(expectedPlayer.getId())).thenReturn(Optional.of(expectedPlayer));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(expectedPlayer);

        Inventory actualInventory = service.buyItem(expectedPlayer.getId(), testDataFactory.getMeleeWeapon());

        assertEquals(actualInventory.getItems().size(), 4);
    }

    @Test
    void sellItemTest() {
        Player expectedPlayer = testDataFactory.getPlayer();
        when(playerRepository.findById(expectedPlayer.getId())).thenReturn(Optional.of(expectedPlayer));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(expectedPlayer);

        Inventory actualInventory = service.sellItem(expectedPlayer.getId(), 0);

        assertEquals(actualInventory.getItems().size(), 2);
    }

    @Test
    void getSpellsTest() {
        Player expectedPlayer = testDataFactory.getPlayer();
        SpellName expectedSpellName = testDataFactory.getSpellName();
        SpellDetails expectedSpellDetails = testDataFactory.getSpellDetails();
        when(playerRepository.findById(expectedPlayer.getId())).thenReturn(Optional.of(expectedPlayer));
        when(spellNameRepository.findById(expectedSpellName.getId())).thenReturn(Optional.of(expectedSpellName));
        when(spellDetailsRepository.findById(expectedSpellDetails.getId())).thenReturn(Optional.of(expectedSpellDetails));

        List<Spell> actualSpells = service.getSpells(expectedPlayer.getId());

        assertEquals(actualSpells.size(), 1);
        assertEquals(expectedSpellName.getId(), actualSpells.get(0).getId());
        assertEquals(expectedSpellName.getSpellName(), actualSpells.get(0).getSpellName());
        assertEquals(expectedSpellDetails.getId(), actualSpells.get(0).getId());
        assertEquals(expectedSpellDetails.getSpellDescription(), actualSpells.get(0).getSpellDescription());
        assertEquals(expectedSpellDetails.getDamageToEnemy(), actualSpells.get(0).getDamageToEnemy());
        assertEquals(expectedSpellDetails.getDemonBloodCost(), actualSpells.get(0).getDemonBloodCost());
    }
}