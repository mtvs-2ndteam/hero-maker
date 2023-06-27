package com.contrabass.heromaker.domain.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class GiftVO {
    private int characterNo;
    private String gift;
}
