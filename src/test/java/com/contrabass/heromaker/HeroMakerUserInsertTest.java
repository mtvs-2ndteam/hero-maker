package com.contrabass.heromaker;

import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.application.service.UserService;

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

    @Autowired
    public void setUp(UserService userService,UserInfraRepository userInfraRepository) {
        this.userService = userService;
    }

    @DisplayName("데이터 삽입 테스트")
    @Test
    void insertTest1() {
        UserDTO userDTO=new UserDTO(0,"test1","test1","test1","test1","test1");

        Assertions.assertEquals(1,userService.insertUser(userDTO));
    }

    @DisplayName("데이터 삽입  notNull 테스트")
    @Test
    void insertTest2() {
        UserDTO userDTO=new UserDTO(0,"test1","test1","test1","test1","test1");

        Assertions.assertNotNull(userService.insertUser(userDTO));
    }

    @DisplayName("데이터 조회 테스트")
    @Test
    void selectTest() {
        int userNo = 2;
        UserDTO userDTO=new UserDTO(2,"test1","test1","test1","test1","test1");

        Assertions.assertNotNull(userService.getUser(userNo)); //받아온 값이 null인지 비교

        Assertions.assertEquals(userDTO.getUserNo(),userService.getUser(userNo).getUserNo()); //받아온 값과 db의 있는 값이 같은지 비교

        org.assertj.core.api.Assertions.assertThat(userService.getUser(userNo)).isInstanceOf(UserDTO.class); //받아온 데이터가 UserDTO 타입인지 확인

        org.assertj.core.api.Assertions.assertThat(userService.getUser(userNo)).usingRecursiveComparison().isEqualTo(userDTO); //객체의 담긴 값과 비교
    }



}
