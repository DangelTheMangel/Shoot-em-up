import processing.core.PApplet;

public class SettingsMenu extends Menu {


    SettingsMenu(PApplet p) {
        super(p);
        Button btnBack = new Button(p.width/2,p.height-200,200,50,"Back",p);
        btnBack.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                main.mainMenu.visibale = true;
            }
        });

        btnList.add(btnBack);

    }

    @Override
    void draw() {

    }

    @Override
    void mousePushed() {

    }
}
