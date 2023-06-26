package com.contrabass.heromaker.domain.repository;

import com.contrabass.heromaker.domain.entity.Character;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterMapper {
    // 평판 수치에 따른 선물 받는 기능
    Character checkReputation();
}
