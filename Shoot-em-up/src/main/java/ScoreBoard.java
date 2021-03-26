import processing.core.PApplet;

public class ScoreBoard extends Menu{
    PlayScreen playScreen;
    ScoreBoard(PApplet p) {
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
