export default class TrainingUI{

    createTrainingUI(scene) {

        this.createSprite(scene);
        this.createText(scene);
        this.insertInteractive(scene);
        this.insertEvent(scene);
    }

    createSprite(scene) {

        // 배경 이미지
        this.background = scene.add.sprite(800, 450, 'trainingRoomBackground').setDepth(9);

        // 아이콘 이미지
        this.hpIcon = scene.add.sprite(250, 450, 'hpIcon').setDepth(10);
        this.strIcon = scene.add.sprite(616, 450, 'strIcon').setDepth(10);
        this.mageIcon = scene.add.sprite(983, 450, 'mageIcon').setDepth(10);
        this.weaponPointIcon = scene.add.sprite(1350, 450, 'weaponPointIcon').setDepth(10);
    }

    createText(scene) {
        // 텍스트
        this.hpText = scene.make.text({
            x: 250,
            y: 608,
            text: "체력",
            style: {
                font: "44px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.strText = scene.make.text({
            x: 616,
            y: 608,
            text: "힘",
            style: {
                font: "44px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.mageText = scene.make.text({
            x: 983,
            y: 608,
            text: "마력",
            style: {
                font: "44px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.weaponPointText = scene.make.text({
            x: 1350,
            y: 608,
            text: "무기술",
            style: {
                font: "44px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.trainingRoomTitletext = scene.make.text({
            x: 800,
            y: 100,
            text: "훈 련 장",
            style: {
                font: "135px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);

        this.infoText = scene.make.text({
            x: 800,
            y: 250,
            text: "훈련을 진행할 스텟을 선택해주세요.",
            style: {
                font: "45px 'omyu_pretty'",
                color: '#ffffff',
            }
        }).setDepth(10).setOrigin(0.5, 0.5);
    }

    insertInteractive(scene) {
        this.hpIcon.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.hpIcon.width, this.hpIcon.height), Phaser.Geom.Rectangle.Contains);
        this.strIcon.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.strIcon.width, this.strIcon.height), Phaser.Geom.Rectangle.Contains);
        this.mageIcon.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.mageIcon.width, this.mageIcon.height), Phaser.Geom.Rectangle.Contains);
        this.weaponPointIcon.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.weaponPointIcon.width, this.weaponPointIcon.height), Phaser.Geom.Rectangle.Contains);
    }

    insertEvent(scene) {
        this.hpIcon.once('pointerup', function(){
            scene.events.startTraining(scene, 1);
            scene.bar = scene.loadingBar.makeBar(0, 0, 1600, 50, 0x00002, scene).setDepth(12);
            scene.barFlag = true;
            scene.time.addEvent({
                delay: 3150,
                callback: ()=>{
                    scene.trainingUI.deleteTrainingUI();
                    scene.bar.destroy();
                    scene.scheduleSelectUI.insertInteractive(scene);
                },
                loop: false
            });

        });
    }

    deleteTrainingUI() {
        this.hpIcon.destroy();
        this.strIcon.destroy();
        this.mageIcon.destroy();
        this.weaponPointIcon.destroy();

        this.strText.destroy();
        this.hpText.destroy();
        this.mageText.destroy();
        this.weaponPointText.destroy();
        this.background.destroy();
        this.trainingRoomTitletext.destroy();
        this.infoText.destroy();
    }
}