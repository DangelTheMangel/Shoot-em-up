import processing.core.PApplet;

public class MainMenu extends Menu{
    PlayScreen playScreen;
    tutorialScreen tutorialScreen;
    SettingsMenu settingsMenu;



    public MainMenu(main p, PlayScreen playScreen, SettingsMenu settingsMenu, tutorialScreen tutorialScreen) {
        super(p);
        this.playScreen = playScreen;
        this.tutorialScreen = tutorialScreen;
        this.settingsMenu = settingsMenu;



        Button btnPlay = new Button(200,200,200,50,"Play",p);
        btnPlay.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                playScreen.size = size;
                playScreen.visibale =true;
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

    }

    @Override
    void draw() {

    }

    @Override
    void mousePushed() {

    }


}
