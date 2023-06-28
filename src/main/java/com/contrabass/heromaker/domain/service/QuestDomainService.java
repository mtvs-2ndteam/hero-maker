package com.contrabass.heromaker.domain.service;

import com.contrabass.heromaker.domain.vo.QuestVO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class QuestDomainService {

    public QuestVO getQuestReputation(String quest) {
        Random random = new Random();
        int ranNum = random.nextInt(7) + 1;
        int reputation = 0;
        int today = 1;

        if(quest.equals("마을")) {
            reputation = ranNum;
            today = 1;
        }
        return QuestVO.builder()
                .reputation(reputation)
                .today(today)
                .build();
    }
}
