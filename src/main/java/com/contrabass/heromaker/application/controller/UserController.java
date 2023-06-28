package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // db 테스트
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView goHome() {
        ModelAndView mav = new ModelAndView();

//        List<UserDTO> userList = userService.getUserList();
//        System.out.println("userList = " + userList);


//        mav.addObject("userList", userList);
        mav.setViewName("content/home.html");

        return mav;
    }

//    @RequestMapping
//    public String UserLoginCheck(HttpSession session){
//        String returnURL="";
//
//        if(session.getAttribute("loginrCheck")!=null){
//            session.removeAttribute("loginrCheck");
//        }
//
//        //유효성 검사
//
//        //유저 정보 저장
//        UserDTO userDTO=new UserDTO();
//        userService.insertUser(userDTO);
//
//        //UserNo 값을 유저 세션에 담음
//        if(userService.getUser(1).getId()!=null&&userService.getUser(1).getPwd()!=null){
//            session.setAttribute("loginCheck",userService.getUser(1).getUserNo());
//            returnURL ="main";
//        }else{
//            returnURL = "form";
//        }
//
//        return returnURL;
//    }


//    @RequestMapping
//    public String UserLogout(HttpSession session){
//        String returnURL ="";
//        session.invalidate();
//        returnURL="/login";
//
//        return returnURL;
//    }
}
