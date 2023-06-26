package com.contrabass.subPHS;

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
        map.put("eventText", "안녕핫엥용");

        return map;
    }

    @PostMapping("/ajax/fight-event")
    @ResponseBody
    public EventDTO requestFightEvent(EventDTO eventDTO) {

        eventDTO.setEventText("전투다 으아앙");

        return eventDTO;
    }
}
