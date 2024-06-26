package com.example.supergame.shop;

import com.example.supergame.items.MeleeWeapon;
import com.example.supergame.items.RangeWeapon;
import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class Shop {
     private RangeWeapon primaryWeapon;
     private RangeWeapon secondaryWeapon;
     private MeleeWeapon meleeWeapon;

}
