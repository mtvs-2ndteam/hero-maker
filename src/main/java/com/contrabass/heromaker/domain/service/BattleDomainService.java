package com.contrabass.heromaker.domain.service;

import com.contrabass.heromaker.domain.vo.BattleResultVO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BattleDomainService {
    public BattleResultVO getBattleResult(String level) {
        Random random = new Random();
        int ranNum = random.nextInt(100) + 1;
        String status = "N";
        int statPoint = 0;

        if (level.equals("Easy") && ranNum > 15) {
            statPoint = 3;
            status = "Y";
        }
        if (level.equals("Normal") && ranNum > 30) {
            statPoint = 6;
            status = "Y";
        }
        if (level.equals("Hard") && ranNum > 60) {
            statPoint = 12;
            status = "Y";
        }
        return BattleResultVO.builder()
                .statPoint(statPoint)
                .status(status)
                .build();
    }

}
