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

    public CharacterDTO selectCharacter(int userNo) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setCharacterNo(characterMapper.selectCharacter(userNo).getCharacterNo());
        characterDTO.setUserNo(characterMapper.selectCharacter(userNo).getUserNo());
        characterDTO.setNickName(characterMapper.selectCharacter(userNo).getNickName());
        characterDTO.setHp(characterMapper.selectCharacter(userNo).getHp());
        characterDTO.setStr(characterMapper.selectCharacter(userNo).getStr());
        characterDTO.setMage(characterMapper.selectCharacter(userNo).getMage());
        characterDTO.setWeaponPoint(characterMapper.selectCharacter(userNo).getWeaponPoint());
        characterDTO.setReputation(characterMapper.selectCharacter(userNo).getReputation());
        characterDTO.setToday(characterMapper.selectCharacter(userNo).getToday());
        characterDTO.setStatus(characterMapper.selectCharacter(userNo).getStatus());
        return characterDTO;
    }

    public int insertGift(CharacterDTO characterDTO) {
        int giftNo = characterDomainService.getGiftNo(characterDTO.getReputation());
        Gift gift = characterMapper.selectGift(giftNo);
        GiftVO giftVO = GiftVO.builder()
                .characterNo(characterDTO.getCharacterNo())
                .gift(gift.getGift())
                .today(characterDTO.getToday())
                .build();
        return characterMapper.updateCharacterGift(giftVO);
    }
}
