
export default class LoadingBar{

     makeBar(x, y, width, height, color, scene) {

         let bar = scene.add.graphics().setDepth(7);

         bar.fillStyle( color,1);

        bar.fillRect(0, 0, width, height);

        bar.x = x;
        bar.y = y;

        //return the bar
        return bar;
    }
     setValue(bar2, percentage) {
        //scale the bar
        bar2.scaleX = percentage/100;
    }
}