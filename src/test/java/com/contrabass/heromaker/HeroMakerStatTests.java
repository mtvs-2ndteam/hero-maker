package com.contrabass.heromaker;

import com.contrabass.heromaker.application.dto.CharacterDTO;
import com.contrabass.heromaker.domain.repository.CharacterMapper;
import com.contrabass.heromaker.domain.service.QuestDomainService;
import com.contrabass.heromaker.domain.service.TrainingDomainService;
import com.contrabass.heromaker.domain.vo.TrainingVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HeroMakerStatTests {

    private QuestDomainService questDomainService;

    private CharacterMapper characterMapper;

    private TrainingDomainService trainingDomainService;

    @Autowired
    void setUp(QuestDomainService questDomainService,
               CharacterMapper characterMapper,
               TrainingDomainService trainingDomainService) {
        this.characterMapper = characterMapper;
        this.questDomainService = questDomainService;
        this.trainingDomainService = trainingDomainService;
    }

    @DisplayName("힘 훈련 결과값 테스트")
    @Test
    void TrainingStrTest() {
        TrainingVO trainingVO1 = TrainingVO.builder()
                .str(2)
                .today(1)
                .build();

        TrainingVO result = trainingVO1;

    }
    @DisplayName("체력 훈련 결과값 테스트")
    @Test
    void TrainingHpTest() {
        TrainingVO trainingVO1 = TrainingVO.builder()
                .hp(2)
                .today(1)
                .build();

        TrainingVO result = trainingVO1;

    }
    @DisplayName("지능 훈련 결과값 테스트")
    @Test
    void TrainingMageTest() {
        TrainingVO trainingVO1 = TrainingVO.builder()
                .mage(2)
                .today(1)
                .build();

        TrainingVO result = trainingVO1;

    }
    @DisplayName("무기술 훈련 결과값 테스트")
    @Test
    void TrainingWeaponPointTest() {
        TrainingVO trainingVO1 = TrainingVO.builder()
                .weaponPoint(2)
                .today(1)
                .build();

        TrainingVO result = trainingVO1;
    }


}
