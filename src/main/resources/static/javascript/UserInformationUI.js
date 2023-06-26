

class UserInformationUI{
    statBar1 = null;
    statBar2 = null;
    statBar3 = null;
    statBar4 = null;
    statBar1Percentage = 0;
    statBar2Percentage = 0;
    statBar3Percentage = 0;
    statBar4Percentage = 0;

    player
    scene

    constructor(player, scene) {
        this.player = player;
        this.scene = scene;
    }

    createUserInformationUI(scene) {

        scene.add.image(800, 450, 'userInformation').setDepth(2);

        // 유저 이름 출력
        scene.make.text({
            x: 205,
            y: 330,
            text: "쿠크냐",
            style: {
                font: "55px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(3).setOrigin(0.5, 0.5);




        // 스텟 텍스트 표시
        scene.make.text({
            x: 150,
            y: 440,
            text: "체력",
            style: {
                font: "40px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(3).setOrigin(1, 0.5);

        scene.make.text({
            x: 150,
            y: 510,
            text: "힘",
            style: {
                font: "40px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(3).setOrigin(1, 0.5);

        scene.make.text({
            x: 150,
            y: 580,
            text: "마력",
            style: {
                font: "40px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(3).setOrigin(1, 0.5);

        scene.make.text({
            x: 150,
            y: 650,
            text: "무기술",
            style: {
                font: "40px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(3).setOrigin(1, 0.5);






        // 스탯들 바 생성하기

        this.statBar1 = scene.loadingBar.makeBar(165, 430,
            170, 25, '#ffffff', scene).setDepth(4);
        this.statBar2 = scene.loadingBar.makeBar(165, 500,
            170, 25, '#ffffff', scene).setDepth(4);
        this.statBar3 = scene.loadingBar.makeBar(165, 570,
            170, 25, '#ffffff', scene).setDepth(4);
        this.statBar4 = scene.loadingBar.makeBar(165, 640,
            170, 25, '#ffffff', scene).setDepth(4);

        this.statBar1Percentage = 100;

        scene.loadingBar.setValue(this.statBar1, this.statBar1Percentage);
        scene.loadingBar.setValue(this.statBar2, this.statBar2Percentage);
        scene.loadingBar.setValue(this.statBar3, this.statBar3Percentage);
        scene.loadingBar.setValue(this.statBar4, this.statBar4Percentage);
    }

    setStat(int) {
        this.statBar1Percentage = this.player.get().hp;
        this.statBar2Percentage = this.player.get().str;
        this.statBar3Percentage = this.player.get().mage;
        this.statBar4Percentage = this.player.get().weaponPoint;

        this.scene.loadingBar.setValue(this.statBar1, this.statBar1Percentage);
        this.scene.loadingBar.setValue(this.statBar2, this.statBar2Percentage);
        this.scene.loadingBar.setValue(this.statBar3, this.statBar3Percentage);
        this.scene.loadingBar.setValue(this.statBar4, this.statBar4Percentage);
    }
}

