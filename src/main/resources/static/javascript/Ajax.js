let response;
export default class Ajax{
    response;

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

    requestFightEventData(difficulty) {
        $.ajax({
            type: "POST",
            url: "/ajax/fight-event",
            data: {
                difficulty: difficulty
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

    requestPlayerData() {
        $.ajax({
            type: "POST",
            url: "/ajax/player-data",
            async: false,
            success: function (response) {
                this.response = response;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                this.response = 1;
            }
        });
        return response;
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


}

