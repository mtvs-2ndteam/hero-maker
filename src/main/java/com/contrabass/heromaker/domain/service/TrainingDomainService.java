package com.contrabass.heromaker.domain.service;

import com.contrabass.heromaker.domain.vo.TrainingVO;
import org.springframework.stereotype.Service;

@Service
public class TrainingDomainService {

    public TrainingVO getTrainingStat(String level) {

        int str = 0;
        int hp = 0;
        int mage = 0;
        int weaponPoint = 0;
        int today = 1;

        if (level.equals("힘 훈련")) {
            str = 2;
            today = 1;
        }
        if (level.equals("체력 훈련")) {
            hp = 2;
            today = 1;
        }
        if (level.equals("지능 훈련")) {
            mage = 2;
            today = 1;
        }
        if (level.equals("무기술 훈련")) {
            weaponPoint = 2;
            today = 1;
        }
        return TrainingVO.builder()
                .str(str)
                .hp(hp)
                .mage(mage)
                .weaponPoint(weaponPoint)
                .today(today)
                .build();
    }
}
