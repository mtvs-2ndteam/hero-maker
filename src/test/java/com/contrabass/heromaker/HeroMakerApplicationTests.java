package com.contrabass.heromaker;

import com.contrabass.heromaker.application.dto.BattleDTO;
import com.contrabass.heromaker.domain.repository.CharacterMapper;
import com.contrabass.heromaker.domain.service.BattleDomainService;
import com.contrabass.heromaker.domain.service.CharacterDomainService;
import com.contrabass.heromaker.domain.vo.BattleVO;
import com.contrabass.heromaker.domain.vo.StatVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
//        GiftResultDTO giftResultDTO = new GiftResultDTO(
//                1
//                ,"가시갑옷"
//                ,3
//              );
//
//        org.junit.jupiter.api.Assertions.assertEquals(1,
//                characterMapper.updateCharacterGift(giftResultDTO));
    }

    @DisplayName("쉬움 난이도 결과값 테스트")
    @Test
    void battleTest1() {
        BattleVO battleResultVO1 = BattleVO.builder()
                .statPoint(3)
                .status("Y")
                .today(1)
                .build();
        BattleVO battleResultVO2 = BattleVO.builder()
                .statPoint(0)
                .status("N")
                .today(3)
                .build();
        List<BattleVO> resultList = List.of(battleResultVO1, battleResultVO2);

        Assertions.assertThat(resultList)
                .contains(battleDomainService.getBattleResult("쉬움"));
    }

    @DisplayName("보통 난이도 결과값 테스트")
    @Test
    void battleTest2() {
        BattleVO battleResultVO1 = BattleVO.builder()
                .statPoint(6)
                .status("Y")
                .today(1)
                .build();
        BattleVO battleResultVO2 = BattleVO.builder()
                .statPoint(0)
                .status("N")
                .today(3)
                .build();
        List<BattleVO> resultList = List.of(battleResultVO1, battleResultVO2);

        Assertions.assertThat(resultList)
                .contains(battleDomainService.getBattleResult("보통"));
    }

    @DisplayName("어려움 난이도 결과값 테스트")
    @Test
    void battleTest3() {
        BattleVO battleResultVO1 = BattleVO.builder()
                .statPoint(12)
                .status("Y")
                .today(1)
                .build();
        BattleVO battleResultVO2 = BattleVO.builder()
                .statPoint(0)
                .status("N")
                .today(3)
                .build();
        List<BattleVO> resultList = List.of(battleResultVO1, battleResultVO2);

        Assertions.assertThat(resultList)
                .contains(battleDomainService.getBattleResult("어려움"));
    }

    @DisplayName("랜덤 스탯 인덱스 중복 체크 테스트")
    @Test
    void indexTest() {
        List<Integer> stats = new ArrayList<>();
        stats.add(0, 3);
        stats.add(1, 2);
        stats.add(2, 0);

        org.junit.jupiter.api.Assertions
                .assertTrue(battleDomainService.checkDuplication(stats, 3));
        org.junit.jupiter.api.Assertions
                .assertFalse(battleDomainService.checkDuplication(stats, 1));
    }

    @DisplayName("올릴 스텟 결정 테스트")
    @Test
    void decideTest() {
        StatVO statVO = StatVO.builder()
                .hp(3)
                .str(0)
                .mage(3)
                .weaponPoint(3)
                .build();
        List<Integer> stats = new ArrayList<>();
        stats.add(0, 3);
        stats.add(1, 2);
        stats.add(2, 0);

        org.junit.jupiter.api.Assertions
                .assertEquals(statVO, battleDomainService.decideStats(stats, 3));
    }

    @DisplayName("DB에 전투 결과 저장 테스트")
    @Test
    void saveTest() {
        BattleDTO battleDTO = new BattleDTO(
                1
                , 6
                , 6
                , 6
                , 0
                , 17
                , "Y");

        org.junit.jupiter.api.Assertions.assertEquals(1,
                characterMapper.saveBattleResult(battleDTO));
    }

}
