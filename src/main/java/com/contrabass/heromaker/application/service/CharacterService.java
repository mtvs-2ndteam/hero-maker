package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.application.dto.CharacterDTO;
import com.contrabass.heromaker.domain.entity.Gift;
import com.contrabass.heromaker.domain.repository.CharacterMapper;
import com.contrabass.heromaker.domain.service.CharacterDomainService;
import com.contrabass.heromaker.domain.vo.GiftVO;
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


    public int insertGift(CharacterDTO characterDTO) {
        int giftNo = characterDomainService.getGiftNo(characterDTO.getReputation());
        Gift gift = characterMapper.selectGift(giftNo);
        GiftVO giftVO = GiftVO.builder()
                .characterNo(characterDTO.getCharacterNo())
                .gift(gift.getGift())
                .build();
        int result = characterMapper.updateCharacterGift(giftVO);
        System.out.println(result);
        return result;
    }
}
