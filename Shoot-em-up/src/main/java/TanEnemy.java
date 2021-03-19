import processing.core.PApplet;
import processing.core.PVector;

public class TanEnemy extends BasicEnemyEntity {


    TanEnemy(PApplet p, PVector position, int xSize, int ySize, float timer) {
        super(p, position, xSize, ySize, timer);
        swing = (float) 0.09;
    }

    void move() {
       /* timer = timer +1;
        p.println(timer);
        if(timer>61){
            timer = 0;
        }*/

        int tan = (int) ( p.tan(turn* swing) );
        turn += 1;

        System.out.println(position.x);
        position.x += tan;
        position.y += 0.25;
        if(position.x < 0){
            position.x = p.random(p.width / 4, p.width - p.width / 4);
        }
        if(p.height < position.y){
            position.x = p.random(p.width/4,p.width-p.width/4);
            position.y = 0;
            turn =0;

        }
    }
}
