import processing.core.*;
import processing.data.Table;

public class SettingsMenu extends Menu {
    int displayResolutionInt = 1;
    int lastDisplayResolutionInt = 1;
    int screenWidth, screenHeight;
    int textSize = 16;
    String username;
    PImage plane;
    UserInfoPanel infoPanel;
    PVector[] displayResolution = {new PVector(320, 360, 0.4f), new PVector(800, 900, 1f), new PVector(960, 1080, 1.2f)};

    //the list of sounds volume and what to type on the screen
    PVector[] volumes ={new PVector(0,-80),new PVector(0.25f,-20),new PVector(0.50f,0),new PVector(0.75f,3),new PVector(1,6)};
    //this variable tells where on the volume list one has reached
    int musicVolInt =2;
    int sfxVolInt =2;
    SettingsMenu(PApplet p) {
        super(p);
        Button btnInfo = new Button(150,600,200,50,"edit name",p);
        btnInfo.addAction(new Action() {
            @Override
            public void execute() {
                infoPanel = new UserInfoPanel();

                if(infoPanel.name != null){
                    username = infoPanel.name;
                }else {
                    username = "player";
                }

            }
        });


      btnList.add(btnInfo);

        Button btnBack = new Button(p.width/2-100,p.height-100,200,50,"Back",p);
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


        Button resLeftBtn = new Button(150, 450, 50, 50,"<",p);
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

                size = displayResolution[displayResolutionInt].z;

                // RestSettings();
                reSizeMenu(size);
                System.out.println("size: " + size);
                reSizeMenu(size);

            }
        });

        btnList.add(resLeftBtn);

        Button resRightBtn = new Button(p.width-150, 450, 50, 50,">",p);
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

        //music volm
        btnList.add(resRightBtn);
        Button musicLeftBtn = new Button(150, 290, 50, 50,"<",p);

        musicLeftBtn.addAction(new Action() {
            @Override
            public void execute() {


                if(musicVolInt -1 !=  -1){
                    musicVolInt -= 1;

                    main.soundManager.changeVolume(volumes[musicVolInt].y, main.soundManager.bgmusic);

                }
                System.out.println("- volume: " + volumes[musicVolInt]);

            }
        });
        btnList.add(musicLeftBtn);




        Button musicRightBtn = new Button(p.width- 150, 290, 50, 50,">",p);
        musicRightBtn.addAction(new Action() {
            @Override
            public void execute() {

                if(musicVolInt +1 !=  volumes.length){
                    musicVolInt += 1;
                    main.soundManager.changeVolume(volumes[musicVolInt].y, main.soundManager.bgmusic);

                }
                System.out.println("- volume: " + volumes[musicVolInt]);


            }
        });

        btnList.add(musicRightBtn);

        ////
        Button sfxLeftBtn = new Button(p.width-150, 180, 50, 50,">",p);

        sfxLeftBtn.addAction(new Action() {
            @Override
            public void execute() {

                if(sfxVolInt +1 !=  volumes.length){
                    sfxVolInt += 1;


                }
                System.out.println("- volume: " + volumes[musicVolInt]);
            }
        });
        btnList.add(sfxLeftBtn);


        Button sfxrightBtn = new Button(150, 180, 50, 50,"<",p);

        sfxrightBtn.addAction(new Action() {
            @Override
            public void execute() {
                if(sfxVolInt -1 !=  -1){
                    sfxVolInt -= 1;


                }
                System.out.println("- volume: " + volumes[musicVolInt]);
            }
        });
        btnList.add(sfxrightBtn);


        addImageToAllBtn(p.loadImage("btn.png"));
       /* btnList.get(2).addImage(p.loadImage("smollBTN.png"));
        btnList.get(3).addImage(p.loadImage("smollBTN.png"));*/
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
        p.strokeWeight(1);
        p.textSize(16*size);
        p.background(3, 211, 252);
        main.mainMenu.skyOverlay((int) p.random(0,3));
        p.image(plane,0,0, p.width, p.height);
        p.fill(200,200,200,200);
        p.rect(0,0,p.width,p.height);
        p.fill(0);
        String displayInfo = p.width + " X " + p.height;
        p.text(displayInfo,
                (450 - p.textWidth(displayInfo) / 2) * size, (480) * size);
        if(username.equalsIgnoreCase("beck") && !beck){
            beck = true;
            main.soundManager.bgmusic.stop();
            main.soundManager.loopMusic(main.soundManager.musicFiles.get(main.soundManager.musicFiles.size()-1));
        } else if(!username.equalsIgnoreCase("beck") && beck  ) {
            main.soundManager.bgmusic.stop();
            main.soundManager.loopMusic(main.soundManager.musicFiles.get(0));
            beck = false;
        }
        audioLevelVisual(250,180,350,50,sfxVolInt);
        audioLevelVisual(250,290,350,50,musicVolInt);

        p.fill(0);
        p.textSize(16*size*4);
        p.strokeWeight(4);
        p.text("Settings ", p.width/2,50 *size);
        p.line(0,16*size*4,p.width,16*size*4);

        p.textAlign(p.LEFT);
        p.textSize(16*size*3);
        p.text("Volume: ", 100*size,120*size);
        p.text("Screen Resolution: ", 100*size,425*size);
        p.text("User: ", 100*size,580*size);
        p.strokeWeight(1);
        p.textSize(textSize *2*size);
        p.text("Username: " + username, 380*size,635*size);
    }

    @Override
    void mousePushed() {

    }

    void audioLevelVisual(int x, int y, int xW, int yW,int i){
       p.fill(0);
       p.rect(x*size,y*size,xW*size,yW*size);
       p.fill(0, 98, 227);
       p.rect(x*size,y*size,xW*size*volumes[i].x,yW*size);
       p.fill(255);
       p.rect(x*size + xW*size*volumes[i].x,y*size-2.5f*size, 5*size,(yW+5)*size);
    }



    public static final javax.swing.JFrame getJFrame(final PSurface surface) {
        return (javax.swing.JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) surface.getNative()).getFrame();
    }
}
