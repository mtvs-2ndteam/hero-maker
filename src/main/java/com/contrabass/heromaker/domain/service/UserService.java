package com.contrabass.heromaker.domain.service;

import com.contrabass.heromaker.domain.entity.User;
import com.contrabass.heromaker.domain.repository.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public Mapper mapper;

    public List<User> getUserList() {
        return mapper.getUserList();
    }
}
