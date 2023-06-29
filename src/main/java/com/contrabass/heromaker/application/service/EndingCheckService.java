package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.application.dto.EndingDTO;
import com.contrabass.heromaker.application.dto.UserDTO;
import com.contrabass.heromaker.domain.entity.Ending;
import com.contrabass.heromaker.domain.entity.User;
import com.contrabass.heromaker.domain.repository.UserMapper;
import com.contrabass.heromaker.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class EndingCheckService {
    private final UserDomainService userDomainService;
    private final UserMapper userMapper;

    @Autowired
    public EndingCheckService(UserDomainService userDomainService, UserMapper userMapper) {
        this.userDomainService = userDomainService;
        this.userMapper = userMapper;
    }

    public int getEnding() {
//        this.userDomainService.endingNo()
        return 1;
    }

    public int insertEnding(EndingDTO endingDTO){

        Ending ending =new Ending(
                endingDTO.getEndingNo(),
                endingDTO.getUserNo(),
                endingDTO.getEnding(),
                endingDTO.getStatus()
                );

        return userMapper.insertEndingNo(ending);
    }

    public HashSet<String> collectEnding(int userNo){
        List<Ending> endingList = userMapper.getEndingList(userNo);
        HashSet<String> result = new HashSet<>();
        int listSize = endingList.size();

        for (int i = 0; i < listSize; i++) {
            if(endingList.get(i).getStatus().equals("Y")){
                result.add(endingList.get(i).getEnding());
            }
        }
        return result;
    }
}
