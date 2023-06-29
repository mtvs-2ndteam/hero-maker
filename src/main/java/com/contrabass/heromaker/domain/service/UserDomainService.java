package com.contrabass.heromaker.domain.service;

import org.springframework.stereotype.Service;

@Service
public class UserDomainService {

    public String endingNo(int str, int hp, int mage, int weaponPoint, int reputation, String gift) {
        String endingNo = "";
        int lowStat = 30;
        int normalStat = 70;

        if ((str + hp + mage + weaponPoint) / 4 <= lowStat) {
            endingNo = "6";
        }
        if ((str + hp + mage + weaponPoint) / 4 >= normalStat) {
            endingNo = "5";
        }

        if (str > 100) {
            endingNo = "1";
        } else if (hp > 100) {
            endingNo = "2";
        } else if (mage > 100) {
            endingNo = "3";
        } else if (weaponPoint > 100) {
            endingNo = "4";
        }

        if (reputation < 10) {
            endingNo = "8";
        } else if (reputation >= 100) {
            endingNo = "7";
        }


        switch (gift) {
            case "마왕일살검":
                endingNo = "9";
                break;

            case "세계수의 자팡이":
                endingNo = "10";
                break;

            case "가시갑옷":
                endingNo = "11";
                break;
        }

        return endingNo;
    }

    public String statusNo(String endingNo) {
        String statusNo = "";
        if (endingNo != "") {
            statusNo = "Y";
        } else {
            statusNo = "N";
        }

        return statusNo;
    }

}
