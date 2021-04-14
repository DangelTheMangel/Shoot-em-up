import processing.core.PApplet;

public class EndScreenMenu extends ScoreBoard{
    EndScreenMenu(PApplet p, PlayScreen playScreen) {
        super(p, playScreen);
        btnList.get(0).text = "Back to\nMenu";
        Button btnBack = new Button(p.width/2-210,p.height-200,200,50,"Play again",p);
        btnBack.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                main.playScreen.visibale = true;
            }
        });

        btnList.add(btnBack);

    }


}
