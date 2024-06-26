package com.example.supergame.shop;

import com.example.supergame.items.MeleeWeapon;
import com.example.supergame.items.RangeWeapon;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Shop {
     private RangeWeapon primaryWeapon;
     private RangeWeapon secondaryWeapon;
     private MeleeWeapon meleeWeapon;
}
