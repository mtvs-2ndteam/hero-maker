package com.contrabass.heromaker.domain.repository;

import com.contrabass.heromaker.application.dto.BattleDTO;
import com.contrabass.heromaker.application.dto.GiftResultDTO;
import com.contrabass.heromaker.domain.entity.CharacterEntity;
import com.contrabass.heromaker.domain.entity.Gift;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterMapper {
    // 현재 캐릭터 조회 // 조만제
    CharacterEntity selectCharacter(int userNo);

    // 특정 선물 조회 // 조만제
    Gift selectGift(int giftNo);

    // 현재 캐릭터 선물 업데이트 // 조만제
    int updateCharacterGift(GiftResultDTO giftResultDTO);

    // 전투 결과 저장 // 조만제
    int saveBattleResult(BattleDTO battleDTO);
}
