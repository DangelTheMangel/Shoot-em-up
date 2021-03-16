import processing.core.PApplet;
import processing.core.PVector;

public class BasicEnemyEntity extends Entity {
    int turn = 0;

    BasicEnemyEntity(PApplet p, PVector position, int xSize, int ySize) {
        super(p, position, xSize, ySize);
    }

    @Override
    void display() {
        p.ellipse(position.x,position.y,playerWidth,playerHeight);
        move();
    }

    @Override
    void move() {
        int sin = (int) (10*p.sin((float) (turn* 0.09)));
        turn ++;
        position.x += sin;
        position.y += 1;
        if(p.height < position.y){
            position.x = p.random(p.width/4,p.width-p.width/4);
            position.y = 0;
            turn =0;

        }
    }

    @Override
    void shoot() {

    }
}
