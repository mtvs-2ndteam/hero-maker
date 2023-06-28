package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.application.dto.BattleDTO;
import com.contrabass.heromaker.application.dto.CharacterDTO;
import com.contrabass.heromaker.application.dto.TrainingDTO;
import com.contrabass.heromaker.domain.repository.CharacterMapper;
import com.contrabass.heromaker.domain.service.TrainingDomainService;
import com.contrabass.heromaker.domain.vo.StatVO;
import com.contrabass.heromaker.domain.vo.TrainingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    private final TrainingDomainService trainingDomainService;

    private final CharacterMapper characterMapper;

    @Autowired
    public TrainingService(TrainingDomainService trainingDomainService, CharacterMapper characterMapper) {
        this.trainingDomainService = trainingDomainService;
        this.characterMapper = characterMapper;
    }

    // 훈련 서비스
    public int doTraining(CharacterDTO characterDTO, String level) {
        TrainingVO trainingVO = trainingDomainService.getTrainingStat(level);
        TrainingDTO trainingDTO = new TrainingDTO(
                characterDTO.getCharacterNo()
                , trainingVO.getStr()
                , trainingVO.getHp()
                , trainingVO.getMage()
                , trainingVO.getWeaponPoint()
                , trainingVO.getToday());
        return characterMapper.updateCharacterStat(characterDTO);
    }
}
