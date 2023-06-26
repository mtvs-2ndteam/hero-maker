package com.contrabass.heromaker.domain.dao;

import com.contrabass.heromaker.application.dto.UserDTO;

public interface MemberDAO {
    public String loginCheck(UserDTO dto);
}
