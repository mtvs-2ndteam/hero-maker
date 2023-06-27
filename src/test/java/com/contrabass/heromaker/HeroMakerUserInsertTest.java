package com.contrabass.heromaker;

import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.application.service.UserService;
import com.contrabass.heromaker.domain.service.CharacterDomainService;
import com.contrabass.heromaker.domain.service.UserDomainService;
import com.contrabass.heromaker.infra.repository.UserInfraRepository;
import com.sun.nio.sctp.Association;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class HeroMakerUserInsertTest {

    private UserService userService;
    private UserInfraRepository userInfraRepository;

    @Autowired
    public void setUp(UserService userService,UserInfraRepository userInfraRepository) {
        this.userService = userService;
        this.userInfraRepository=userInfraRepository;
    }

    @DisplayName("데이터 삽입 테스트")
    @Test
    void insertTest() {
        UserDTO userDTO=new UserDTO(0,"test1","test1","test1","test1","test1");

        Assertions.assertEquals(1,userService.insertUser(userDTO));
    }



}
