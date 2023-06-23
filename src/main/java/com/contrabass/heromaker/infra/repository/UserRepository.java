package com.contrabass.heromaker.infra.repository;

import com.contrabass.heromaker.domain.entity.User;
import com.contrabass.heromaker.domain.repository.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.apache.ibatis.annotations.Mapper
public class UserRepository implements Mapper {
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public User insertUser() {
        return null;
    }

    @Override
    public User getOneUser() {
        return null;
    }

    @Override
    public List<User> getUserList() {
        return sqlSession.selectList("UserMapper.getUserList");
    }
}
