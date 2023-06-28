import OptionUI from "../ui/OptionUI.js";
import EndingUI from "../ui/EndingUI.js";
import StoryUI from "../ui/StoryUI.js";

export default class GameScene extends Phaser.Scene{

    tintFlag = true;
    constructor() {
        super({key: 'start'});
    }
    preload() {
        this.optionUI = new OptionUI();
        this.endingUI = new EndingUI();
        this.storyUI = new StoryUI();

        this.load.image("startBackground", "image/ui/시작화면 1.png");
        this.load.image("title", "image/ui/타이틀.png");
        this.load.image("start", "image/ui/Start.png");
        this.load.image("startLoad", "image/ui/startLoad.png");
        this.load.image("ending", "image/ui/startScene/ending/Ending.png");

        this.load.image("loadFileBackground", "image/ui/저장된_파일을_불러오시겠습니까.png");
        this.load.image("createNewFileBackground", "image/ui/새로운_파일을.png");
        this.load.image("50alpaBackground", "image/ui/반투명 검은 배경.png");
        this.load.image("yes", "image/ui/예.png");
        this.load.image("no", "image/ui/아니오.png");

        // 엔딩 관련
        this.load.image("endingTitle", "image/ui/startScene/ending/endingTitle.png");
        this.load.image("emptyEnding", "image/ui/startScene/ending/emptyEnding.png");
        this.load.image("enableEnding", "image/ui/startScene/ending/엔딩 있음.png");
        this.load.image("endingBackground", "image/ui/startScene/ending/기록의 방 2.png");

        // 스토리 관련
        this.load.image("storyImage", "image/ui/startScene/story/00-1. 스토리.png");
    }

    create() {
        this.add.sprite(800, 450, 'startBackground');
        this.add.sprite(800, 200, 'title');
        this.startText = this.add.sprite(600, 600, 'start');
        this.startLoadText = this.add.sprite(800, 600, 'startLoad');
        this.endingText = this.add.sprite(1000, 600, 'ending');

        this.insertInteractive();

        this.startText.on('pointerup', function () {
            this.optionUI.onCreateFile(this);
        }, this);

        this.startLoadText.on('pointerup', function () {
            this.optionUI.onLoadFile(this);
        }, this);

        this.endingText.on('pointerup', function () {
            this.endingUI.onUI(this);
        }, this);

        this.input.on('gameobjectover', (pointer, gameObject) =>
        {
            if(this.tintFlag){
                gameObject.setTint(0x7878ff);
            }
        });

        this.input.on('gameobjectout', (pointer, gameObject) =>
        {

            gameObject.clearTint();
        });

        this.input.keyboard.addKey("ESC").on('down', function () {
            if(this.endingUI.endingUIFlag){
                this.endingUI.offUI(this);
            }
        }, this);
    }

    insertInteractive() {
        this.startText.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.startText.width, this.startText.height), Phaser.Geom.Rectangle.Contains);
        this.startLoadText.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.startLoadText.width, this.startLoadText.height), Phaser.Geom.Rectangle.Contains);
        this.endingText.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.endingText.width, this.endingText.height), Phaser.Geom.Rectangle.Contains);
    }

    deleteInteractive() {
        this.startText.disableInteractive();
        this.startLoadText.disableInteractive();
        this.endingText.disableInteractive();
    }

    moveMain() {
        this.scene.start('main');
    }


    update() {

    }
}