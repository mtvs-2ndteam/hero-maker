package com.contrabass.heromaker.configuration;

public class EventDTO {
    public String eventText = null;
    public int eventIndex = 0;

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public int getEventIndex() {
        return eventIndex;
    }

    public void setEventIndex(int eventIndex) {
        this.eventIndex = eventIndex;
    }
}

/* 보내야 할 것
* 그냥 이벤트 요청
* 2. 받아야 할 것
* 이벤트 텍스트
* 이벤트 인덱스
* */
