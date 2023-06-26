function startVillageEvent() {
    requestVillageEventData();
    this.bar = this.loadingBar.makeBar(0, 0, 1600, 100, 0x222222, this);
    this.villageEventBackground = this.add.sprite(800, 450, 'village').setDepth(6).setDisplaySize(1000, 500);
    this.barFlag = true;
    this.eventText = this.make.text({
        x: 800,
        y: 450,
        text: villageEventText,
        style: {
            fontSize: '30px',
            fill: '#ff0091',
            align: 'center'
        }
    }).setDepth(99);
}


function startFightEvent(){
    alert(this.villageEventText);
    requestFightEventData();
    this.bar = this.loadingBar.makeBar(300, 400, 1600, 100, 0x222222, this);
    this.fightEventBackground = this.add.sprite(800, 450, 'village').setDepth(6).setDisplaySize(1000, 500);
    this.barFlag = true;
}