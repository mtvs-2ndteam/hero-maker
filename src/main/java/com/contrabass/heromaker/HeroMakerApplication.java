package com.contrabass.heromaker;

import com.contrabass.heromaker.common.GameCommon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SpringBootApplication
public class HeroMakerApplication {

    public static void main(String[] args) {
        GameCommon gameCommon = GameCommon.getGameCommon();

//        gameCommon.setDaemon(true);
//        gameCommon.start();
        SpringApplication.run(HeroMakerApplication.class, args);
    }

    class WinEvent implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {

        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}
