package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    public UserService userService;


//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public ModelAndView goHome() {
//        ModelAndView mav = new ModelAndView();
//        System.out.println("zzz");
//        List<User> userList = userService.getUserList();
//        System.out.println("userList = " + userList);
//
//        mav.addObject("userList", userList);
//        mav.setViewName("content/home.html");
//
//        return mav;
//    }
}
