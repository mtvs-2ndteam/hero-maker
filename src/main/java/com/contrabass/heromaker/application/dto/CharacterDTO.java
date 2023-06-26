package com.contrabass.heromaker.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {
    private int characterNo;
    private int userNo;
    private String nickName;
    private int hp;
    private int str;
    private int mage;
    private int weaponPoint;
    private int reputation;
    private String ending;
    private String gift;
    private int date;
}
