import processing.core.PApplet;

public class MainMenu extends Menu{
    PlayScreen playScreen;
    MainMenu(PApplet p,PlayScreen playScreen) {
        super(p);
        this.playScreen = playScreen;
        visibale = false;
        Button btnPlay = new Button(200,200,200,50,"Play",p);
        btnPlay.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                playScreen.visibale =true;
            }
        });

        btnList.add(btnPlay);
    }

    @Override
    void draw() {

    }

    @Override
    void mousePushed() {

    }


}
