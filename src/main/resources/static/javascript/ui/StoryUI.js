export default class StoryUI {
    onUI(scene) {
        this.storyImage = scene.add.sprite(800, 450, 'storyImage');
        this.storyImage.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.storyImage.width, this.storyImage.height), Phaser.Geom.Rectangle.Contains)
        this.storyImage.once('pointerup', function () {
            scene.moveMain();
        });
    }

    offUI(scene) {
        this.storyImage.destroy();
    }
};