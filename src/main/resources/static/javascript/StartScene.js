export default class GameScene extends Phaser.Scene{

    constructor() {
        super({key: 'start'});
    }
    preload() {
        this.load.image("startBackground", "image/ui/시작화면 1.png");
        this.load.image("title", "image/ui/타이틀.png");
        this.load.image("start", "image/ui/Start.png");
        this.load.image("startLoad", "image/ui/startLoad.png");
    }

    create() {
        this.add.sprite(800, 450, 'startBackground');
        this.add.sprite(800, 200, 'title');
        this.startText = this.add.sprite(650, 600, 'start');
        this.startLoadText = this.add.sprite(950, 600, 'startLoad');

        this.startText.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.startText.width, this.startText.height), Phaser.Geom.Rectangle.Contains);
        this.startLoadText.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.startLoadText.width, this.startLoadText.height), Phaser.Geom.Rectangle.Contains);

        this.startText.once('pointerup', function () {
            this.scene.start('main');
        }, this);
        this.startLoadText.once('pointerup', function () {
            this.scene.start('main');
        }, this);

        this.input.on('gameobjectover', (pointer, gameObject) =>
        {
            gameObject.setTint(0x7878ff);
        });

        this.input.on('gameobjectout', (pointer, gameObject) =>
        {

            gameObject.clearTint();
        });
    }


    update() {

    }
}