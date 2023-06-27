package com.contrabass.heromaker.domain.entity;

public class Gift {
    private final int giftNo;
    private final String gift;

    public Gift(int giftNo, String gift) {
        this.giftNo = giftNo;
        this.gift = gift;
    }

    public int getGiftNo() {
        return giftNo;
    }

    public String getGift() {
        return gift;
    }
}
