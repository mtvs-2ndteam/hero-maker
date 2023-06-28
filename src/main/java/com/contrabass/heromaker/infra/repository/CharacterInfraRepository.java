package com.contrabass.heromaker.infra.repository;

import com.contrabass.heromaker.application.dto.BattleDTO;
import com.contrabass.heromaker.application.dto.GiftResultDTO;
import com.contrabass.heromaker.domain.entity.CharacterEntity;
import com.contrabass.heromaker.domain.entity.Gift;
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

    // 현재 캐릭터 정보 조회 // 조만제
    @Override
    public CharacterEntity selectCharacter(int userNo) {
        return sqlSession.selectOne("CharacterMapper.selectCharacter", userNo);
    }

    // 특정 선물 조회 // 조만제
    @Override
    public Gift selectGift(int giftNo) {
        return sqlSession.selectOne("GiftMapper.selectGift", giftNo);
    }

    // 현재 캐릭터 선물 업데이트 // 조만제
    @Override
    public int updateCharacterGift(GiftResultDTO giftResultDTO) {
        return sqlSession.update("CharacterMapper.updateCharacterGift", giftResultDTO);
    }

    // 전투 결과 저장 // 조만제
    @Override
    public int saveBattleResult(BattleDTO battleDTO) {
        return sqlSession.update("CharacterMapper.saveBattleResult", battleDTO);
    }
}
