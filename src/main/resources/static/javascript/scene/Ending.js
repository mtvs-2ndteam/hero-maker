import Fetcher from "../Fetcher.js";

export default class Ending extends Phaser.Scene
{
    constructor() {
        super({key: 'ending'});
    }
    preload() {
        this.load.image('endingImage', 'image/엔딩.png');
        this.load.image("ending1", "image/ui/endingImage/엔딩1.png");
        this.load.image("ending2", "image/ui/endingImage/엔딩2.png");
        this.load.image("ending3", "image/ui/endingImage/엔딩3.png");
        this.load.image("ending4", "image/ui/endingImage/엔딩4.png");
        this.load.image("ending5", "image/ui/endingImage/엔딩5.png");
        this.load.image("ending6", "image/ui/endingImage/엔딩6.png");
        this.load.image("ending7", "image/ui/endingImage/엔딩7.png");
        this.load.image("ending8", "image/ui/endingImage/엔딩8.png");
        this.load.image("ending9", "image/ui/endingImage/엔딩9.png");
        this.load.image("ending10", "image/ui/endingImage/엔딩10.png");
        this.load.image("ending11", "image/ui/endingImage/엔딩11.png");

        this.ajaxUI = new Fetcher();
    }

    create() {
        this.ajaxUI.requestEndingData(this);

    }


}