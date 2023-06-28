
export default class Events {

    startHelpingEvent(scene) {
        scene.ajax.requestVillageEventData();

        scene.userInfoUI.refreshStat(scene);
    }

    startTrainingEvent(scene, kind) {
        this.response = scene.ajax.requestTrainingEventData(kind);
        // scene.player._hp = this.response.hp;
        // scene.player._str = this.response.str;
        // scene.player._mage = this.response.mage;
        // scene.player._weaponPoint = this.response.weaponPoint;

        scene.userInfoUI.refreshStat(scene);
    }

}


    // startFightEvent(scene, difficulty){
    //
    // }
