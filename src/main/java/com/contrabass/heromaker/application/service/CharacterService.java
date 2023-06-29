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
        return characterDTO.setCharacterDTO(characterEntity);
    }

    // 새로하기 // 조만제
    public CharacterDTO deleteCharacter(int userNo) {
        int deleteResult = characterMapper.deleteCharacter(userNo);
        int insertResult = characterMapper.insertCharacter(userNo);
        if (deleteResult == 1 && insertResult == 1) {
            return selectCharacter(userNo);
        }
        return null;
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

    // 캐릭터 스탯 조회
    public CharacterDTO selectCharacterStat(int characterNo) {

        CharacterDTO characterDTO = new CharacterDTO();

        CharacterEntity characterStat = characterMapper.selectCharacterStat(characterNo);

        characterDTO.setStr(characterStat.getStr());
        characterDTO.setMage(characterStat.getMage());
        characterDTO.setWeaponPoint(characterStat.getWeaponPoint());
        characterDTO.setHp(characterStat.getHp());

        return characterDTO;
    }

    // 캐릭터 명성 조회
    public CharacterDTO selectCharacterReputation(int characterNo) {

        CharacterDTO characterDTO = new CharacterDTO();

        CharacterEntity characterReputation = characterMapper.selectCharacterReputation(characterNo);

        characterDTO.setReputation(characterReputation.getReputation());

        return characterDTO;
    }
}
