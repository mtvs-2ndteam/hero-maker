package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.service.BattleService;
import com.contrabass.heromaker.application.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BattleController {
    private final BattleService battleService;
    private final CharacterService characterService;

    @Autowired
    public BattleController(BattleService battleService, CharacterService characterService) {
        this.battleService = battleService;
        this.characterService = characterService;
    }

    @RequestMapping(value = "/ajax/fight-event", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean fightEvent(HttpServletRequest request) {

        String param = request.getParameter("difficulty");
        int indexFlag = this.battleService.doBattle(this.characterService.selectCharacter(1), param);

        if (indexFlag == 1) {
            return true;
        } else if (indexFlag == 0) {
            return false;
        } else {
            return false;
        }
    }
}
