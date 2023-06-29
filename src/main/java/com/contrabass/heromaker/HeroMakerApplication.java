package com.contrabass.heromaker;

import com.contrabass.heromaker.common.GameCommon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeroMakerApplication {

    public static void main(String[] args) {
        GameCommon gameCommon = GameCommon.getGameCommon();

        gameCommon.setDaemon(true);
        gameCommon.start();
        SpringApplication.run(HeroMakerApplication.class, args);
    }
}
