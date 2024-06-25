package com.example.supergame.shop;

import com.example.supergame.items.MeleeWeapon;
import com.example.supergame.items.RangeWeapon;
import lombok.*;
import org.w3c.dom.ranges.Range;

@Data
@Builder
public class Shop {
     private RangeWeapon primaryWeapon;
     private RangeWeapon secondaryWeapon;
     private MeleeWeapon meleeWeapon;
}
