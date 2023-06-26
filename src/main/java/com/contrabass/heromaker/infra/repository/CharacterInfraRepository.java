package com.contrabass.heromaker.infra.repository;

import com.contrabass.heromaker.domain.entity.Character;
import com.contrabass.heromaker.domain.repository.CharacterMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

@Component
@org.apache.ibatis.annotations.Mapper
public class CharacterInfraRepository implements CharacterMapper {
    private final SqlSessionTemplate sqlSession;

    public CharacterInfraRepository(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Character checkReputation() {
        return sqlSession.selectOne("CharacterMapper.get");
    }
}
