
export default class Events{

    startVillageEvent(scene) {
        scene.ajax.requestVillageEventData();
        scene.bar = this.loadingBar.makeBar(0, 0, 1600, 100, 0x222222, this);
        scene.barFlag = true;
        scene.eventText = this.make.text({
            x: 800,
            y: 450,
            text: this.ajax._villageEventText,
            style: {
                fontSize: '30px',
                fill: '#ff0091',
                align: 'center'
            }
        }).setDepth(99);
    }

    startTraining(scene, index){
        this.response = scene.ajax.requestTrainingEventData(index);
        // scene.player._hp = this.response.hp;
        // scene.player._str = this.response.str;
        // scene.player._mage = this.response.mage;
        // scene.player._weaponPoint = this.response.weaponPoint;

        scene.userInfoUI.refreshStat(scene);
    }


    startFightEvent(){
        alert(this.ajax.villageEventText);
        this.ajax.requestFightEventData();
        this.bar = this.loadingBar.makeBar(300, 400, 1600, 100, 0x222222, this);
        this.fightEventBackground = this.add.sprite(800, 450, 'village').setDepth(6).setDisplaySize(1000, 500);
        this.barFlag = true;
    }
}
