package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GiftController {

    private final CharacterService characterService;

    @Autowired
    public GiftController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @RequestMapping(value = "/ajax/gift-event", method = RequestMethod.POST)
    @ResponseBody
    public void giftEvent() {
        characterService.insertGift(this.characterService.selectCharacter(1));
    }
}
