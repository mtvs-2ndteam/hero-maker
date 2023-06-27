package com.contrabass.heromaker;

import com.contrabass.heromaker.domain.repository.CharacterMapper;
import com.contrabass.heromaker.domain.service.BattleDomainService;
import com.contrabass.heromaker.domain.service.CharacterDomainService;
import com.contrabass.heromaker.domain.vo.BattleResultVO;
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
    private CharacterDomainService characterDomainService;
    private CharacterMapper characterMapper;
    private BattleDomainService battleDomainService;

    @Autowired
    void setUp(CharacterDomainService characterDomainService,
               CharacterMapper characterMapper,
               BattleDomainService battleDomainService) {
        this.characterDomainService = characterDomainService;
        this.characterMapper = characterMapper;
        this.battleDomainService = battleDomainService;
    }

    @DisplayName("랜덤 선물 도메인 테스트")
    @Test
    void giftTest1() {
        Random random = new Random();
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
        GiftVO giftVO = GiftVO.builder()
                .characterNo(1)
                .gift("가시갑옷")
                .build();

        org.junit.jupiter.api.Assertions.assertEquals(1,
                characterMapper.updateCharacterGift(giftVO));
    }

    @DisplayName("Easy 난이도 테스트")
    @Test
    void battleTest1() {
        BattleResultVO battleResultVO1 = BattleResultVO.builder()
                .statPoint(3)
                .status("Y")
                .build();
        BattleResultVO battleResultVO2 = BattleResultVO.builder()
                .statPoint(0)
                .status("N")
                .build();
        List<BattleResultVO> resultList = List.of(battleResultVO1, battleResultVO2);

        Assertions.assertThat(resultList).contains(battleDomainService.getBattleResult("Easy"));
    }

    @DisplayName("Normal 난이도 테스트")
    @Test
    void battleTest2() {
        BattleResultVO battleResultVO1 = BattleResultVO.builder()
                .statPoint(6)
                .status("Y")
                .build();
        BattleResultVO battleResultVO2 = BattleResultVO.builder()
                .statPoint(0)
                .status("N")
                .build();
        List<BattleResultVO> resultList = List.of(battleResultVO1, battleResultVO2);

        Assertions.assertThat(resultList).contains(battleDomainService.getBattleResult("Normal"));
    }

    @DisplayName("Hard 난이도 테스트")
    @Test
    void battleTest3() {
        BattleResultVO battleResultVO1 = BattleResultVO.builder()
                .statPoint(12)
                .status("Y")
                .build();
        BattleResultVO battleResultVO2 = BattleResultVO.builder()
                .statPoint(0)
                .status("N")
                .build();
        List<BattleResultVO> resultList = List.of(battleResultVO1, battleResultVO2);

        Assertions.assertThat(resultList).contains(battleDomainService.getBattleResult("Hard"));
    }

}
