package com.contrabass.heromaker.application.service;

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

    public List<UserDTO> getUserList() {
        List<User> foundUserList = userMapper.getUserList();
        List<UserDTO> userDTOList = new ArrayList<>();

        int listSize = foundUserList.size();
        try {
            for (int i = 0; i < listSize; i++) {
                userDTO.setUserNo(userMapper.getUserList().get(i).getUserNo());
                userDTO.setId(userMapper.getUserList().get(i).getId());
                userDTO.setPwd(userMapper.getUserList().get(i).getPwd());
                userDTO.setName(userMapper.getUserList().get(i).getName());
                userDTO.setPhone(userMapper.getUserList().get(i).getPhone());
                userDTO.setEmail(userMapper.getUserList().get(i).getEmail());
                userDTOList.add(i, userDTO);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userDTOList;
    }

    public UserDTO getUser(int userNo) {
        UserDTO userDTO=new UserDTO();

        List<User> foundUserList = userMapper.getUserList();

        boolean result=false;

        int listSize = foundUserList.size();

        for (int i = 0; i < listSize; i++) {
            if(userMapper.getUserList().get(i).getUserNo()==userNo){
                userDTO.setUserNo(userMapper.getUserList().get(i).getUserNo());
                userDTO.setId(userMapper.getUserList().get(i).getId());
                userDTO.setPwd(userMapper.getUserList().get(i).getPwd());
                userDTO.setName(userMapper.getUserList().get(i).getName());
                userDTO.setPhone(userMapper.getUserList().get(i).getPhone());
                userDTO.setEmail(userMapper.getUserList().get(i).getEmail());
            }
        }
        return userDTO;
    }
    public int insertUser(UserDTO userDTO){
        User user=new User(
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
