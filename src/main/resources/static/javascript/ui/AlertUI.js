export default class AlertUI {
    onNextDay(scene) {
        scene.dayUI.refreshDate(scene.player._day, scene);
        this.alertNextDayImage = scene.add.sprite(800, 450, 'alertNextDay').setDepth(10);
        this.alpaBackground = scene.add.sprite(800, 450, '50alpaBackground').setDepth(9);
        scene.time.addEvent({
            delay: 1000,
            callback: ()=>{
                this.alertNextDayImage.destroy();
                this.alpaBackground.destroy();
                scene.scheduleSelectUI.insertInteractive(scene);
            },
            loop: false
        });
    }

    onInjured(scene) {
        scene.dayUI.refreshDate(scene.player._day, scene);
        this.alertInjuredImage = scene.add.sprite(800, 450, 'injured').setDepth(10);
        this.alpaBackground = scene.add.sprite(800, 450, '50alpaBackground').setDepth(9);
        scene.time.addEvent({
            delay: 1000,
            callback: ()=>{
                this.alertInjuredImage.destroy();
                this.alpaBackground.destroy();
                scene.scheduleSelectUI.insertInteractive(scene);
            },
            loop: false
        });
    }
};