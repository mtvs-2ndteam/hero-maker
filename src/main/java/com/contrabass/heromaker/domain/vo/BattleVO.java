package com.contrabass.heromaker.domain.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class BattleVO {
    private int characterNo;
    private int statPoint;
    private int today;
    private String status;
}
