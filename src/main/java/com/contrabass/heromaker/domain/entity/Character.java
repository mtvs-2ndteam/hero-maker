package com.contrabass.heromaker.domain.entity;

public class Character {
    private final int characterNo;
    private final int userNo;
    private final String nickName;
    private final int hp;
    private final int str;
    private final int mage;
    private final int weaponPoint;
    private final int reputation;
    private final String ending;
    private final String present;
    private final int date;

    public Character(int characterNo, int userNo, String nickName, int hp, int str, int mage, int weaponPoint, int reputation, String ending, String present, int date) {
        this.characterNo = characterNo;
        this.userNo = userNo;
        this.nickName = nickName;
        this.hp = hp;
        this.str = str;
        this.mage = mage;
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

    public int getHp() {
        return hp;
    }

    public int getStr() {
        return str;
    }

    public int getMage() {
        return mage;
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
