package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.dto.User;
import com.contrabass.heromaker.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    public UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView goHome() {
        ModelAndView mav = new ModelAndView();

        List<User> userList = userService.getUserList();
        System.out.println("userList = " + userList);

        mav.addObject("userList", userList);
        mav.setViewName("content/home.html");

        return mav;
    }
}
