package com.contrabass.heromaker.infra.repository;

import com.contrabass.heromaker.domain.entity.Character;
import com.contrabass.heromaker.domain.repository.CharacterMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@org.apache.ibatis.annotations.Mapper
public class CharacterInfraRepository implements CharacterMapper {
    private final SqlSessionTemplate sqlSession;

    @Autowired
    public CharacterInfraRepository(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    // DB에서 현재 캐릭터 정보 조회
    @Override
    public Character checkCharacter(int userNo) {
        return sqlSession.selectOne("CharacterMapper.checkCharacter", userNo);
    }

    // 현재 캐릭터 선물 업데이트
    @Override
    public int updateGift(String gift) {
        return sqlSession.update("CharacterMapper.updateGift", gift);
    }
}
