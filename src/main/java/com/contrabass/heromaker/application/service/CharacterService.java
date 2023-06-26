package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.domain.repository.CharacterMapper;
import com.contrabass.heromaker.domain.service.CharacterDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final CharacterDomainService characterDomainService;
    private final CharacterMapper characterMapper;

    @Autowired
    public CharacterService(CharacterDomainService characterDomainService, CharacterMapper characterMapper) {
        this.characterDomainService = characterDomainService;
        this.characterMapper = characterMapper;
    }
}
