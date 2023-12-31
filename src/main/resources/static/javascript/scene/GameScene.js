
import TrainingUI from "../ui/TrainingUI.js";
import FightingUI from "../ui/FightingUI.js";
import ScheduleSelectUI from "../ui/ScheduleSelectUI.js";
import Fetcher from "../Fetcher.js";
import LoadingBar from "../LoadingBar.js";
import Player from "../Player.js";
import UnderBarUI from "../ui/UnderBarUI.js";
import OptionUI from "../ui/OptionUI.js";
import UserInformationUI from "../ui/UserInformationUI.js";
import DayUI from "../ui/DayUI.js";
import AlertUI from "../ui/AlertUI.js";


export default class GameScene extends Phaser.Scene
{
    constructor() {
        super({key: 'main'});
    }
    init() {

    }
    preload() {

        this.progressBar();

        this.newGameFlag = false;
        this.barFlag = false;
        this.bar = null;
        this.barGauge = 0;
        this.optionUI = new OptionUI();
        this.player = new Player();
        this.loadingBar = new LoadingBar();
        this.userInfoUI = new UserInformationUI();
        this.dayUI = new DayUI();
        this.ajax = new Fetcher();
        this.trainingUI = new TrainingUI();
        this.scheduleSelectUI = new ScheduleSelectUI();
        this.fightingUI = new FightingUI();
        this.underBarUI = new UnderBarUI();
        this.alertUI = new AlertUI();

        this.loadImage();
    }
    create() {

        this.add.image(800, 450, 'background').setDisplaySize(1600, 900).setDepth(1);
        this.character1 = this.add.sprite(800, 450, 'character1').setDepth(2);

        // 유저 인포메이션 UI 생성
        this.userInfoUI.createUserInformationUI(this);

        // 스케쥴 관련 UI 생성
        this.scheduleSelectUI.createScheduleSelectUI(this);

        // 하단 바 UI 생성
        this.underBarUI.createUnderBarUI(this);

        // 날짜 관련 UI 생성
        this.dayUI.createDayUI(this);


        console.log(newGameFlag);
        if (newGameFlag) {
            this.ajax.requestNewCharacterData(this);
        }else{
            this.ajax.requestCharacterData(this);
        }

        this.dayUI.refreshDate(this.player._day, this);

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

    moveStartScene() {
        this.scene.start('start');
    }

    moveEnding() {
        this.scene.start('ending');
    }

    loadImage() {
        this.load.image("character1", "image/character/전사.png");
        this.load.image("background", "image/마을 2.png");

        // 메뉴 UI 불러오기
        this.load.image("menuBackground", "image/ui/menubackground2.png");
        this.load.image("continue", "image/ui/Continue.png");
        this.load.image("load", "image/ui/load.png");
        this.load.image("mainMenu", "image/ui/Main Menu.png");
        this.load.image("save", "image/ui/Save.png");

        // 예 아니오 UI 불러오기
        this.load.image("loadFileBackground", "image/ui/저장된_파일을_불러오시겠습니까.png");
        this.load.image("createNewFileBackground", "image/ui/새로운_파일을.png");
        this.load.image("ynBackground", "image/ui/booleanBackground.png");
        this.load.image("50alpaBackground", "image/ui/반투명 검은 배경.png");
        this.load.image("yes", "image/ui/예.png");
        this.load.image("no", "image/ui/아니오.png");

        // 알림 이미지 불러오기
        this.load.image("alertNextDay", "image/ui/alert/nextDay.png");
        this.load.image("injured", "image/ui/alert/injured.png");

        // 몬스터 이미지 불러오기
        this.load.image("easyMonster", "image/monster/주황버섯.png");
        this.load.image("normalMonster", "image/monster/다크_스텀프.png");
        this.load.image("hardMonster", "image/monster/불독.png");

        // 훈련장 스탯 아이콘들 불러오기
        this.load.image("mageIcon", "image/trainingUi/마력 아이콘.png");
        this.load.image("hpIcon", "image/trainingUi/체력 아이콘.png");
        this.load.image("strIcon", "image/trainingUi/힘 아이콘.png");
        this.load.image("weaponPointIcon", "image/trainingUi/무기술 아이콘.png");

        // 훈련장 배경 이미지
        this.load.image("trainingRoomBackground", "image/background/훈련장 1.png");

        this.load.image("dungeonBackground", "image/background/던전 2.png");

        this.load.image("userInformation", "image/내 정보.png");
        this.load.image("dayData", "image/Day.png");
        this.load.image("village", "마을.png");

        this.load.image("underBar", "image/메뉴바.png");
        this.load.image("scheduleBackground", "image/스케줄 1.png");
        this.load.image("scheduleTrainingIcon", "image/ui/schedule/훈련장 아이콘.png");
        this.load.image("scheduleFightingIcon", "image/ui/schedule/던전 아이콘.png");
        this.load.image("scheduleHelpingIcon", "image/ui/schedule/마을 아이콘.png");
    }

    progressBar() {
        var progressBar = this.add.graphics();
        var progressBox = this.add.graphics();
        progressBox.fillStyle(0x222222, 0.8);
        progressBox.fillRect(630, 450, 320, 50);

        var loadingText = this.make.text({
            x: 800,
            y: 400,
            text: '로딩중...',
            style: {
                font: "35px 'omyu_pretty'",
                fill: '#ffffff'
            }
        });
        loadingText.setOrigin(0.5, 0.5);

        var percentText = this.make.text({
            x: 800,
            y: 472,
            text: '0%',
            style: {
                font: "20px 'omyu_pretty'",
                fill: '#ffffff'
            }
        });
        percentText.setOrigin(0.5, 0.5);

        var assetText = this.make.text({
            x: 800,
            y: 700,
            text: '',
            style: {
                font: "65px 'omyu_pretty'",
                fill: '#ffffff'
            }
        });
        assetText.setOrigin(0.5, 0.5);

        this.load.on('progress', function (value) {
            percentText.setText(parseInt(value * 100) + '%');
            progressBar.clear();
            progressBar.fillStyle(0xffffff, 1);
            progressBar.fillRect(637.5, 457.5, 300 * value, 30);
        });

        this.load.on('fileprogress', function (file) {
            assetText.setText('로딩중인 파일 : ' + file.key);
        });
        this.load.on('complete', function () {
            progressBar.destroy();
            progressBox.destroy();
            loadingText.destroy();
            percentText.destroy();
            assetText.destroy();
        });

    }
}