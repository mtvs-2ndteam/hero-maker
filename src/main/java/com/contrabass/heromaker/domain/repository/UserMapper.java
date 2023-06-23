package com.contrabass.heromaker.domain.repository;

import com.contrabass.heromaker.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    // 회원가입
    User insertUser();

    // 특정 유저 조회
    User getOneUser();

    // 모든 유저 조회
    List<User> getUserList();
    
}
