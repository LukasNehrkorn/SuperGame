package com.example.supergame.service;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.database.Player;
import com.example.supergame.model.database.WeaponName;
import com.example.supergame.model.dto.Shop;
import com.example.supergame.model.dto.item.Item;
import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import com.example.supergame.model.dto.item.Weapon;
import com.example.supergame.model.enums.WeaponCategory;
import com.example.supergame.model.enums.WeaponType;
import com.example.supergame.repository.items.WeaponNamesRepository;
import com.example.supergame.repository.player.PlayerRepository;
import com.example.supergame.repository.player.SpellDetailsRepository;
import com.example.supergame.repository.player.SpellNameRepository;
import com.example.supergame.testdata.TestDataFactory;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ShopServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private SpellNameRepository spellNameRepository;

    @Mock
    private SpellDetailsRepository spellDetailsRepository;

    @Mock
    private WeaponNamesRepository weaponsRepository;

    @Mock
    private Shop currentShop;

    @InjectMocks
    private ShopService shopService;

    private final TestDataFactory testDataFactory = new TestDataFactory();

    @Test
    void getShopTest() {
        List<WeaponName> weaponNames = new ArrayList<>();
        weaponNames.add(WeaponName.builder()
                .name("TestKnife")
                .weaponType(WeaponType.MELEE.toString())
                .build());
        weaponNames.add(WeaponName.builder()
                .name("TestPistol")
                .weaponType(WeaponType.PISTOL.toString())
                .build());
        weaponNames.add(WeaponName.builder()
                .name("TestAK")
                .weaponType(WeaponType.ASSAULT_RIFLE.toString())
                .build());
        when(weaponsRepository.findAll()).thenReturn(weaponNames);

        Shop shop = shopService.getShop();

        assertNotNull(shop);
        assertInstanceOf(RangeWeapon.class, shop.getPrimaryWeapon());
        assertInstanceOf(RangeWeapon.class, shop.getSecondaryWeapon());
        assertInstanceOf(MeleeWeapon.class, shop.getMeleeWeapon());
    }

    @Test
    void buyPrimaryWeaponTest() {
        List<WeaponName> weaponNames = new ArrayList<>();
        weaponNames.add(WeaponName.builder()
                .name("TestKnife")
                .weaponType(WeaponType.MELEE.toString())
                .build());
        weaponNames.add(WeaponName.builder()
                .name("TestPistol")
                .weaponType(WeaponType.PISTOL.toString())
                .build());
        weaponNames.add(WeaponName.builder()
                .name("TestAK")
                .weaponType(WeaponType.ASSAULT_RIFLE.toString())
                .build());
        when(weaponsRepository.findAll()).thenReturn(weaponNames);

        Player player = testDataFactory.getPlayer();
        player.getInventory().setMoney(1000);
        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);

        RangeWeapon actualWeapon = (RangeWeapon) shopService.buyWeapon(player.getId(), WeaponCategory.PRIMARY);

        assertNotNull(actualWeapon);
    }

    @Test
    void buyPrimaryWeaponWithoutSufficientFundsTest() {
        List<WeaponName> weaponNames = new ArrayList<>();
        weaponNames.add(WeaponName.builder()
                .name("TestKnife")
                .weaponType(WeaponType.MELEE.toString())
                .build());
        weaponNames.add(WeaponName.builder()
                .name("TestPistol")
                .weaponType(WeaponType.PISTOL.toString())
                .build());
        weaponNames.add(WeaponName.builder()
                .name("TestAK")
                .weaponType(WeaponType.ASSAULT_RIFLE.toString())
                .build());
        when(weaponsRepository.findAll()).thenReturn(weaponNames);

        Player player = testDataFactory.getPlayer();
        player.getInventory().setMoney(0);
        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                shopService.buyWeapon(player.getId(), WeaponCategory.PRIMARY));

        assertEquals("Price exceeds players funds!", exception.getMessage());
    }

    @Test
    void sellItemTest() {
        Player player = testDataFactory.getPlayer();
        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);

        int indexToRemove = 0;
        Inventory expectedInventory = testDataFactory.getInventory();
        expectedInventory.getItems().remove(indexToRemove);
        expectedInventory.setMoney(expectedInventory.getMoney() + expectedInventory.getItems().get(indexToRemove).getPrice() / 5);

        Inventory actualInventory = shopService.sellItem(player.getId(), indexToRemove);

        assertEquals(expectedInventory.getItems().size(), actualInventory.getItems().size());
        List<Item> expectedItems = expectedInventory.getItems();
        List<Item> actualItems = actualInventory.getItems();
        for (int i = 0; i < expectedItems.size(); i++) {
            assertEquals(expectedItems.get(i).getName(), actualItems.get(i).getName());
        }

        assertEquals(expectedInventory.getMoney(), actualInventory.getMoney());
    }
}