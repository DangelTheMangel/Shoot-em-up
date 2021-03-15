import processing.core.PApplet;
import processing.data.StringList;

public class main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("main");
    }

    PlayerShip player = new PlayerShip(this);
    @Override
    public void settings() {
        super.settings();
        size(1000,1000);
    }

    @Override
    public void setup() {
        super.setup();
    }

    @Override
    public void draw() {
        clear();
        player.draw();
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
