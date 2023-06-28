package com.contrabass.heromaker.domain.enumtype;

public enum Stats {
    hp,
    str,
    mage,
    weaponPoint;

    // 인덱스에 해당하는 값 뽑기 // 조만제
    public static String getStatName(int num) {
        String name = "";
        for (int i = 0; i < Stats.values().length; i++) {
            if (num == i) {
                name = String.valueOf(Stats.values()[i]);
                break;
            }
        }
        return name;
    }
}
