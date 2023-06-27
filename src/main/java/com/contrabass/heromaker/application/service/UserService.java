package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.domain.repository.UserMapper;
import com.contrabass.heromaker.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserDomainService userDomainService;
    private final UserMapper userMapper;
    private final UserDTO userDTO;

    @Autowired
    public UserService(UserDomainService userDomainService, UserMapper userMapper, UserDTO userDTO) {
        this.userDomainService = userDomainService;
        this.userMapper = userMapper;
        this.userDTO = userDTO;
    }

    public List<UserDTO> getUserList() {
        List<UserDTO> userDTOList = new ArrayList<>();

        for (int i = 0; i < userMapper.getUserList().size(); i++) {
            userDTO.setUserNo(userMapper.getUserList().get(i).getUserNo());
            userDTO.setId(userMapper.getUserList().get(i).getId());
            userDTO.setPw(userMapper.getUserList().get(i).getPw());
            userDTO.setName(userMapper.getUserList().get(i).getName());
            userDTO.setPhone(userMapper.getUserList().get(i).getPhone());
            userDTO.setEmail(userMapper.getUserList().get(i).getEmail());
            userDTOList.add(i, userDTO);
        }
        return userDTOList;
    }
}
