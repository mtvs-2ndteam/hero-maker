package com.contrabass.heromaker;

import com.contrabass.heromaker.domain.service.CharacterDomainService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HeroMakerApplicationTests {
    private CharacterDomainService characterDomainService;

    @Autowired
    public void setUp(CharacterDomainService characterDomainService) {
        this.characterDomainService = new CharacterDomainService();
    }

    @DisplayName("평판 10이상 70미만 랜덤 선물 테스트")
    @Test
    void giftTest() {
        List<String> list = List.of("마왕일살검", "세계수의지팡이", "가시갑옷");

        Assertions.assertThat(list).contains(characterDomainService.getGift(69));
    }

    @DisplayName("평판 70이상 랜덤 선물 테스트")
    @Test
    public void giftTest2() {
        List<String> list = List.of("상인의돈주머니", "지나가던꼬마가준사탕", "먹다남은샐러드");

        Assertions.assertThat(list).contains(characterDomainService.getGift(70));
    }


}
