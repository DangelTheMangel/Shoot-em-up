import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("main");
    }

    PlayScreen playScreen;
    MainMenu mainMenu;
    @Override
    public void settings() {
        size(1000,1000);

    }

    @Override
    public void setup() {
        frameRate(60);
        playScreen = new PlayScreen(this);
        mainMenu = new MainMenu(this,playScreen);

    }

    @Override
    public void draw() {
        if(playScreen.visibale){
            if(playScreen.player.dead){
                playScreen = new PlayScreen(this);
            }
            playScreen.draw();
        }

        mainMenu.display();
    }

    @Override
    public void keyPressed() {
        playScreen.keyPressed(key,keyCode);
    }

    @Override
    public void keyReleased() {
        playScreen.keyReleased(key,keyCode);
    }

    @Override
    public void mousePressed() {
        mainMenu.mousePressed(mouseX,mouseY);
    }
}
