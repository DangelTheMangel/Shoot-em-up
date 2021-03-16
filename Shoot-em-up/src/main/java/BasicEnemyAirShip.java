import processing.core.PApplet;
import processing.core.PVector;

public class BasicEnemyAirShip extends AirShip{
    BasicEnemyAirShip(PApplet p, PVector position, int xSize, int ySize) {
        super(p, position, xSize, ySize);
    }

    @Override
    void display() {
        p.ellipse(position.x,position.y,playerWidth,playerHeight);
        move();
    }

    @Override
    void move() {

    }

    @Override
    void shoot() {

    }
}
