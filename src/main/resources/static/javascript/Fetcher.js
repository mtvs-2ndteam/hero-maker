
export default class Fetcher {

    async requestQuestEventData(scene) {
        await fetchQuest();
        const player = await fetchPlayer();
        scene.optionUI.offUI();
        scene.bar.destroy();
        scene.alertUI.onNextDay(scene);
        this.refreshPlayerStat(scene, player);
        console.log(scene.player.reputation);
    }

    async requestFightEventData(difficulty, scene) {

        const fightFlag = await fetchFight(difficulty);
        const player = await fetchPlayer();

        this.refreshPlayerStat(scene, player);
        scene.fightingUI.deleteFightUI(scene);
        scene.bar.destroy();
        if(fightFlag){
            scene.alertUI.onNextDay(scene);
        }
        else{
            scene.alertUI.onInjured(scene);
        }
    }

    async requestTrainingEventData(scene, kind) {

        await fetchTraining(kind);
        const player = await fetchPlayer();
        scene.trainingUI.deleteTrainingUI();
        scene.bar.destroy();
        scene.alertUI.onNextDay(scene);
        this.refreshPlayerStat(scene, player);
    }

    async requestCharacterData(scene) {
        const player = await fetchPlayer();
        this.refreshPlayerStat(scene, player);
    }

    async requestGiftData(scene) {
        await fetchGift();
        // const player = await fetchPlayer();
    }


    async requestEndingData(scene) {

        const index = await fetchEnding();
        this.endingIndex = "ending" + index.index;
        console.log(this.endingIndex);
        this.endingImage = scene.add.image(800, 450, this.endingIndex);
        this.endingImage.setInteractive(new Phaser.Geom.Rectangle(0, 0, this.endingImage.width, this.endingImage.height), Phaser.Geom.Rectangle.Contains);
        this.endingImage.once('pointerup', function () {
            scene.scene.start('start');
        }, this);
    }

    async requestNewCharacterData(scene) {

        const player = await fetchNewPlayer();
        this.refreshPlayerStat(scene, player);
    }


    refreshPlayerStat(scene, player) {
        scene.player._hp = player.hp;
        scene.player._str = player.str;
        scene.player._mage = player.mage;
        scene.player._weaponPoint = player.weaponPoint;
        scene.player._day = player.today;
        scene.player._reputation = player.reputation;
        scene.player._nickName = player.nickName;

        scene.userInfoUI.refreshStat(scene);
        scene.dayUI.refreshDate(scene.player._day, scene);
    }
}

const fetchEnding = () => {
    return fetch("/ajax/ending-event", {
        method: 'POST'
    }).then(response => response.json())
        .then(data => {
            return{
                index: data
            }
        })
}

const fetchGift = () => {
    return fetch("/ajax/gift-event", {
        method: 'POST'
    })
}

const fetchQuest = () => {
    return fetch("/ajax/quest-event", {
        method: 'POST'
    })
}

const fetchTraining = (kind) => {

    var data = new FormData();
    data.append( "kind", kind);
    return fetch("/ajax/training-event", {
        method: 'POST',
        body: data
    })

}

const fetchPlayer = () => {
    // fetch로 부터 받은 Promise 객체를 리턴
    return fetch("/ajax/character-data", {
        method: 'POST',
    }).then(response => response.json());
}

const fetchNewPlayer = () => {
    // fetch로 부터 받은 Promise 객체를 리턴
    return fetch("/ajax/new-character-data", {
        method: 'POST',
    }).then(response => response.json());
}


const fetchFight = (difficulty) => {

    // let obj = { difficulty: 'difficulty' };
    // console.log(obj);
    var data = new FormData();
    data.append( "difficulty", difficulty );

    return fetch("/ajax/fight-event", {

        method: 'POST',
        body: data
    }).then(response => response.json());
}


