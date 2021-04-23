import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Bullet extends Entity{

    PImage sprite;
    PVector speed;
    boolean dead = false;
    Bullet(PApplet p, PVector speed, PVector position, int xSize, int ySize) {
        super(p, position, xSize, ySize);
        this.speed = speed;

    }


    @Override
    void display() {

    }


    void draw() {
        if(sprite == null){
            p.rect(position.x,position.y,playerWidth,playerHeight);

        }else {
            p.image(sprite,position.x-playerWidth/2,position.y-playerHeight/2,playerWidth*2,playerHeight*2);

        }

    }


    @Override
    void move() {
    position.add(speed);
    }

    void issuePowerUp() {

    }
}
