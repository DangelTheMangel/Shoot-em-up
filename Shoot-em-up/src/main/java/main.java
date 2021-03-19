import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("main");
    }

    PlayScreen playScreen;
    @Override
    public void settings() {
        size(1000,1000);
    }

    @Override
    public void setup() {
        playScreen = new PlayScreen(this);


    }

    @Override
    public void draw() {
        playScreen.draw();
    }

    @Override
    public void keyPressed() {
        playScreen.keyPressed(key,keyCode);
    }

    @Override
    public void keyReleased() {
        playScreen.keyReleased(key,keyCode);
    }






}
