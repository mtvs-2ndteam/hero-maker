

export default class UserInformationUI{
    statBar1 = null;
    statBar2 = null;
    statBar3 = null;
    statBar4 = null;
    statBar1Percentage = 0;
    statBar2Percentage = 0;
    statBar3Percentage = 0;
    statBar4Percentage = 0;

    createUserInformationUI(scene) {

        scene.add.image(800, 450, 'userInformation').setDepth(2);

        // 유저 이름 출력
        scene.make.text({
            x: 205,
            y: 330,
            text: scene.player._nickName,
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

    refreshStat(scene) {
        this.statBar1Percentage = scene.player._hp;
        this.statBar2Percentage = scene.player._str;
        this.statBar3Percentage = scene.player._mage;
        this.statBar4Percentage = scene.player._weaponPoint;

        scene.loadingBar.setValue(this.statBar1, this.statBar1Percentage);
        scene.loadingBar.setValue(this.statBar2, this.statBar2Percentage);
        scene.loadingBar.setValue(this.statBar3, this.statBar3Percentage);
        scene.loadingBar.setValue(this.statBar4, this.statBar4Percentage);
    }
}

