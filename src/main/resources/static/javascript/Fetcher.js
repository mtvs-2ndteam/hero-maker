
export default class Fetcher {

    requestVillageEventData() {
        $.ajax({
            type:"POST",
            url: "/ajax/village-event",
            async: false,
            success : function(response){
                return response;
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                return null;
            }
        });
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

    requestTrainingEventData(kind) {
        $.ajax({
            type: "POST",
            url: "/ajax/training-event",
            data: {
                kind: kind
            },
            async: false,
            success: function (response) {
                return response;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                return null;
            }
        });
    }

    async requestCharacterData(scene) {
        const player = await fetchPlayer();
        this.refreshPlayerStat(scene, player);
    }


    requestEndingData(classA) {
        $.ajax({
            type: "POST",
            url: "/ajax/ending-data",
            async: false,
            success: function (response) {
                classA.response = 1;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                classA.response = 1;
            }
        });
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
    }
}

const fetchPlayer = () => {
    // fetch로 부터 받은 Promise 객체를 리턴
    return fetch("/ajax/character-data", {
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

const fetchTraining = () => {

    return fetch("/ajax/training-event")
}


