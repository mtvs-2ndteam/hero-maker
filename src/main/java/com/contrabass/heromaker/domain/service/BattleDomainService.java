package com.contrabass.heromaker.domain.service;

import com.contrabass.heromaker.domain.vo.BattleResultVO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BattleDomainService {
    public BattleResultVO getBattleResult(String level) {
        int statPoint = 0;

        if (level.equals("Easy")) {
            statPoint = 3;
        }
        if (level.equals("Normal")) {
            statPoint = 6;
        }
        if (level.equals("Hard")) {
            statPoint = 12;
        }
        return BattleResultVO.builder()
                .statPoint(statPoint)
                .status(getStatus(level))
                .build();
    }

    public String getStatus(String level) {
        Random random = new Random();
        int ranNum = random.nextInt(100) + 1;
        String status = "Y";

        if (level.equals("Easy") && ranNum <= 15) {
            status = "N";
        }
        if (level.equals("Normal") && ranNum <= 30) {
            status = "N";
        }
        if (level.equals("Hard") && ranNum <= 60) {
            status = "N";
        }
        return status;
    }
}
