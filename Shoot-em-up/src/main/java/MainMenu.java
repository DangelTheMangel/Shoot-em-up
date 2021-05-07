import processing.core.PApplet;
import processing.core.PImage;

public class MainMenu extends Menu{
    PlayScreen playScreen;
    tutorialScreen tutorialScreen;
    SettingsMenu settingsMenu;
    PImage airPlane;
    int skyBoxInt = 0;
    PImage sky;

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

        sky = p.loadImage("lowResSky.png");


        Button btnPlay = new Button(200,200,200,50,"Play",p);
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

        Button btnTourtorial = new Button(200,260,200,50,"Tourtorial",p);
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

        Button btnScoreBord = new Button(200,320,200,50,"ScoreBord",p);
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

        Button btnOptions = new Button(200,380,200,50,"Options",p);
        btnOptions.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                settingsMenu.visibale = true;

            }
        });

        btnList.add(btnOptions);

        Button btnExit = new Button(200,450,200,50,"Exit",p);
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

    }

    @Override
    void mousePushed() {

    }


}
