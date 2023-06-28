
// 오른쪽 스케쥴 UI 생성
export default class ScheduleSelectUI {

    select1Flag = false;
    select2Flag = false;
    select3Flag = false;
    createScheduleSelectUI(scene) {

        // 이미지 생성
        this.createSprite(scene);

        // 텍스트 생성
        this.createText(scene);

        // 상호작용 가능한 이미지들에게 상호작용 주기
        this.insertInteractive(scene);

        // 상호작용에 이벤트 연결하기
        this.insertEvent(scene);
    }

    insertEvent(scene) {
        if(!this.select1Flag){
            this.select1.once('pointerup', function(){scene.trainingUI.createTrainingUI(scene)});
            this.select1Flag = true;
        }
        if (!this.select2Flag) {
            this.select2.once('pointerup', function() {scene.fightingUI.createFightingUI(scene)});
            this.select2Flag = true;
        }
        if(!this.select3Flag){
            this.select3.once('pointerup', scene.startEnding, scene);
            this.select3Flag = true;
        }
    }

    createSprite(scene) {
        scene.add.sprite(800, 450, 'scheduleBackground').setDepth(3);
        this.select1 = scene.add.sprite(1250, 250, 'selectSquare').setDepth(4);
        this.select2 = scene.add.sprite(1250, 450, 'selectSquare').setDepth(4);
        this.select3 = scene.add.sprite(1250, 650, 'selectSquare').setDepth(4);
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
