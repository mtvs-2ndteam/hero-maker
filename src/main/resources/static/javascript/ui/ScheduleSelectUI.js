
// 오른쪽 스케쥴 UI 생성
export default class ScheduleSelectUI {

    createScheduleSelectUI(scene) {

        // 이미지 생성
        this.createSprite(scene);

        // 텍스트 생성
        this.createText(scene);

        // 상호작용 가능한 이미지들에게 상호작용 주기
        this.insertInteractive(scene);

        // 상호작용에 이벤트 연결하기
        this.insertEvents(scene);
    }

    insertEvents(scene) {
        this.select1.on('pointerup', function(){
            scene.optionUI.onTraining(scene);
        });
        this.select2.on('pointerup', function() {
            scene.optionUI.onFighting(scene);
        });
        this.select3.on('pointerup', function () {
            scene.optionUI.onHelping(scene);
        });
    }

    createSprite(scene) {
        scene.add.sprite(800, 450, 'scheduleBackground').setDepth(3);
        this.select1 = scene.add.sprite(1250, 250, 'scheduleTrainingIcon').setDepth(4);
        this.select2 = scene.add.sprite(1250, 450, 'scheduleFightingIcon').setDepth(4);
        this.select3 = scene.add.sprite(1250, 650, 'scheduleHelpingIcon').setDepth(4);
    }

    createText(scene) {
        scene.make.text({
            x: 1350,
            y: 250,
            text: "훈련장",
            style: {
                font: "60px 'omyu_pretty'",
                color: '#ffffff'
            }
        }).setDepth(4).setOrigin(0, 0.5);

        scene.make.text({
            x: 1350,
            y: 450,
            text: "전투",
            style: {
                font: "60px 'omyu_pretty'",
                color: '#ffffff'
            }
        }).setDepth(4).setOrigin(0, 0.5);

        scene.make.text({
            x: 1350,
            y: 650,
            text: "마을",
            style: {
                font: "60px 'omyu_pretty'",
                color: '#ffffff'
            }
        }).setDepth(4).setOrigin(0, 0.5);
    }

    insertInteractive(scene) {
        this.select1.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.select1.width, this.select1.height), Phaser.Geom.Rectangle.Contains);
        this.select2.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.select2.width, this.select2.height), Phaser.Geom.Rectangle.Contains);
        this.select3.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.select3.width, this.select3.height), Phaser.Geom.Rectangle.Contains);
    }

    disableInteractive() {
        this.select1.disableInteractive();
        this.select2.disableInteractive();
        this.select3.disableInteractive();
    }
}
