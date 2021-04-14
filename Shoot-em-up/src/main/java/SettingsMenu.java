import processing.core.PApplet;
import processing.core.PSurface;
import processing.core.PVector;

public class SettingsMenu extends Menu {
    int displayResolutionInt = 1;
    int lastDisplayResolutionInt = 1;
    int screenWidth, screenHeight;
    PVector[] displayResolution = {new PVector(320, 360, 0.4f), new PVector(640, 720, 0.8f), new PVector(800, 900, 1f), new PVector(960, 1080, 1.2f)};
    SettingsMenu(PApplet p) {
        super(p);
        Button btnBack = new Button(100,400,200,50,"Back",p);
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

        Button resLeftBtn = new Button(200, 200, 50, 50,"<",p);
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
                } else {
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

        Button resRightBtn = new Button(650, 200, 50, 50,">",p);
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
                    displayResolution[displayResolution.length-1].z = (p.displayWidth/2)/displayResolution[displayResolution.length-2].x;
                } else {
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


    }

    @Override
    void draw() {

        String displayInfo = p.width + " X " + p.height;
        p.text(displayInfo,
                (450 - p.textWidth(displayInfo) / 2) * size, (230) * size);
    }

    @Override
    void mousePushed() {

    }



    public static final javax.swing.JFrame getJFrame(final PSurface surface) {
        return (javax.swing.JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) surface.getNative()).getFrame();
    }
}
