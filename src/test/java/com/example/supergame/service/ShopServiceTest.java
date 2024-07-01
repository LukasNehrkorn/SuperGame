package com.example.supergame.service;

import com.example.supergame.model.database.Player;
import com.example.supergame.model.dto.Shop;
import com.example.supergame.model.dto.item.RangeWeapon;
import com.example.supergame.model.dto.item.WeaponType;
import com.example.supergame.repository.player.PlayerRepository;
import com.example.supergame.repository.player.SpellDetailsRepository;
import com.example.supergame.repository.player.SpellNameRepository;
import com.example.supergame.testdata.TestDataFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ShopServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private SpellNameRepository spellNameRepository;

    @Mock
    private SpellDetailsRepository spellDetailsRepository;

    @InjectMocks
    private ShopService shopService;

    private final TestDataFactory testDataFactory = new TestDataFactory();

    @Test
    void buyPrimaryWeapon() {
        Player player = testDataFactory.getPlayer();
        Shop shop = testDataFactory.getCheapShop();
        RangeWeapon expectedWeapon = shop.getPrimaryWeapon();
        //TODO: Mockito.when

        RangeWeapon actualWeapon = (RangeWeapon) shopService.buyWeapon(player.getId(), WeaponType.PRIMARY);

        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void buyPrimaryWeaponWithoutSufficientFunds() {
        Player player = testDataFactory.getPlayer();
        Shop shop = testDataFactory.getExpensiveShop();
        //TODO: Mockito.when

        RangeWeapon actualWeapon = (RangeWeapon) shopService.buyWeapon(player.getId(), WeaponType.PRIMARY);

        assertNotNull(actualWeapon);
    }

    @Test
    void sellItem() {
    }
}