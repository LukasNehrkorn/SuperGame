package com.example.supergame.service;

import com.example.supergame.model.database.Inventory;
import com.example.supergame.model.database.Player;
import com.example.supergame.model.database.WeaponName;
import com.example.supergame.model.dto.Shop;
import com.example.supergame.model.dto.item.Item;
import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import com.example.supergame.model.enums.WeaponCategory;
import com.example.supergame.model.enums.WeaponType;
import com.example.supergame.repository.items.WeaponNamesRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ShopServiceTest {

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
}