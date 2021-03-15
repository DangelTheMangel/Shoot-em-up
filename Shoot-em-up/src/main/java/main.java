import processing.core.PApplet;
import processing.core.PVector;
import processing.data.StringList;

public class main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("main");
    }

    PlayerShip player ;
    @Override
    public void settings() {
        size(1000,1000);
    }

    @Override
    public void setup() {
        player = new PlayerShip(this,new PVector(0,0),50,50);

    }

    @Override
    public void draw() {
        clear();
        player.display();
        player.shoot();
    }

    @Override
    public void keyPressed() {
        player.controls(key,keyCode,true);
    }

    @Override
    public void keyReleased() {
        player.controls(key,keyCode,false);
    }






}
