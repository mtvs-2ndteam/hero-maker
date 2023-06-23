package com.contrabass.heromaker.domain.entity;

public class Character {
    private final int characterNo;
    private final int userNo;
    private final String nickName;
    private final int str;
    private final int Int;
    private final int weaponPoint;
    private final int reputation;
    private final String ending;
    private final String present;
    private final int date;

    public Character(int characterNo, int userNo, String nickName, int str, int anInt, int weaponPoint, int reputation, String ending, String present, int date) {
        this.characterNo = characterNo;
        this.userNo = userNo;
        this.nickName = nickName;
        this.str = str;
        Int = anInt;
        this.weaponPoint = weaponPoint;
        this.reputation = reputation;
        this.ending = ending;
        this.present = present;
        this.date = date;
    }

    public int getCharacterNo() {
        return characterNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public String getNickName() {
        return nickName;
    }

    public int getStr() {
        return str;
    }

    public int getInt() {
        return Int;
    }

    public int getWeaponPoint() {
        return weaponPoint;
    }

    public int getReputation() {
        return reputation;
    }

    public String getEnding() {
        return ending;
    }

    public String getPresent() {
        return present;
    }

    public int getDate() {
        return date;
    }
}
