package com.contrabass.heromaker.domain.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserDomainService {
    public String endingNo(int str,int hp,int mage, int weaponPoint,int reputation,String gift) {
        String endingNo="";
        int lowStat=30;
        int normalStat=70;

        if(str<=lowStat&&hp<=lowStat&&mage<=lowStat&&weaponPoint<=lowStat){
            endingNo="6";
        }
        if(str>=normalStat&&hp>=normalStat&&mage>=normalStat&&weaponPoint>=normalStat){
            endingNo="5";
        }

        if(str>100){
            endingNo="1";
        }else if(hp>100){
            endingNo="2";
        }else if(mage>100){
            endingNo="3";
        }else if(weaponPoint >100){
            endingNo="4";
        }

        if(reputation <=5){
            endingNo="8";
        }else if (reputation >=100){
            endingNo="7";
        }

        switch (gift){
            case "마왕일살검" :
                endingNo ="9";
            break;

            case "세계수의 자팡이" :
                endingNo = "10";
            break;

            case "가시값옷":
                endingNo="11";
            break;
        }

        System.out.println(endingNo);

        return endingNo;
    }

    public String statusNo(String endingNo){
        String statusNo="";
        if(endingNo!=""){
            statusNo="Y";
        }else {
            statusNo="N";
        }

        return statusNo;
    }

}
