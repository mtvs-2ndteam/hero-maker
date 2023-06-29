package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.service.UserCheckService;
import com.contrabass.heromaker.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final UserService userService;
    private final UserCheckService userCheckService;

    @Autowired
    public UserController(UserService userService, UserCheckService userCheckService) {
        this.userService = userService;
        this.userCheckService = userCheckService;
    }

    @GetMapping("/content/login")
    public void login() {
    }

    @GetMapping("/logout")
    public String logout(Model model, WebRequest request) {
        String msg = "";
        request.removeAttribute("userSession", request.SCOPE_SESSION);
        int result = 3;
        msg = "로그아웃 되었습니다.";
        model.addAttribute("msg", msg);
        model.addAttribute("result", result);
        return "content/msg";
    }

    @PostMapping("/content/login")
    public String LoginMenu(Model model, WebRequest request) {
        String id = request.getParameter("userName");
        String pwd = request.getParameter("userPassword");

        return userCheckService.checkLogin(userService, id, pwd, request, model);
    }

    @GetMapping("/content/register")
    public void register() {
    }

    @PostMapping("/content/register")
    public String RegisterMenu(Model model, WebRequest request) {
        String id = request.getParameter("id");
        String pwd = request.getParameter("password");
        String userName = request.getParameter("nickname");
        String phone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        return userCheckService.checkRegist(userService, id, pwd, userName, phone, email, model);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView goHome(WebRequest request) {
        ModelAndView mav = new ModelAndView();
        String returnURL = "";

        if (request.getAttribute("userSession", request.SCOPE_SESSION) != null) {
            mav.addObject("result", 2);
            returnURL = "content/startGame";
        } else {
            returnURL = "content/home";
        }
        mav.setViewName(returnURL);

        return mav;
    }
}
