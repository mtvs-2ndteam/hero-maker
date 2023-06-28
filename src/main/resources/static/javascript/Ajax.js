
export default class Ajax{

    _villageEventText;

    requestVillageEventData() {
        $.ajax({
            type:"POST",
            url: "/ajax/village-event",
            async: false,
            success : function(response){
                alert("통신 성공");
                this._villageEventText = response.eventText;
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("통신 실패.")
            }
        });
    }

    requestFightEventData() {
        $.ajax({
            type: "POST",
            url: "/ajax/fight-event",
            data: {
                eventIndex: 1
            },
            async: false,
            success: function (response) {
                this._villageEventText = response;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("통신 실패.")
            }
        });
    }

    requestTrainingEventData(index) {
        $.ajax({
            type: "POST",
            url: "/ajax/training-event",
            data: {
                statIndex: index
            },
            async: false,
            success: function (response) {
                alert("통신 성공.")
                return response;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("통신 실패.")
                return null;
            }
        });
    }

    get villageEventText() {
        return this._villageEventText;
    }

    set villageEventText(value) {
        this._villageEventText = value;
    }
}

