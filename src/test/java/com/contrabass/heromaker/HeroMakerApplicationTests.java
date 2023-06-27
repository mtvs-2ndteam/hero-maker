package com.contrabass.heromaker;

import com.contrabass.heromaker.domain.repository.CharacterMapper;
import com.contrabass.heromaker.domain.service.CharacterDomainService;
import com.contrabass.heromaker.domain.vo.GiftVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class HeroMakerApplicationTests {
    //    private CharacterService characterService;
    private CharacterDomainService characterDomainService;
    private CharacterMapper characterMapper;
    private Random random;

    @Autowired
    void setUp(CharacterDomainService characterDomainService,
               CharacterMapper characterMapper) {
        this.characterDomainService = characterDomainService;
        this.characterMapper = characterMapper;
        this.random = new Random();
    }

    @DisplayName("랜덤 선물 도메인 테스트")
    @Test
    void giftTest1() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        int prob = random.nextInt(10);
        int result1 = characterDomainService.getGiftResult(prob, "A");
        int result2 = characterDomainService.getGiftResult(prob, "S");

        Assertions.assertThat(list).contains(result1);
        Assertions.assertThat(list).contains(result2);
    }

    @DisplayName("랜덤 선물 DB에 저장 테스트")
    @Test
    void giftTest2() {
        GiftVO giftVO = GiftVO.builder().characterNo(1).gift("가시갑옷").build();

        org.junit.jupiter.api.Assertions.assertEquals(1,
                characterMapper.updateCharacterGift(giftVO));
    }

    @DisplayName("쉬움    ")
    @Test
    void battleTest1() {

    }

    @DisplayName("")
    @Test
    void battleTest2() {

    }

    @DisplayName("")
    @Test
    void battleTest3() {

    }

}
