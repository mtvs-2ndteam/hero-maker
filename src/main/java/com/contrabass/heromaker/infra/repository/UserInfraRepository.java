package com.contrabass.heromaker.infra.repository;

import com.contrabass.heromaker.application.service.UserService;
import com.contrabass.heromaker.domain.entity.User;
import com.contrabass.heromaker.domain.repository.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.apache.ibatis.annotations.Mapper
public class UserInfraRepository implements UserMapper {
    private final SqlSessionTemplate sqlSession;

    @Autowired
    public UserInfraRepository(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;

    }


    @Override
    public int insertUser(User user) {

        return sqlSession.insert("UserMapper.insertUser",user);
    }

    @Override
    public User getUser(int userNo) {
        return sqlSession.selectOne("UserMapper.insertUser",userNo);
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
