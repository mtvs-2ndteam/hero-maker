package com.contrabass.heromaker.domain.repository;

import com.contrabass.heromaker.application.dto.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    // 회원가입
    User insertUser();

    // 특정 유저 조회
    User getOneUser();


    // 모든 유저 조회
//    @Select("SELECT * FROM USER")
    List<User> getUserList();

    // 특정 유저의 모든 캐릭터 조회
//    List<Character> getAllCharacters();
}
