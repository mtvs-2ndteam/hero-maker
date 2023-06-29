package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.application.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

@Service
public class UserCheckService {
    public String checkLogin(UserService userService, String id, String pwd, WebRequest request, Model model) {
        String msg = "";
        if (userService.getUserList(id) != null) {
            UserDTO userDTO = userService.getUserList(id);
            if (userDTO.getPwd() != null && userDTO.getPwd().equals(pwd)) {
                if (request.getAttribute("userSession", request.SCOPE_SESSION) != null) {
                    request.removeAttribute("request", request.SCOPE_SESSION);
                }
                request.setAttribute("userSession", userDTO.getUserNo(), request.SCOPE_SESSION);
            } else {
                msg = "잘못된 아이디 또는 비밀번호입니다.";
                model.addAttribute("msg", msg);
                return "content/msg";
            }
        }
        return "content/startGame";
    }

    public String checkRegist(UserService userService, String id, String pwd, String userName, String phone, String email, Model model) {
        String msg;
        if (userService.getUserList(id).getId() == null) {
            int result = userService.insertUser(new UserDTO(1, id, pwd, userName, phone, email));
            if (result == 1) {
                UserDTO userDTO = new UserDTO(0, id, pwd, userName, phone, email);
                userService.insertUser(userDTO);
                model.addAttribute("result", result);
                msg = "회원가입이 완료되었습니다";
                model.addAttribute("msg", msg);
                return "content/msg";
            } else {
                msg = "회원가입 도중 문제가 발생하였습니다";
                model.addAttribute("result", result);
                model.addAttribute("msg", msg);
                return "content/msg";
            }
        } else {
            msg = "중복된 아이디입니다.";
            model.addAttribute("msg", msg);
            return "content/msg";
        }
    }
}
