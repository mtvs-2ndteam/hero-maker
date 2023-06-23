package com.contrabass.heromaker.infra.repository;

import com.contrabass.heromaker.domain.repository.CharacterMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.apache.ibatis.annotations.Mapper
public class CharacterInfraRepository implements CharacterMapper {
    @Override
    public List<Character> getAllCharacters() {
        return null;
    }
}
