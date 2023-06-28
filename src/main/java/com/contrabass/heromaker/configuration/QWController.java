package com.contrabass.heromaker.configuration;

import jdk.jfr.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class QWController {

    @PostMapping("/ajax/village-event")
    @ResponseBody
    public HashMap<String, Object> requestVillageEvent() {

        HashMap<String, Object> map = new HashMap<>();
        System.out.println("여기 들어옴");
        map.put("eventText", "안녕핫엥용");

        return map;
    }

    @PostMapping("/ajax/fight-event")
    @ResponseBody
    public EventDTO requestFightEvent(EventDTO eventDTO) {

        eventDTO.setEventText("전투다 으아앙");

        return eventDTO;
    }

    @PostMapping("/ajax/training-event")
    @ResponseBody
    public EventDTO requestTrainingEvent(EventDTO eventDTO) {

        eventDTO.setEventText("마을 사람들을 도와주장");

        return eventDTO;
    }
}
