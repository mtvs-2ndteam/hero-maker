package com.contrabass.heromaker.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EndingDTO {
    private int endingNo;
    private int userNo;
    private String ending;
    private String status;
}
