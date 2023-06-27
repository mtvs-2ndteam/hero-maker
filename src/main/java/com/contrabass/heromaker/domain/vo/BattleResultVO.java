package com.contrabass.heromaker.domain.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class BattleResultVO {
    private int statPoint;
    private String status;
}
