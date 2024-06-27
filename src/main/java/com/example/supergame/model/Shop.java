package com.example.supergame.model;

import com.example.supergame.model.item.MeleeWeapon;
import com.example.supergame.model.item.RangeWeapon;
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
