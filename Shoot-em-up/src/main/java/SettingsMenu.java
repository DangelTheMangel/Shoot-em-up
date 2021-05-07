import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PSurface;
import processing.core.PVector;
import processing.data.Table;

import javax.swing.*;

public class SettingsMenu extends Menu {
    int displayResolutionInt = 1;
    int lastDisplayResolutionInt = 1;
    int screenWidth, screenHeight;
    String username;
    PImage plane;
    UserInfoPanel infoPanel;
    PVector[] displayResolution = {new PVector(320, 360, 0.4f), new PVector(800, 900, 1f), new PVector(960, 1080, 1.2f)};
    SettingsMenu(PApplet p) {
        super(p);
        Button btnInfo = new Button(p.width/2-100,300,200,50,"edit name",p);
        btnInfo.addAction(new Action() {
            @Override
            public void execute() {
                infoPanel = new UserInfoPanel();
                username = infoPanel.name;

            }
        });
        btnList.add(btnInfo);

        Button btnBack = new Button(p.width/2-100,400,200,50,"Back",p);
        btnBack.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                main.mainMenu.size = size;
                main.mainMenu.reSizeMenu(size);
                main.mainMenu.visibale = true;
            }
        });
        btnList.add(btnBack);

        Button resLeftBtn = new Button(p.width/4, 200, 50, 50,"<",p);
        resLeftBtn.addAction(new Action() {
            @Override
            public void execute() {
                lastDisplayResolutionInt = displayResolutionInt;
                displayResolutionInt--;
                if (displayResolutionInt < 0)
                    displayResolutionInt = displayResolution.length - 1;

                if (displayResolutionInt == displayResolution.length - 1) {

                    screenWidth =  getJFrame(p.getSurface()).getX();
                    screenHeight = getJFrame(p.getSurface()).getY();
                    p.frame.setLocation(0, 0);
                    p.frame.setSize(p.displayWidth/2, p.displayHeight);
                    displayResolution[displayResolution.length-1].z = (p.displayWidth/2)/displayResolution[displayResolution.length-2].x;
                    main.playScreen.sky = p.loadImage("sky.png");
                } else {
                    main.playScreen.sky = p.loadImage("lowResSky.png");
                    p.frame.setLocation(screenWidth, screenHeight);
                    p.frame.setSize((int) displayResolution[displayResolutionInt].x, (int) displayResolution[displayResolutionInt].y);

                }
//lowResSky.png
                size = displayResolution[displayResolutionInt].z;

                // RestSettings();
                reSizeMenu(size);
                System.out.println("size: " + size);
                reSizeMenu(size);

            }
        });
        btnList.add(resLeftBtn);

        Button resRightBtn = new Button((float) (p.width/1.4), 200, 50, 50,">",p);
        resRightBtn.addAction(new Action() {
            @Override
            public void execute() {
                lastDisplayResolutionInt = displayResolutionInt;
                displayResolutionInt++;
                if (displayResolutionInt == displayResolution.length)
                    displayResolutionInt = 0;

                if (displayResolutionInt == displayResolution.length - 1) {
                    System.out.println(displayResolutionInt);
                    screenWidth = getJFrame(p.getSurface()).getX();
                    screenHeight = getJFrame(p.getSurface()).getY();
                    p.frame.setLocation(0, 0);
                    p.frame.setSize(p.displayWidth/2, p.displayHeight);
                    main.playScreen.sky = p.loadImage("sky.png");
                    displayResolution[displayResolution.length-1].z = (p.displayWidth/2)/displayResolution[displayResolution.length-2].x;
                } else {
                    main.playScreen.sky = p.loadImage("lowResSky.png");
                    p.frame.setLocation(screenWidth, screenHeight);
                    p.frame.setSize((int) displayResolution[displayResolutionInt].x, (int) displayResolution[displayResolutionInt].y);
                }

                size = displayResolution[displayResolutionInt].z;


                // RestSettings();
                reSizeMenu(size);
                System.out.println("size: " + size);
                reSizeMenu(size);

            }
        });
        btnList.add(resRightBtn);
        Button musicLeftBtn = new Button(p.width/4, 100, 50, 50,"<",p);
        musicLeftBtn.addAction(new Action() {
            @Override
            public void execute() {
                lastDisplayResolutionInt = displayResolutionInt;
                displayResolutionInt--;
                if (displayResolutionInt < 0)
                    displayResolutionInt = displayResolution.length - 1;

                if (displayResolutionInt == displayResolution.length - 1) {

                    screenWidth =  getJFrame(p.getSurface()).getX();
                    screenHeight = getJFrame(p.getSurface()).getY();
                    p.frame.setLocation(0, 0);
                    p.frame.setSize(p.displayWidth/2, p.displayHeight);
                    displayResolution[displayResolution.length-1].z = (p.displayWidth/2)/displayResolution[displayResolution.length-2].x;
                    main.playScreen.sky = p.loadImage("sky.png");
                } else {
                    main.playScreen.sky = p.loadImage("lowResSky.png");
                    p.frame.setLocation(screenWidth, screenHeight);
                    p.frame.setSize((int) displayResolution[displayResolutionInt].x, (int) displayResolution[displayResolutionInt].y);

                }
//lowResSky.png
                size = displayResolution[displayResolutionInt].z;

                // RestSettings();
                reSizeMenu(size);
                System.out.println("size: " + size);
                reSizeMenu(size);

            }
        });
        btnList.add(musicLeftBtn);
        Button musicRightBtn = new Button((float) (p.width/1.4), 100, 50, 50,">",p);
        musicRightBtn.addAction(new Action() {
            @Override
            public void execute() {
                lastDisplayResolutionInt = displayResolutionInt;
                displayResolutionInt++;
                if (displayResolutionInt == displayResolution.length)
                    displayResolutionInt = 0;

                if (displayResolutionInt == displayResolution.length - 1) {
                    System.out.println(displayResolutionInt);
                    screenWidth = getJFrame(p.getSurface()).getX();
                    screenHeight = getJFrame(p.getSurface()).getY();
                    p.frame.setLocation(0, 0);
                    p.frame.setSize(p.displayWidth/2, p.displayHeight);
                    main.playScreen.sky = p.loadImage("sky.png");
                    displayResolution[displayResolution.length-1].z = (p.displayWidth/2)/displayResolution[displayResolution.length-2].x;
                } else {
                    main.playScreen.sky = p.loadImage("lowResSky.png");
                    p.frame.setLocation(screenWidth, screenHeight);
                    p.frame.setSize((int) displayResolution[displayResolutionInt].x, (int) displayResolution[displayResolutionInt].y);
                }

                size = displayResolution[displayResolutionInt].z;


                // RestSettings();
                reSizeMenu(size);
                System.out.println("size: " + size);
                reSizeMenu(size);

            }
        });
        btnList.add(musicRightBtn);
        addImageToAllBtn(p.loadImage("btn.png"));
        btnList.get(2).addImage(p.loadImage("smollBTN.png"));
        btnList.get(3).addImage(p.loadImage("smollBTN.png"));
        checkIfName();
        plane = p.loadImage("fl.png");
    }

    void checkIfName(){
       Table s =  main.playScreen.scorebord;

       if(s.getString(s.getRowCount()-1,0) == null || s.getString(s.getRowCount()-1,0).equalsIgnoreCase("")){
           infoPanel = new UserInfoPanel();
           username = infoPanel.name;
           System.out.println("username: " + s.getString(s.getRowCount()-1,0));
       }else{
           username = s.getString(s.getRowCount()-1,0);
           System.out.println("username : " + s.getString(s.getRowCount()-1,0));

       }


    }
    boolean beck = false;
    @Override
    void draw() {
        p.background(3, 211, 252);
        main.mainMenu.skyOverlay((int) p.random(0,3));
        p.image(plane,0,0, p.width, p.height);
        String displayInfo = p.width + " X " + p.height;
        p.text(displayInfo,
                (450 - p.textWidth(displayInfo) / 2) * size, (230) * size);
        if(username.equalsIgnoreCase("beck") && !beck){
            beck = true;
            main.soundManager.bgmusic.stop();
            main.soundManager.loopMusic(main.soundManager.musicFiles.get(main.soundManager.musicFiles.size()-1));
        } else if(!username.equalsIgnoreCase("beck") && beck  ) {
            main.soundManager.bgmusic.stop();
            main.soundManager.loopMusic(main.soundManager.musicFiles.get(0));
            beck = false;
        }


    }

    @Override
    void mousePushed() {

    }



    public static final javax.swing.JFrame getJFrame(final PSurface surface) {
        return (javax.swing.JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) surface.getNative()).getFrame();
    }
}
