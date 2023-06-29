package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.service.CharacterService;
import com.contrabass.heromaker.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EndingController {

    private final UserService userService;
    private final CharacterService characterService;

    @Autowired
    public EndingController(UserService userService, CharacterService characterService) {
        this.userService = userService;
        this.characterService = characterService;
    }

    @RequestMapping(value = "/ajax/ending-event", method = RequestMethod.POST)
    @ResponseBody
    public String endingEvent() {
        return userService.getEnding(this.characterService.selectCharacter(1));
    }
}
