package com.contrabass.heromaker.domain.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterMapper {
    // 특정 유저의 모든 캐릭터 조회
    List<Character> getAllCharacters();
}
