package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.dto.CharacterDTO;
import com.contrabass.heromaker.application.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }


    @PostMapping("ajax/character-data")
    @ResponseBody
    public CharacterDTO getCharacterData() {
//        HashMap<String, String> map  = new HashMap<>();
//        CharacterDTO characterDTO = this.characterService.selectCharacter(1);
//
//        map.put("hp", Integer.toString(characterDTO.getHp()));
        return this.characterService.selectCharacter(1);
    }

    @PostMapping("ajax/new-character-data")
    @ResponseBody
    public CharacterDTO newCharacterData() {

        return this.characterService.deleteCharacter(1);
    }
}
