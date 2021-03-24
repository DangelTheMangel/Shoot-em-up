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

        float tan = 10*p.tan((float) (turn* 0.0009));
        turn += 1;


        position.x += tan;
        position.y += 0.25;
        if(position.x > p.width){
            position.x = -10;
            turn =0;
        }
        if(p.height < position.y){
            position.x = p.random(0,p.width);
            position.y = 0;
            turn =0;

        }
    }
}
