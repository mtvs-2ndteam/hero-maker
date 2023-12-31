export default class FightingUI{
    background;
    createFightingUI(scene){
        this.background = scene.add.sprite(800, 450, 'dungeonBackground').setDepth(9);

        // 아이콘 이미지
        this.easyMonsterIcon = scene.add.sprite(300, 550, 'easyMonster').setDepth(10).setScale(3, 3);
        this.normalMonsterIcon = scene.add.sprite(800, 550, 'normalMonster').setDepth(10).setScale(3, 3);
        this.hardMonsterIcon = scene.add.sprite(1300, 550, 'hardMonster').setDepth(10).setScale(3, 3);

        this.easyDifficultyText = scene.make.text({
            x: 300,
            y: 800,
            text: "쉬움",
            style: {
                font: "44px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.normalDifficultyText = scene.make.text({
            x: 800,
            y: 800,
            text: "보통",
            style: {
                font: "44px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.hardDifficultyText = scene.make.text({
            x: 1300,
            y: 800,
            text: "어려움",
            style: {
                font: "44px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.fightRoomTitletext = scene.make.text({
            x: 800,
            y: 100,
            text: "던 전",
            style: {
                font: "135px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.fightRoomInfoText = scene.make.text({
            x: 800,
            y: 250,
            text: "입장할 던전의 난이도를 선택해주세요.",
            style: {
                font: "45px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.normalMonsterIcon.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.normalMonsterIcon.width, this.normalMonsterIcon.height), Phaser.Geom.Rectangle.Contains);
        this.easyMonsterIcon.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.easyMonsterIcon.width, this.easyMonsterIcon.height), Phaser.Geom.Rectangle.Contains);
        this.hardMonsterIcon.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.hardMonsterIcon.width, this.hardMonsterIcon.height), Phaser.Geom.Rectangle.Contains);

        this.easyMonsterIcon.once('pointerup', function () {
            scene.fightingUI.fightEvent(scene, "쉬움");
        });

        this.normalMonsterIcon.once('pointerup', function () {
            scene.fightingUI.fightEvent(scene, "보통");
        });

        this.hardMonsterIcon.once('pointerup', function () {
            scene.fightingUI.fightEvent(scene, "어려움");
        });
    }

    fightEvent(scene, difficulty) {
        scene.fightingUI.deleteFightIconInteractive();
        scene.bar = scene.loadingBar.makeBar(0, 0, 1600, 50, 	0x808080, scene).setDepth(12);
        scene.barFlag = true;
        scene.time.addEvent({
            delay: 3600,
            callback: ()=>{
                scene.ajax.requestFightEventData(difficulty, scene);
            },
            loop: false
        });
    }

    deleteFightUI(scene) {
        scene.scheduleSelectUI.insertInteractive(scene);
        this.background.destroy();
        this.easyMonsterIcon.destroy();
        this.normalMonsterIcon.destroy();
        this.hardMonsterIcon.destroy();

        this.easyDifficultyText.destroy();
        this.normalDifficultyText.destroy();
        this.hardDifficultyText.destroy();
        this.fightRoomTitletext.destroy();
        this.fightRoomInfoText.destroy();
    }

    deleteFightIconInteractive() {
        this.easyMonsterIcon.disableInteractive();
        this.normalMonsterIcon.disableInteractive();
        this.hardMonsterIcon.disableInteractive();
    }
}