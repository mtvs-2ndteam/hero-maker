package com.contrabass.heromaker.application.controller;

import com.contrabass.heromaker.application.service.CharacterService;
import com.contrabass.heromaker.application.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TrainingController {

    private final TrainingService trainingService;
    private final CharacterService characterService;

    @Autowired
    public TrainingController(TrainingService trainingService, CharacterService characterService) {
        this.trainingService = trainingService;
        this.characterService = characterService;
    }

    @RequestMapping(value = "/ajax/training-event", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public void trainingEvent(HttpServletRequest request) {
        String param = request.getParameter("kind");

        trainingService.doTraining(this.characterService.selectCharacter(1), param);
    }
}
