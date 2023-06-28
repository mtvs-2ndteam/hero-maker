

export default class DayUI{

    dayText;

    createDayUI(scene) {
        scene.add.image(800, 450, 'dayData').setDepth(2);

        this.dayText = scene.make.text({
            x: 335,
            y: 90,
            text: "30",
            style: {
                font: "48px 'omyu_pretty'",
                color: '#ffffff'
            }
        }).setDepth(3).setOrigin(1, 0.5);
    }

    refreshDate(date, scene) {

        // 기존의 날짜를 삭제
        if (this.dayText != null) {
            this.dayText.destroy();
        }

        // 새로운 바뀐 날짜를 생성
        this.dayText = scene.make.text({
            x: 335,
            y: 90,
            text: date,
            style: {
                font: "48px 'omyu_pretty'",
                color: '#ffffff'
            }
        }).setDepth(3).setOrigin(1, 0.5);
    }
}