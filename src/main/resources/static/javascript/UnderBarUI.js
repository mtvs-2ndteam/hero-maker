
export default class UnderBarUI{

    // 하단 바 제작
    createUnderBarUI(scene) {
        this.underBar = scene.add.image(800, 450, 'underBar').setDepth(3);
        this.underBar.setInteractive(new Phaser.Geom.Rectangle(1400, 800, 200, 100), Phaser.Geom.Rectangle.Contains).setOrigin(0.5, 0.5);
        this.insertEvent(scene);
    }

    createMenuUI(scene) {
        scene.scheduleSelectUI.disableInteractive();

        this.createSprite(scene);
        this.insertInteractive(scene);

        this.contiuneBar.once('pointerup', function () {
            scene.underBarUI.deleteMenuUI(scene);
        });

        this.mainMenuBar.once('pointerup', function () {
            scene.moveStartScene();
        });
    }

    createSprite(scene) {
        this.alpaBackground = scene.add.sprite(800, 450, '50alpaBackground').setDepth(8);
        this.menuBackground = scene.add.sprite(800, 450, 'menuBackground').setDepth(9);
        this.contiuneBar = scene.add.sprite(800, 290, 'continue').setDepth(10);
        this.mainMenuBar = scene.add.sprite(800, 413, 'mainMenu').setDepth(10);
        this.saveBar = scene.add.sprite(800, 537, 'save').setDepth(10);
        this.loadBar = scene.add.sprite(800, 660, 'load').setDepth(10);
    }

    insertInteractive(scene) {
        this.contiuneBar.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.contiuneBar.width, this.contiuneBar.height), Phaser.Geom.Rectangle.Contains);
        this.mainMenuBar.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.mainMenuBar.width, this.mainMenuBar.height), Phaser.Geom.Rectangle.Contains);
        this.saveBar.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.saveBar.width, this.saveBar.height), Phaser.Geom.Rectangle.Contains);
        this.loadBar.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.loadBar.width, this.loadBar.height), Phaser.Geom.Rectangle.Contains);
    }

    insertEvent(scene) {
        this.underBar.once('pointerup', function () {
            scene.underBarUI.createMenuUI(scene);
        });
    }

    deleteMenuUI(scene) {
        scene.scheduleSelectUI.insertInteractive();
        this.alpaBackground.destroy();
        this.menuBackground.destroy();
        this.contiuneBar.destroy();
        this.mainMenuBar.destroy();
        this.saveBar.destroy();
        this.loadBar.destroy();
        this.insertEvent(scene);
    }

}
