package com.contrabass.heromaker.application.service;

import com.contrabass.heromaker.domain.service.BattleDomainService;
import com.contrabass.heromaker.domain.vo.BattleResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleService {
    private final BattleDomainService battleDomainService;

    @Autowired
    public BattleService(BattleDomainService battleDomainService) {
        this.battleDomainService = battleDomainService;
    }

    public BattleResultVO doBattle(String level) {
        return battleDomainService.getBattleResult(level);
    }
}
