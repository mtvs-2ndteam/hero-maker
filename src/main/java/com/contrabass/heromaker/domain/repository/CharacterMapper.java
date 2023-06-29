package com.contrabass.heromaker.domain.repository;

import com.contrabass.heromaker.application.dto.*;
import com.contrabass.heromaker.domain.entity.CharacterEntity;
import com.contrabass.heromaker.domain.entity.Gift;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterMapper {
    // 신규 캐릭터 등록 // 조만제
    int insertCharacter(int userNo);

    // 현재 캐릭터 조회 // 조만제
    CharacterEntity selectCharacter(int userNo);

    // 현재 캐릭터 삭제 // 조만제
    int deleteCharacter(int userNo);

    // 특정 선물 조회 // 조만제
    Gift selectGift(int giftNo);

    // 현재 캐릭터 선물 업데이트 // 조만제
    int updateCharacterGift(GiftResultDTO giftResultDTO);

    // 전투 결과 저장 // 조만제
    int saveBattleResult(BattleDTO battleDTO);

    // 캐릭터의 스탯을 조회하는 메소드
    CharacterEntity selectCharacterStat(int characterNo);

    // 캐릭터 스탯 업데이트
    int updateCharacterStat(TrainingDTO trainingDTO);

    // 캐릭터의 명성을 조회하는 메소드
    CharacterEntity selectCharacterReputation(int characterNo);

    // 캐릭터 명성 업데이트
    int updateCharacterReputation(QuestDTO questDTO);
}
