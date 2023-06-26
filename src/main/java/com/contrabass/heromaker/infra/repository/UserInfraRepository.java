package com.contrabass.heromaker.infra.repository;

import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.domain.entity.User;
import com.contrabass.heromaker.domain.repository.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public int insertUser(UserDTO userDto) {
//        List<User> members = User.findAllMembers();
//
//        List<User> memberDTOs = new ArrayList<>();
//        for(User  member : members) {
//            memberDTOs.add(member);
//        }
//
//        System.out.println("");

        return sqlSession.insert("UserMapper.insertUser", userDto);

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
