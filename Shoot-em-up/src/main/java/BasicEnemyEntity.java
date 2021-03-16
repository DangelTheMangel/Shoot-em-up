import processing.core.PApplet;
import processing.core.PVector;

import java.util.Random;

public class BasicEnemyEntity extends Entity {
    int turn =(int) p.random(-10,10);
    float swing = p.random((float) 0.01,(float) 0.09);

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
        int sin = (int) (10*p.sin((float) (turn * swing)));
        turn ++;
        position.x += sin/2;
        position.y += 0.5;
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
