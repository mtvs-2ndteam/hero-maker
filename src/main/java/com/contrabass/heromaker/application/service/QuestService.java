package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.application.dto.CharacterDTO;
import com.contrabass.heromaker.application.dto.QuestDTO;
import com.contrabass.heromaker.domain.repository.CharacterMapper;
import com.contrabass.heromaker.domain.service.QuestDomainService;
import com.contrabass.heromaker.domain.vo.QuestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService {

    private final QuestDomainService questDomainService;

    private final CharacterMapper characterMapper;

    @Autowired
    public QuestService(QuestDomainService questDomainService, CharacterMapper characterMapper) {
        this.questDomainService = questDomainService;
        this.characterMapper = characterMapper;
    }

    // 마을 이벤트 서비스
    public int doQuest(CharacterDTO characterDTO, String quest) {
        QuestVO questVO = questDomainService.getQuestReputation(quest);
        QuestDTO questDTO = new QuestDTO(
                characterDTO.getCharacterNo()
                , questVO.getReputation()
                , questVO.getToday());
        System.out.println(questDTO.getReputation());
        System.out.println(questDTO.getToday());
        return characterMapper.updateCharacterReputation(questDTO);
    }

}
