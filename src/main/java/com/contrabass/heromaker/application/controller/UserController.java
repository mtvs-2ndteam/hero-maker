package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/insert")
    public String insertUser( WebRequest request){
        ModelAndView mav = new ModelAndView();
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        UserDTO userdto = new UserDTO(1,id,password,password,password,password);

        int result = userService.insertUser(userdto);
        mav.addObject("insertUser", result);
        mav.setViewName("content/login.html");
        return "content/home";
    }
    // db 테스트
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView goHome() {
        ModelAndView mav = new ModelAndView();

        List<UserDTO> userList = userService.getUserList();
        System.out.println("userList = " + userList);

        mav.addObject("userList", userList);
        mav.setViewName("content/home.html");

        return mav;
    }

}
