package com.contrabass.heromaker.infra.service;

import com.contrabass.heromaker.application.dto.UserDTO;

import javax.servlet.http.HttpSession;

public interface MemberService {
    public String loginCheck(UserDTO dto, HttpSession session);
    public void logout(HttpSession session);
}
