package com.contrabass.heromaker.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDTO {

    private int characterNo;
    private int str;
    private int hp;
    private int mage;
    private int weaponPoint;
    private int today;

}
