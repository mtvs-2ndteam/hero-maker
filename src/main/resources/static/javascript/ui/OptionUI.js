export default class OptionUI {
    newGameFlag = false;

    onTraining(scene) {

        this.onUI(scene, 'ynBackground', true);

        this.yesImage.once('pointerup', function () {
            scene.optionUI.offUI();
            scene.trainingUI.createTrainingUI(scene);
        });

        this.noEvent(scene);
    }

    onFighting(scene) {

        this.onUI(scene, 'ynBackground', true);

        this.yesImage.once('pointerup', function () {
            scene.optionUI.offUI();
            scene.fightingUI.createFightingUI(scene);
        });

        this.noEvent(scene);
    }

    onHelping(scene) {

        this.onUI(scene, 'ynBackground', true);

        this.yesImage.once('pointerup', function () {

            scene.bar = scene.loadingBar.makeBar(0, 0, 1600, 50, 	0x808080, scene).setDepth(12);
            scene.barFlag = true;
            scene.time.addEvent({
                delay: 3600,
                callback: ()=>{
                    scene.ajax.requestQuestEventData(scene);
                },
                loop: false
            });
        });

        this.noEvent(scene);
    }

    onCreateFile(scene) {
        this.onUI(scene, 'createNewFileBackground', false);

        this.yesImage.once('pointerup', function () {
            scene.tintFlag = false;
            this.newGameFlag = true;
            scene.storyUI.onUI(scene);
            scene.optionUI.offUI();
        }, this);

        this.noEvent2(scene);
    }

    onLoadFile(scene) {
        this.onUI(scene, 'loadFileBackground', false);

        this.yesImage.once('pointerup', function () {
            scene.optionUI.offUI();
            this.newGameFlag = false;
            scene.moveMain();
        }, this);

        this.noEvent2(scene);
    }

    onUI(scene, optionBackgroundName, flag) {
        if(flag){
            scene.scheduleSelectUI.disableInteractive();
        }
        else{
            scene.deleteInteractive();
        }

        this.ynBackground = scene.add.sprite(800, 450, optionBackgroundName).setDepth(10);
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
            scene.optionUI.offUI();
            scene.scheduleSelectUI.insertInteractive(scene);
        });
    }

    noEvent2(scene) {
        this.noImage.once('pointerup', function () {
            scene.optionUI.offUI();
            scene.insertInteractive();
        });
    }

}