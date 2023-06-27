package com.contrabass.heromaker.domain.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CharacterDomainService {

    // 선물 번호 얻는 로직
    public int getGiftNo(int reputation) {
        Random random = new Random();
        int prob = random.nextInt(10);
        String grade = "";

        if (reputation >= 10 && reputation < 70) {
            grade = "A";
        }
        if (reputation >= 70) {
            grade = "S";
        }
        return getGiftResult(prob, grade);
    }

    public int getGiftResult(int prob, String grade) {
        Random random = new Random();

        if (7 <= prob && grade.equals("A")) {
            return random.nextInt(3) + 1;
        }
        if (prob <= 5 && grade.equals("S")) {
            return random.nextInt(3) + 1;
        }
        return random.nextInt(3) + 4;
    }
}
