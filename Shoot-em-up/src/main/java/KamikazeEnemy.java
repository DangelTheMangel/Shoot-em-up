import processing.core.PApplet;
import processing.core.PVector;

public class KamikazeEnemy extends BasicEnemyEntity{
float diffX;
float diffY;
float angle;

    KamikazeEnemy(PApplet p, PVector position, int xSize, int ySize, float timer) {
        super(p, position, xSize, ySize, timer);
    }


    @Override
    void display() {
        p.ellipse(position.x,position.y,playerWidth,playerHeight);

    }
    @Override
    void move(){

    }

    void anythingRelatedToThePlayer(PlayerShip s){
        diffX = s.position.x -position.x;
        diffY = s.position.y - position.y;
        angle = (float) Math.atan2(diffY, diffX);
        velocity.x = (float) (1 * Math.cos(angle));
        velocity.y = (float) (1 * Math.sin(angle));
        position.add(velocity);
    }


}
