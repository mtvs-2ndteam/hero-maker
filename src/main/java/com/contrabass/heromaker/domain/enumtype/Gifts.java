package com.contrabass.heromaker.domain.enumtype;

public enum Gifts {
    마왕일살검,
    세계수의지팡이,
    가시갑옷,
    상인의돈주머니,
    지나가던꼬마가준사탕,
    먹다남은샐러드;

    public static String getName(int num) {
        String name = "";
        for (int i = 0; i < Gifts.values().length; i++) {
            if (num == i) {
                name = String.valueOf(Gifts.values()[i]);
                break;
            }
        }
        return name;
    }
}
