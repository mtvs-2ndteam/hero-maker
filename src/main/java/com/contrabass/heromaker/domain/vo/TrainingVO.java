package com.contrabass.heromaker.domain.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class TrainingVO {
    private int hp;
    private int str;
    private int mage;
    private int weaponPoint;
    private int today;
}
