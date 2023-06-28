package com.contrabass.heromaker;

import com.contrabass.heromaker.application.dto.EndingDTO;
import com.contrabass.heromaker.application.service.EndingCheckService;
import com.contrabass.heromaker.domain.service.UserDomainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Iterator;

@SpringBootTest
public class HeroMakerEndingInsertTest {

    private UserDomainService userDomainService;
    private EndingCheckService endingCheckService;

    @Autowired
    public void setUp(EndingCheckService endingCheckService,UserDomainService userDomainService) {
        this.endingCheckService = endingCheckService;
        this.userDomainService= userDomainService;
    }

    @DisplayName("데이터 삽입 테스트")
    @Test
    void insertTest1() {
        EndingDTO endingDTO=new EndingDTO();

        endingDTO.setUserNo(1);
        endingDTO.setEnding("1");
        endingDTO.setStatus("Y");

        Assertions.assertEquals(1,endingCheckService.insertEnding(endingDTO));
    }

    @DisplayName("데이터 삽입  notNull 테스트")
    @Test
    void insertTest2() {

        EndingDTO endingDTO=new EndingDTO();

        endingDTO.setUserNo(3);
        endingDTO.setEnding("4");
        endingDTO.setStatus("Y");

        Assertions.assertNotNull(endingCheckService.insertEnding(endingDTO));
    }

    @DisplayName("데이터 조회  notNull 테스트")
    @Test
    void insertTest3() {

        int userNo=1;
//        HashSet<String> set=endingCheckService.collectEnding(userNo);
//        Iterator iterator= set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        Assertions.assertNotNull(endingCheckService.collectEnding(userNo));
    }

    @DisplayName("데이터 조회 데이터 일치 테스트")
    @Test
    void insertTest4() {

        int userNo=3;
        String testDBEnding="4";
        HashSet<String> set=endingCheckService.collectEnding(userNo);

        Assertions.assertTrue(set.contains(testDBEnding));
    }
}
