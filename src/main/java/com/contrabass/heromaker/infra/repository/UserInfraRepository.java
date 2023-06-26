package com.contrabass.heromaker.infra.repository;

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
    private final UserMapper User;

    @Autowired
    public UserInfraRepository(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User insertUser() {
        List<User> members = User.findAllMembers();

        List<User> memberDTOs = new ArrayList<>();
        for(User  member : members) {
            memberDTOs.add(member);
        }

        System.out.println("findAllMembers Service method call..");

        return member;

    }

    @Override
    public User getOneUser() {


            if(User == null) {
                throw new IllegalStateException("해당하는 id의 회원이 없습니다.");
            }

            return User;
    }

    @Override
    public List<User> getUserList() {
        return sqlSession.selectList("UserMapper.getUserList");
    }

}
