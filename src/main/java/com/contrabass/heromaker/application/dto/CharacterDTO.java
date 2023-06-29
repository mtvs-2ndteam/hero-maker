package com.contrabass.heromaker.application.dto;

import com.contrabass.heromaker.domain.entity.CharacterEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {
    private int characterNo;
    private int userNo;
    private String nickName;
    private int hp;
    private int str;
    private int mage;
    private int weaponPoint;
    private int reputation;
    private String gift;
    private int today;
    private String status;

    public CharacterDTO setCharacterDTO(CharacterEntity characterEntity) {
        this.characterNo = characterEntity.getCharacterNo();
        this.userNo = characterEntity.getUserNo();
        this.nickName = characterEntity.getNickName();
        this.hp = characterEntity.getHp();
        this.str = characterEntity.getStr();
        this.mage = characterEntity.getMage();
        this.weaponPoint = characterEntity.getWeaponPoint();
        this.reputation = characterEntity.getReputation();
        this.gift = characterEntity.getGift();
        this.today = characterEntity.getToday();
        this.status = characterEntity.getStatus();
        return this;
    }
}
