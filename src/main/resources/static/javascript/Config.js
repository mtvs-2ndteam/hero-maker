
import Ending from "./scene/Ending.js";
import GameScene from "./scene/GameScene.js";
import StartScene from "./scene/StartScene.js";

const config = {
    type: Phaser.AUTO,
    scale : {
        mode : Phaser.Scale.FIT,
        autoCenter: Phaser.DOM.CENTER_BOTH,
        width: 1600,
        height: 900
    },

    scene : [StartScene, GameScene, Ending],

    backgroundColor: "#000000",

};

const gameScene = new Phaser.Game(config);