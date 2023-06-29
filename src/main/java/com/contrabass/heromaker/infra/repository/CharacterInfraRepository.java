package com.contrabass.heromaker.infra.repository;

import com.contrabass.heromaker.application.dto.*;
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

    // 신규 캐릭터 등록 // 조만제
    @Override
    public int insertCharacter(int userNo) {
        return sqlSession.insert("CharacterMapper.insertCharacter", userNo);
    }

    // 현재 캐릭터 조회 // 조만제
    @Override
    public CharacterEntity selectCharacter(int userNo) {
        return sqlSession.selectOne("CharacterMapper.selectCharacter", userNo);
    }

    // 현재 캐릭터 삭제 // 조만제
    @Override
    public int deleteCharacter(int userNo) {
        return sqlSession.delete("CharacterMapper.deleteCharacter", userNo);
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

    // 캐릭터 스탯 조회
    @Override
    public CharacterEntity selectCharacterStat(int characterNo) {

        return sqlSession.selectOne("CharacterMapper.selectCharacterStat", characterNo);
    }

    // 캐릭터 스탯 업데이트
    @Override
    public int updateCharacterStat(TrainingDTO trainingDTO) {
        return sqlSession.update("CharacterMapper.updateCharacterStat", trainingDTO);
    }

    // 캐릭터 명성 조회
    @Override
    public CharacterEntity selectCharacterReputation(int characterNo) {

        return sqlSession.selectOne("CharacterMapper.selectReputation", characterNo);
    }

    @Override
    public int updateCharacterReputation(QuestDTO questDTO) {
        return sqlSession.update("CharacterMapper.updateCharacterReputation", questDTO);
    }
}
