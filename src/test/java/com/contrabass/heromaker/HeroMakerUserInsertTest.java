package com.contrabass.heromaker;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HeroMakerUserInsertTest {

//    private UserService userService;
//    private UserInfraRepository userInfraRepository;
//
//    @Autowired
//    public void setUp(UserService userService, UserInfraRepository userInfraRepository) {
//        this.userService = userService;
//        this.userInfraRepository = userInfraRepository;
//    }

//    @DisplayName("데이터 삽입 테스트")
//    @Test
//    void insertTest1() {
//        UserDTO userDTO=new UserDTO(0,"test1","test1","test1","test1","test1");
//
//        Assertions.assertEquals(1,userService.insertUser(userDTO));
//    }

//    @DisplayName("데이터 조회  notNull 테스트")
//    @Test
//    void insertTest2() {
//        UserDTO userDTO = new UserDTO(0, "test1", "test1", "test1", "test1", "test1");
//
//        Assertions.assertNotNull(userService.insertUser(userDTO));
//    }
//
//    @DisplayName("데이터 조회 테스트")
//    @Test
//    void selectTest() {
//        int userNo = 1;
//        UserDTO userDTO = new UserDTO(1, "test1", "test1", "test1", "test1", "test1");
//
//        Assertions.assertNotNull(userService.getUser(1)); //받아온 값이 null인지 비교
//
//        Assertions.assertEquals(userDTO.getUserNo(), userService.getUser(1).getUserNo()); //받아온 값과 db의 있는 값이 같은지 비교
//
//        org.assertj.core.api.Assertions.assertThat(userDTO).isInstanceOf(UserDTO.class); //받아온 데이터가 UserDTO 타입인지 확인
//
//        org.assertj.core.api.Assertions.assertThat(userDTO).usingRecursiveComparison().isEqualTo(userDTO);  //받아온 데이터가 테스트 데이터와 같은지 확인
//    }


}
