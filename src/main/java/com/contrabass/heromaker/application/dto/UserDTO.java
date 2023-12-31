package com.contrabass.heromaker.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int userNo;
    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String email;
}
