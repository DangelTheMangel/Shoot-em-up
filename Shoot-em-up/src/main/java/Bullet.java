import processing.core.PApplet;
import processing.core.PVector;

public class Bullet extends Entity{

    Bullet(PApplet p, PVector speed, PVector position, int xSize, int ySize) {
        super(p, position, xSize, ySize);
        this.speed = speed;

    }
    PVector speed = new PVector(0,-4);

    @Override
    void display() {

    }


    void draw() {
        p.rect(position.x,position.y,playerWidth,playerHeight);
    }


    @Override
    void move() {
    position.add(speed);
    }

    void issuePowerUp() {

    }
}
