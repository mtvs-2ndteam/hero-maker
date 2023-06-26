package com.contrabass.heromaker.domain.repository;

import com.contrabass.heromaker.domain.entity.Character;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterMapper {
    // 현재 캐릭터 조회하는 메소드
    Character checkCharacter(int userNo);

    // 받은 선물 업데이트 하는 메소드
    int updateGift(String gift);
}
