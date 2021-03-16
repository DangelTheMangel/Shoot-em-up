import processing.core.PApplet;
import processing.core.PVector;

public class PowerUp extends Entity {
    String name;

    BasicEnemyEntity(PApplet p, PVector position, int xSize, int ySize, String n) {
        super(p, position, xSize, ySize);
        name = n;
    }

    @Override
    void display() {
        p.ellipse(position.x,position.y,playerWidth,playerHeight);
        move();
    }

    @Override
    void move() {
        position.y += 1; //Bevæg nedad VVV
        if(p.height < position.y){ //Despawn mechanic
            position.x = p.random(p.width/4,p.width-p.width/4);
            position.y = 0;
            turn =0;
        }
    }

    @Override
    void shoot() {

    }
}