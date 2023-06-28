package com.contrabass.heromaker.domain.service;

import com.contrabass.heromaker.domain.enumtype.Stats;
import com.contrabass.heromaker.domain.vo.BattleVO;
import com.contrabass.heromaker.domain.vo.StatVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BattleDomainService {
    // 전투 결과 // 조만제
    public BattleVO getBattleResult(String level) {
        Random random = new Random();
        int ranNum = random.nextInt(100) + 1;
        String status = "N";
        int statPoint = 0;
        int today = 3;

        if (level.equals("쉬움") && ranNum > 15) {
            statPoint = 3;
            status = "Y";
            today = 1;
        }
        if (level.equals("보통") && ranNum > 30) {
            statPoint = 6;
            status = "Y";
            today = 1;
        }
        if (level.equals("어려움") && ranNum > 60) {
            statPoint = 12;
            status = "Y";
            today = 1;
        }
        return BattleVO.builder()
                .statPoint(statPoint)
                .status(status)
                .today(today)
                .build();
    }

    // 랜덤 스탯 올리기 // 조만제
    public StatVO getStats(int statPoint) {
        List<Integer> stats = new ArrayList<>();
        int range = (int) (Math.random() * 4 + 1);
        int index;

        for (int i = 0; i < range; i++) {
            do {
                index = (int) (Math.random() * 4);
            } while (checkDuplication(stats, index));
            stats.add(i, index);
        }
        return decideStats(stats, statPoint);
    }

    // 랜덤 스탯 로직 중복 체크 // 조만제
    public boolean checkDuplication(List<Integer> stats, int index) {
        for (Integer stat : stats) {
            if (stat == index) {
                return true;
            }
        }
        return false;
    }

    // 올릴 스탯 결정 // 조만제
    public StatVO decideStats(List<Integer> stats, int statPoint) {
        int hp = 0;
        int str = 0;
        int mage = 0;
        int weaponPoint = 0;

        for (Integer stat : stats) {
            String statName = Stats.getStatName(stat);
            if (statName.equals("hp")) {
                hp = statPoint;
            }
            if (statName.equals("str")) {
                str = statPoint;
            }
            if (statName.equals("mage")) {
                mage = statPoint;
            }
            if (statName.equals("weaponPoint")) {
                weaponPoint = statPoint;
            }
        }
        return StatVO.builder()
                .hp(hp)
                .str(str)
                .mage(mage)
                .weaponPoint(weaponPoint)
                .build();
    }


}
























