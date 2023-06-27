package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.application.dto.CharacterDTO;
import com.contrabass.heromaker.application.dto.GiftResultDTO;
import com.contrabass.heromaker.domain.entity.CharacterEntity;
import com.contrabass.heromaker.domain.entity.Gift;
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

    // 현재 캐릭터 조회 // 조만제
    public CharacterDTO selectCharacter(int userNo) {
        CharacterDTO characterDTO = new CharacterDTO();
        CharacterEntity characterEntity = characterMapper.selectCharacter(userNo);
        characterDTO.setCharacterNo(characterEntity.getCharacterNo());
        characterDTO.setUserNo(characterEntity.getUserNo());
        characterDTO.setNickName(characterEntity.getNickName());
        characterDTO.setHp(characterEntity.getHp());
        characterDTO.setStr(characterEntity.getStr());
        characterDTO.setMage(characterEntity.getMage());
        characterDTO.setWeaponPoint(characterEntity.getWeaponPoint());
        characterDTO.setReputation(characterEntity.getReputation());
        characterDTO.setToday(characterEntity.getToday());
        characterDTO.setStatus(characterEntity.getStatus());
        return characterDTO;
    }

    // 선물 입력 // 조만제
    public int insertGift(CharacterDTO characterDTO) {
        int giftNo = characterDomainService.getGiftNo(characterDTO.getReputation());
        Gift gift = characterMapper.selectGift(giftNo);
        GiftResultDTO giftResultDTO = new GiftResultDTO(
                characterDTO.getCharacterNo()
                , gift.getGift()
                , characterDTO.getToday());
        return characterMapper.updateCharacterGift(giftResultDTO);
    }
}
