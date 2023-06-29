package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.application.dto.CharacterDTO;
import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.domain.entity.User;
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

    @Autowired
    public UserService(UserDomainService userDomainService, UserMapper userMapper) {
        this.userDomainService = userDomainService;
        this.userMapper = userMapper;
    }

    public String getEnding(CharacterDTO characterDTO) {
        return userDomainService.endingNo(characterDTO.getStr(), characterDTO.getHp(),
                characterDTO.getMage(), characterDTO.getWeaponPoint(),
                characterDTO.getReputation(), characterDTO.getGift());
    }


    public UserDTO getUser(int userNo) {
        UserDTO userDTO = new UserDTO();

        List<User> foundUserList = userMapper.getUserList();

        int listSize = foundUserList.size();

        for (int i = 0; i < listSize; i++) {
            if(foundUserList.get(i).getUserNo()==userNo){
                userDTO.setUserNo(foundUserList.get(i).getUserNo());
                userDTO.setId(foundUserList.get(i).getId());
                userDTO.setPwd(foundUserList.get(i).getPwd());
                userDTO.setName(foundUserList.get(i).getName());
                userDTO.setPhone(foundUserList.get(i).getPhone());
                userDTO.setEmail(foundUserList.get(i).getEmail());
            }
        }
        return userDTO;
    }

    public UserDTO getUserList(String userId) {
        UserDTO userDTO = new UserDTO();
        List<User> foundUserList = userMapper.getUserList();
        System.out.println("userId = "+userId);
        int listSize = foundUserList.size();
        try {
            for (int i = 0; i < listSize; i++) {
                if(foundUserList.get(i).getId().equals(userId)) {
                    userDTO.setUserNo(foundUserList.get(i).getUserNo());
                    userDTO.setId(foundUserList.get(i).getId());
                    userDTO.setPwd(foundUserList.get(i).getPwd());
                    userDTO.setName(foundUserList.get(i).getName());
                    userDTO.setPhone(foundUserList.get(i).getPhone());
                    userDTO.setEmail(foundUserList.get(i).getEmail());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDTO;
    }

    public int insertUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserNo(),
                userDTO.getId(),
                userDTO.getPwd(),
                userDTO.getName(),
                userDTO.getPhone(),
                userDTO.getEmail()
        );


        return userMapper.insertUser(user);
    }


}
