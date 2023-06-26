
// 오른쪽 스케쥴 UI 생성
function createScheduleSelectUI(scene) {
    scene.add.image(800, 450, 'scheduleBackground').setDepth(3);
    scene.select1 = scene.add.sprite(1250, 250, 'selectSquare').setDepth(4);
    scene.select2 = scene.add.sprite(1250, 450, 'selectSquare').setDepth(4);
    scene.select3 = scene.add.sprite(1250, 650, 'selectSquare').setDepth(4);
    scene.select1.setInteractive(new Phaser.Geom.Rectangle(0, 0, scene.select1.width, scene.select1.height), Phaser.Geom.Rectangle.Contains);
    scene.select2.setInteractive(new Phaser.Geom.Rectangle(0, 0, scene.select2.width, scene.select2.height), Phaser.Geom.Rectangle.Contains);
    scene.select3.setInteractive(new Phaser.Geom.Rectangle(0, 0, scene.select3.width, scene.select3.height), Phaser.Geom.Rectangle.Contains);

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