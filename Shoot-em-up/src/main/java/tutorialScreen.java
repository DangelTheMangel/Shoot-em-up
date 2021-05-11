import processing.core.PApplet;
import processing.data.Table;

public class tutorialScreen extends PlayScreen {
boolean shoot = false;
float timer = 0;
    tutorialScreen(PApplet p, Table scorebord) {
        super(p, scorebord);
        spawnerManger.tutorial = true;

    }


void tutorialText() {
    p.println(spawnerManger.wave);
    if (!player.moveKeyPressed) {
        p.textSize(20);
        p.text("press wasd or arrow keys to move", 400, 400);
    }
    if (!player.actionKeyPressed && player.moveKeyPressed) {
        p.text("press f to shoot", 400, 400);

    }
   if(player.attackNumber==1){
       spawnerManger.wave =0;

   }

    if(spawnerManger.wave == 0){
        p.text("this game has 3 different types of enemies",400,400);
    timer++;
    }
    if (timer>110){
        spawnerManger.wave ++;
        timer = 0;
    }
    if(spawnerManger.wave ==1){
        p.text("the most common enemy is a plane that can shoot bullets",400,400);
    }
    if(spawnerManger.wave ==2){
        p.text("The second enemy is the elusive blimbs",400,400);
    }
    if(spawnerManger.wave ==3){
        p.text("the third enemy is bombs",400,400);
    }
    if(spawnerManger.wave==4){
        player.dead = true;
        spawnerManger.wave = -1;
        spawnerManger.tutorial = false;
        
    }

}
}


