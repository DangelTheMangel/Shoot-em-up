import processing.core.PApplet;
import processing.core.PVector;
import processing.data.Table;

import java.util.ArrayList;

public class main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("main");
    }

    public static PlayScreen playScreen;
    tutorialScreen tutorialScreen;
    EndScreenMenu endScreenMenu;
    public static MainMenu mainMenu;
    public static ScoreBoard scoreBoardMenu;
    SettingsMenu settingsMenu;
    Table scoreBord;


    @Override
    public void settings() {
        size(800,900);

    }

    @Override
    public void setup() {
        frameRate(60);
        scoreBord =loadTable("scorebord.csv");
        playScreen = new PlayScreen(this,scoreBord);
        tutorialScreen = new tutorialScreen(this,scoreBord);
        settingsMenu = new SettingsMenu(this);
        scoreBoardMenu = new ScoreBoard(this,playScreen);
        endScreenMenu = new EndScreenMenu(this,playScreen);
        mainMenu = new MainMenu(this,playScreen,settingsMenu,tutorialScreen);
    }

    @Override
    public void draw() {
        clear();
        background(200);
        if(playScreen.visibale){
            if(playScreen.player.dead){
                playScreen.newGame = true;

                playScreen.saveScooreBord();

                playScreen.newGame();
                endScreenMenu.reSizeMenu(playScreen.size);
                endScreenMenu.calBest = true;
                endScreenMenu.visibale = true;
            }
            playScreen.draw();
        }

        if(tutorialScreen.visibale){
            if(tutorialScreen.player.dead){
                tutorialScreen.saveScooreBord();
                tutorialScreen = new tutorialScreen(this,scoreBord);
                mainMenu.tutorialScreen = tutorialScreen;
                mainMenu.visibale = true;
            }
            tutorialScreen.draw();
        }

        mainMenu.display();
        settingsMenu.display();
        scoreBoardMenu.display();
        endScreenMenu.display();
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
        endScreenMenu.mousePressed(mouseX,mouseY);
    }
}