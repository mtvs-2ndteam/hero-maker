import Events from "./Events.js";
import TrainingUI from "./TrainingUI.js";
import FightingUI from "./FightingUI.js";
import ScheduleSelectUI from "./ScheduleSelectUI.js";
import Ajax from "./Ajax.js";
import LoadingBar from "./LoadingBar.js";
import Player from "./Player.js";
import UnderBarUI from "./UnderBarUI.js";

export default class GameScene extends Phaser.Scene
{
    init() {

    }
    preload() {

        this.barFlag = false;
        this.bar = null;
        this.barGauge = 0;

        this.player = new Player();
        this.loadingBar = new LoadingBar();
        this.userInfoUI = new UserInformationUI(this);
        this.dayUI = new DayUI(this);
        this.ajax = new Ajax();
        this.events = new Events();
        this.trainingUI = new TrainingUI();
        this.scheduleSelectUI = new ScheduleSelectUI();
        this.fightingUI = new FightingUI();
        this.underBarUI = new UnderBarUI();

        this.load.image("character1", "image/character/전사.png");
        this.load.image("background", "image/마을 2.png");

        // 메뉴 UI 불러오기
        this.load.image("menuBackground", "image/ui/menubackground.png");
        this.load.image("menuBar", "image/ui/menuBar.png");

        // 몬스터 이미지 불러오기
        this.load.image("monster", "image/monster/레이어 90.png");

        // 훈련장 스탯 아이콘들 불러오기
        this.load.image("mageIcon", "image/trainingUi/마력 아이콘.png");
        this.load.image("hpIcon", "image/trainingUi/체력 아이콘.png");
        this.load.image("strIcon", "image/trainingUi/힘 아이콘.png");
        this.load.image("weaponPointIcon", "image/trainingUi/무기술 아이콘.png");

        // 훈련장 배경 이미지
        this.load.image("trainingRoomBackground", "image/background/훈련장 1.png");

        this.load.image("userInformation", "image/내 정보.png");
        this.load.image("dayData", "image/Day.png");
        this.load.image("village", "마을.png");

        this.load.image("underBar", "image/메뉴바.png");
        this.load.image("scheduleBackground", "image/스케줄 1.png");
        this.load.image("selectSquare", "image/선택네모.png");
    }
    create() {

        this.add.image(800, 450, 'background').setDisplaySize(1600, 900).setDepth(1);
        this.character1 = this.add.sprite(800, 450, 'character1').setDepth(2);

        // 유저 인포메이션 UI 생성
        this.userInfoUI.createUserInformationUI();

        // 스케쥴 관련 UI 생성
        this.scheduleSelectUI.createScheduleSelectUI(this);

        // 하단 바 UI 생성
        this.underBarUI.createUnderBarUI(this);

        // 날짜 관련 UI 생성
        this.dayUI.createDayUI();

        // this.character1 = Phaser.Utils.Array.Shuffle(this.character1);

        this.input.on('gameobjectover', (pointer, gameObject) =>
        {

            if (this.barFlag === false) {

                gameObject.setTint(0x7878ff);
            }
        });

        this.input.on('gameobjectout', (pointer, gameObject) =>
        {

            gameObject.clearTint();
        });
    }

    update() {
        if(this.barFlag){
            if(this.barGauge <= 100){

                this.barGauge += 0.2;
                this.loadingBar.setValue(this.bar, this.barGauge);
            }else{

                this.barGauge = 0;
                this.barFlag = false;
            }
        }
    }

    startEnding() {
        this.scene.start('main2');
    }


}