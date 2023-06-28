package com.contrabass.heromaker.domain.entity;

public class CharacterEntity {
    private final int characterNo;
    private final int userNo;
    private final String nickName;
    private final int hp;
    private final int str;
    private final int mage;
    private final int weaponPoint;
    private final int reputation;
    private final String gift;
    private final int today;
    private final String status;

    public CharacterEntity(int characterNo, int userNo, String nickName, int hp, int str,
                           int mage, int weaponPoint, int reputation, String gift, int today, String status) {
        this.characterNo = characterNo;
        this.userNo = userNo;
        this.nickName = nickName;
        this.hp = hp;
        this.str = str;
        this.mage = mage;
        this.weaponPoint = weaponPoint;
        this.reputation = reputation;
        this.gift = gift;
        this.today = today;
        this.status = status;
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

    public String getGift() {
        return gift;
    }

    public int getToday() {
        return today;
    }

    public String getStatus() {
        return status;
    }
}
