export default class EndingUI {

    endingUIFlag = false;
    endingList = [];

    onUI(scene) {
        scene.deleteInteractive();
        this.endingUIFlag = true;
        scene.deleteInteractive();
        this.endingTitle = scene.add.sprite(800, 450, 'endingTitle').setDepth(10);
        this.endingBackground = scene.add.sprite(800, 450, 'endingBackground').setDepth(9);
        this.emptyEnding = scene.add.sprite(800, 450, 'emptyEnding').setDepth(10);

        this.addEnding(scene);
    }

    offUI(scene){
        scene.insertInteractive();
        this.endingUIFlag = false;
        this.endingTitle.destroy();
        this.endingBackground.destroy();
        this.emptyEnding.destroy();
        this.endingList[1].destroy();
    }

    addEnding(scene){
        this.endingList[1] = scene.add.sprite(335, 360, 'enableEnding').setDepth(11);
    }
};