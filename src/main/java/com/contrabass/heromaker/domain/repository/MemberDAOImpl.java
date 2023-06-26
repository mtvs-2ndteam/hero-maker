package com.contrabass.heromaker.domain.repository;

import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.domain.dao.MemberDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    SqlSession sqlSession; // SqlSession 의존관계 주입

    @Override
    public String loginCheck(UserDTO dto){
        return sqlSession.selectOne("member.login_check",dto);
    }
}
