import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("main");
    }

    PlayScreen playScreen;
    tutorialScreen tutorialScreen;
    public static MainMenu mainMenu;
    public static ScoreBoard scoreBoardMenu;
    SettingsMenu settingsMenu;


    @Override
    public void settings() {
        size(1000,1000);

    }

    @Override
    public void setup() {
        frameRate(60);
        playScreen = new PlayScreen(this);
        tutorialScreen = new tutorialScreen(this);
        settingsMenu = new SettingsMenu(this);
        scoreBoardMenu = new ScoreBoard(this,playScreen);
        mainMenu = new MainMenu(this,playScreen);
    }

    @Override
    public void draw() {
        clear();
        background(200);
        if(playScreen.visibale){
            if(playScreen.player.dead){
                playScreen = new PlayScreen(this);
            }
            playScreen.draw();
        }

        if(tutorialScreen.visibale){
            if(tutorialScreen.player.dead){
                tutorialScreen = new tutorialScreen(this);
            }
            tutorialScreen.draw();
        }
        mainMenu.display();
        settingsMenu.display();
        scoreBoardMenu.display();
    }

    @Override
    public void keyPressed() {
        playScreen.keyPressed(key,keyCode);
        tutorialScreen.keyPressed(key,keyCode);
    }

    @Override
    public void keyReleased() {
        playScreen.keyReleased(key,keyCode);
        tutorialScreen.keyReleased(key,keyCode);
    }

    @Override
    public void mousePressed() {
        mainMenu.mousePressed(mouseX,mouseY);
        settingsMenu.mousePressed(mouseX,mouseY);
        scoreBoardMenu.mousePressed(mouseX,mouseY);
    }
}
