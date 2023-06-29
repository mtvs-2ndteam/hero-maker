package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.application.dto.BattleDTO;
import com.contrabass.heromaker.application.dto.CharacterDTO;
import com.contrabass.heromaker.domain.repository.CharacterMapper;
import com.contrabass.heromaker.domain.service.BattleDomainService;
import com.contrabass.heromaker.domain.vo.BattleVO;
import com.contrabass.heromaker.domain.vo.StatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleService {
    private final BattleDomainService battleDomainService;
    private final CharacterMapper characterMapper;

    @Autowired
    public BattleService(BattleDomainService battleDomainService, CharacterMapper characterMapper) {
        this.battleDomainService = battleDomainService;
        this.characterMapper = characterMapper;
    }

    // 전투 서비스 // 조만제
    public int doBattle(CharacterDTO characterDTO, String level) {
        BattleVO battleVO = battleDomainService.getBattleResult(level);
        StatVO statVO = battleDomainService.getStats(battleVO.getStatPoint());
        BattleDTO battleDTO = new BattleDTO(
                characterDTO.getCharacterNo()
                , statVO.getHp()
                , statVO.getStr()
                , statVO.getMage()
                , statVO.getWeaponPoint()
                , battleVO.getToday()
                , battleVO.getStatus());
        int result = characterMapper.saveBattleResult(battleDTO);
        if (result == 1) {
            if (battleVO.getToday() == 3) {
                return 0; // 부상
            }
            return 1; // 전투 승리
        }
        return -1; // 저장 실패
    }


}
