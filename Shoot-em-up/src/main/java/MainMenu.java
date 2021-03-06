import processing.core.PApplet;
import processing.core.PImage;

public class MainMenu extends Menu{
    PlayScreen playScreen;
    tutorialScreen tutorialScreen;
    SettingsMenu settingsMenu;
    PImage airPlane;
    int skyBoxInt = 0;
    PImage sky,title;

    float swing = p.random((float) 0.01,(float) 0.09);



    public MainMenu(main p, PlayScreen playScreen, SettingsMenu settingsMenu, tutorialScreen tutorialScreen) {
        super(p);
        this.playScreen = playScreen;
        this.tutorialScreen = tutorialScreen;
        this.settingsMenu = settingsMenu;
        if(Math.random() > 0.49){
            airPlane = p.loadImage("brum.png");
            System.out.println("!");
        }else{
            airPlane = p.loadImage("brum2.png");
        }
        title = p.loadImage("title.png");
        sky = p.loadImage("lowResSky.png");


        Button btnPlay = new Button(p.width/2-150,300,300,75,"Play",p);
        btnPlay.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                playScreen.size = size;
                playScreen.visibale =true;
                playScreen.reSizeGame(size);
            }
        });


        btnList.add(btnPlay);

        Button btnTourtorial = new Button(p.width/2-125,395,250,60,"Tourtorial",p);
        btnTourtorial.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                tutorialScreen.size = size;
                tutorialScreen.visibale =true;
                tutorialScreen.reSizeGame(size);

            }
        });

        btnList.add(btnTourtorial);

        Button btnScoreBord = new Button(p.width/2-100,475,200,50,"ScoreBord",p);
        btnScoreBord.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                main.scoreBoardMenu.reSizeMenu(size);
                main.scoreBoardMenu.calBest = true;
                main.scoreBoardMenu.visibale = true;
            }
        });

        btnList.add(btnScoreBord);

        Button btnOptions = new Button(p.width/2-100,545,200,50,"Settings",p);
        btnOptions.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                settingsMenu.visibale = true;

            }
        });

        btnList.add(btnOptions);

        Button btnExit = new Button(p.width/2-100,625,200,50,"Exit",p);
        btnExit.addAction(new Action() {
            @Override
            public void execute() {
                p.exit();
            }

        });

        btnList.add(btnExit);
        visibale = true;
        addImageToAllBtn(p.loadImage("btn.png"));

    }
    void skyOverlay(int i) {

        p.image(sky, 0, skyBoxInt, p.width, p.height * 2);
        p.image(sky, 0, -p.height * 2 + skyBoxInt, p.width, p.height * 2);
        skyBoxInt += i;

        if (skyBoxInt > p.height*2 ) {
            skyBoxInt = 0;
        }
    }

    @Override
    void draw() {
        p.background(3, 211, 252);



        int xSin = (int) (10*p.sin((float) (p.frameCount * swing)));
        int ySin = (int) (20*p.sin((float) (p.frameCount * swing*2)));

        p.image(airPlane,xSin,ySin,p.width,p.height);
        skyOverlay(1);
        p.image(title,0+(p.width/1.5f)/4,50,p.width/1.5f,300/1.5f*size);
    }

    @Override
    void mousePushed() {

    }


}
