package com.contrabass.heromaker.infra.service;

import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.domain.entity.User;
import com.contrabass.heromaker.domain.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class InfraService {

    private UserDTO changeToDTO(User user) {

        UserDTO dto = new UserDTO();
        dto.setId(dto.getId());
        dto.setName(dto.getName());

        return dto;
    }



}
