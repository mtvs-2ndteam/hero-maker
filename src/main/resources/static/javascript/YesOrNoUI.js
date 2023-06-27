export default class YesOrNoUI{

    onTraining(scene) {

        this.onUI(scene);

        this.yesImage.once('pointerup', function () {
            scene.yesOrNoUI.offUI();
            scene.trainingUI.createTrainingUI(scene);
        });

        this.noEvent(scene);
    }

    onFighting(scene) {

        this.onUI(scene);

        this.yesImage.once('pointerup', function () {
            scene.yesOrNoUI.offUI();
            scene.fightingUI.createFightingUI(scene);
        });

        this.noEvent(scene);
    }

    onHelping(scene) {

        this.onUI(scene);

        this.yesImage.once('pointerup', function () {
            scene.yesOrNoUI.offUI();

        });
    }

    onUI(scene) {
        scene.scheduleSelectUI.disableInteractive();

        this.ynBackground = scene.add.sprite(800, 450, 'ynBackground').setDepth(10);
        this.alpaBackground = scene.add.sprite(800, 450, '50alpaBackground').setDepth(9);
        this.yesImage = scene.add.sprite(1150, 700, 'yes').setDepth(10);
        this.noImage = scene.add.sprite(1270, 700, 'no').setDepth(10);

        this.yesImage.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.yesImage.width, this.yesImage.height), Phaser.Geom.Rectangle.Contains);
        this.noImage.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.noImage.width, this.noImage.height), Phaser.Geom.Rectangle.Contains);
    }

    offUI() {
        this.ynBackground.destroy();
        this.alpaBackground.destroy();
        this.yesImage.destroy();
        this.noImage.destroy();
    }

    noEvent(scene) {
        this.noImage.once('pointerup', function () {
            scene.yesOrNoUI.offUI();
            scene.scheduleSelectUI.insertInteractive(scene);
        });
    }

}