package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.service.CharacterService;
import com.contrabass.heromaker.application.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestController {

    private final QuestService questService;
    private final CharacterService characterService;

    @Autowired
    public QuestController(QuestService questService, CharacterService characterService) {
        this.questService = questService;
        this.characterService = characterService;
    }

    @RequestMapping(value = "/ajax/quest-event", method = RequestMethod.POST)
    @ResponseBody
    public void questEvent() {
        this.questService.doQuest(this.characterService.selectCharacter(1), "마을");
    }
}
