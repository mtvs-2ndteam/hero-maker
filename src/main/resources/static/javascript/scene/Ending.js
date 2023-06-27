export default class Ending extends Phaser.Scene
{
    constructor() {
        super({key: 'main2'});
    }
    preload() {
        this.load.image('endingImage', 'image/엔딩.png');
    }

    create() {
        this.add.image(800, 450, 'endingImage').setDisplaySize(1600, 900);
    }
}