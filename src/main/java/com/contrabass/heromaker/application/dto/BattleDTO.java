package com.contrabass.heromaker.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BattleDTO {
    private int characterNo;
    private int hp;
    private int str;
    private int mage;
    private int weaponPoint;
    private int today;
    private String status;
}
