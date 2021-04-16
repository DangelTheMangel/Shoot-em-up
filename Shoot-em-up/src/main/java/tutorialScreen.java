import processing.core.PApplet;
import processing.data.Table;

public class tutorialScreen extends PlayScreen {


    tutorialScreen(PApplet p, Table scorebord) {
        super(p, scorebord);
    }

void tutorialText() {
    if (!player.moveKeyPressed) {
        p.textSize(20);
        p.text("press wasd or arrow keys to move", 400, 400);
    }
    if (!player.actionKeyPressed && player.moveKeyPressed) {
        p.text("press f to shoot", 400, 400);
    }

}
}


