import processing.core.PApplet;

public class EndScreenMenu extends ScoreBoard{
    EndScreenMenu(PApplet p, PlayScreen playScreen) {
        super(p, playScreen);
        btnList.get(0).text = "Back to Menu";

        Button btnBack = new Button(p.width/2-100,p.height/2-40,200,50,"Play again",p);
        btnBack.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                main.playScreen.visibale = true;
            }
        });



        btnList.add(btnBack);
        reSizeMenu(size);
        addImageToAllBtn(p.loadImage("btn.png"));



    }


}
