import OptionUI from "../OptionUI.js";

export default class GameScene extends Phaser.Scene{

    constructor() {
        super({key: 'start'});
    }
    preload() {
        this.optionUI = new OptionUI();

        this.load.image("startBackground", "image/ui/시작화면 1.png");
        this.load.image("title", "image/ui/타이틀.png");
        this.load.image("start", "image/ui/Start.png");
        this.load.image("startLoad", "image/ui/startLoad.png");

        this.load.image("loadFileBackground", "image/ui/저장된_파일을_불러오시겠습니까.png");
        this.load.image("createNewFileBackground", "image/ui/새로운_파일을.png");
        this.load.image("50alpaBackground", "image/ui/반투명 검은 배경.png");
        this.load.image("yes", "image/ui/예.png");
        this.load.image("no", "image/ui/아니오.png");
    }

    create() {
        this.add.sprite(800, 450, 'startBackground');
        this.add.sprite(800, 200, 'title');
        this.startText = this.add.sprite(650, 600, 'start');
        this.startLoadText = this.add.sprite(950, 600, 'startLoad');

        this.insertInteractive();

        this.startText.on('pointerup', function () {
            this.optionUI.onCreateFile(this);
        }, this);

        this.startLoadText.on('pointerup', function () {
            this.optionUI.onLoadFile(this);
        }, this);

        this.input.on('gameobjectover', (pointer, gameObject) =>
        {
            gameObject.setTint(0x7878ff);
        });

        this.input.on('gameobjectout', (pointer, gameObject) =>
        {

            gameObject.clearTint();
        });
    }

    insertInteractive() {
        this.startText.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.startText.width, this.startText.height), Phaser.Geom.Rectangle.Contains);
        this.startLoadText.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.startLoadText.width, this.startLoadText.height), Phaser.Geom.Rectangle.Contains);
    }

    deleteInteractive() {
        this.startText.disableInteractive();
        this.startLoadText.disableInteractive();
    }

    moveMain() {
        this.scene.start('main');
    }


    update() {

    }
}