package com.example.supergame.model.dto;

import com.example.supergame.model.dto.item.MeleeWeapon;
import com.example.supergame.model.dto.item.RangeWeapon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Shop {
    private RangeWeapon primaryWeapon;
    private RangeWeapon secondaryWeapon;
    private MeleeWeapon meleeWeapon;
}
