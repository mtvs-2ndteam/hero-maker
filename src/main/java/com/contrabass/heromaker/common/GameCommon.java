package com.contrabass.heromaker.common;

import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

@Component
public class GameCommon extends Thread {
    private static GameCommon gameCommon;

    private GameCommon() {
    }

    public static GameCommon getGameCommon() {
        if (gameCommon == null) {
            gameCommon = new GameCommon();
        }
        return gameCommon;
    }

    public void run() {
        try {
            String path = System.getProperty("user.dir")
                    + "\\src\\main\\resources\\bgm\\qweasdzxc.wav";
            File file = new File(path);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            Thread.sleep(3000);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            try {
                Thread.sleep(clip.getMicrosecondLength() / 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
        }
    }
}
