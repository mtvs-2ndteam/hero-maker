
export default class UnderBarUI{

    // 하단 바 제작
    createUnderBarUI(scene) {
        this.underBar = scene.add.image(800, 450, 'underBar').setDepth(3);
        this.underBar.setInteractive(new Phaser.Geom.Rectangle(1400, 800, 200, 100), Phaser.Geom.Rectangle.Contains).setOrigin(0.5, 0.5);
        this.underBar.once('pointerup', function () {
            scene.underBarUI.createMenuUI(scene);
        });
    }

    createMenuUI(scene) {
        scene.scheduleSelectUI.disableInteractive();
        this.menuBackground = scene.add.sprite(800, 450, 'menuBackground').setDepth(9);
        this.contiuneBar = scene.add.sprite(800, 290, 'menuBar').setDepth(10);
        this.mainMenuBar = scene.add.sprite(800, 413, 'menuBar').setDepth(10);
        this.saveBar = scene.add.sprite(800, 537, 'menuBar').setDepth(10);
        this.loadBar = scene.add.sprite(800, 660, 'menuBar').setDepth(10);

        this.contiuneBar.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.contiuneBar.width, this.contiuneBar.height), Phaser.Geom.Rectangle.Contains);
        this.mainMenuBar.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.mainMenuBar.width, this.mainMenuBar.height), Phaser.Geom.Rectangle.Contains);
        this.saveBar.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.saveBar.width, this.saveBar.height), Phaser.Geom.Rectangle.Contains);
        this.loadBar.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.loadBar.width, this.loadBar.height), Phaser.Geom.Rectangle.Contains);

        this.contiuneBar.once('pointerup', function () {
            scene.underBarUI.deleteMenuUI(scene);
        });
        this.saveBar.once()
    }

    deleteMenuUI(scene) {
        scene.scheduleSelectUI.insertInteractive();
        scene.scheduleSelectUI.insertEvent(scene);
        this.menuBackground.destroy();
        this.contiuneBar.destroy();
        this.mainMenuBar.destroy();
        this.saveBar.destroy();
        this.loadBar.destroy();
    }

}
