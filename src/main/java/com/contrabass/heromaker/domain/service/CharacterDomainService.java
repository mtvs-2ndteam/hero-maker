package com.contrabass.heromaker.domain.service;

import com.contrabass.heromaker.domain.enumtype.Gifts;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CharacterDomainService {
    public String getGift(int reputation) {
        Random random = new Random();
        String gift = "";
        
        if (reputation >= 10 && reputation < 70) {
            gift = Gifts.getName(random.nextInt(3));
        }
        if (reputation >= 70) {
            gift = Gifts.getName(random.nextInt(3) + 3);
        }
        return gift;
    }
}
