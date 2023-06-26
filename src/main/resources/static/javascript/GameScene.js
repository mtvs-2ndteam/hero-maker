
class Main extends Phaser.Scene
{
    init() {

    }
    preload() {
        this.barFlag = false;
        this.bar = null;
        this.barGauge = 0;

        this.player = new Player();
        this.loadingBar = new LoadingBar();
        this.userInfoUI = new UserInformationUI(this.player, this);

        this.load.image("character1", "character1.jpg");
        this.background = this.load.image("background", "image/마을 2.png");

        this.load.image("userInformation", "image/내 정보.png");
        this.load.image("dayData", "image/Day.png");
        this.load.image("village", "마을.png");

        this.load.image("underBar", "image/메뉴바.png");
        this.load.image("scheduleBackground", "image/스케줄 1.png");
        this.load.image("selectSquare", "image/선택네모.png");
    }
    create() {

        this.add.image(800, 450, 'background').setDisplaySize(1600, 900).setDepth(1);
        this.character1 = this.add.sprite(800, 450, 'character1').setDepth(2).setScale(0.5, 0.5);

        // 유저 인포메이션 UI 생성
        this.userInfoUI.createUserInformationUI(this);

        // 스케쥴 관련 UI 생성
        createScheduleSelectUI(this);

        // 하단 바 UI 생성
        createUnderBarUI(this);

        // 날짜 관련 UI 생성
        createDayUI(this);

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

        this.select1.once('pointerup', startVillageEvent, this);
        this.select2.once('pointerup', startFightEvent, this);
    }


    loadImage() {
        this.load.once('complete', this.addSprites, this);
        this.scene.start('main2');
        this.load.start();
    }

    addSprites() {
        this.character1.destroy();
    }

    update() {
        if(this.barFlag){
            if(this.barGauge <= 100){
                this.barGauge += 0.2;
                this.loadingBar.setValue(this.bar, this.barGauge);
            }else{
                this.barGauge = 0;
                this.barFlag = false;

                // 로딩 바 지우기
                this.bar.destroy();

                // 텍스트 지우기
                this.eventText.destroy();

                // 로딩 배경 화면 지우기
                if (this.villageEventBackground != null) {
                    this.villageEventBackground.destroy();

                    // 이벤트를 다시 지정해주기
                    this.select1.once('pointerup', startVillageEvent, this);
                }
                if (this.fightEventBackground != null) {
                    this.fightEventBackground.destroy();

                    // 이벤트를 다시 지정해주기
                    this.select2.once('pointerup', startFightEvent, this);
                }
            }
        }
    }
}

const config = {
    type: Phaser.AUTO,
    scale : {
        mode : Phaser.Scale.FIT,
        autoCenter: Phaser.DOM.CENTER_BOTH,
        width: 1600,
        height: 900
    },

    backgroundColor: "#18216D",
    scene: Main
};

const gameScene = new Phaser.Game(config);