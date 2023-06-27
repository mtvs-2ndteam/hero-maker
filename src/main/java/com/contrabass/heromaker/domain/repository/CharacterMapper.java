package com.contrabass.heromaker.domain.repository;

import com.contrabass.heromaker.domain.entity.Gift;
import com.contrabass.heromaker.domain.vo.GiftVO;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterMapper {
//    // 현재 캐릭터 조회하는 메소드
//    Character selectCharacter(int userNo);

    // 특정 선물 조회하는 메소드
    Gift selectGift(int giftNo);

    // 받은 선물 업데이트 하는 메소드
    int updateCharacterGift(GiftVO giftVO);
}
