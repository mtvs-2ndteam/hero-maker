import Ending from "./Ending.js";
import GameScene from "./GameScene.js";

const config = {
    type: Phaser.AUTO,
    scale : {
        mode : Phaser.Scale.FIT,
        autoCenter: Phaser.DOM.CENTER_BOTH,
        width: 1600,
        height: 900
    },
    scene : [GameScene, Ending],

    backgroundColor: "#18216D",

};

const gameScene = new Phaser.Game(config);