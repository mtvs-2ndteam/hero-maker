package com.contrabass.heromaker.domain.repository;

import com.contrabass.heromaker.domain.entity.Ending;
import com.contrabass.heromaker.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    // 회원가입
    int insertUser(User user);

    // 모든 유저 조회
    List<User> getUserList();

    List<Ending> getEndingList(int userNo);


    int insertEndingNo(Ending ending);
}
