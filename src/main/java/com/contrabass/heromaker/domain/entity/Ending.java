package com.contrabass.heromaker.domain.entity;

public class Ending {
    private final int endingNo;
    private final int userNo;
    private final String ending;
    private final String status;

    public Ending(int endingNo, int userNo, String ending, String status) {
        this.endingNo = endingNo;
        this.userNo = userNo;
        this.ending = ending;
        this.status = status;
    }

    public int getEndingNo() {
        return endingNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public String getEnding() {
        return ending;
    }

    public String getStatus() {
        return status;
    }
}
