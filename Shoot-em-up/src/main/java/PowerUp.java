import processing.core.PApplet;
import processing.core.PVector;

public class PowerUp extends Entity {
    String name; //"name" = den powerup det er.

    PowerUp(PApplet p, PVector position, int xSize, int ySize, String n) {
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
            this = null;
        }
    }

    @Override
    void shoot() {

    }
}
