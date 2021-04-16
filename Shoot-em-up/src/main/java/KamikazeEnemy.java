import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class KamikazeEnemy extends BasicEnemyEntity{
float diffX;
float diffY;
float angle;

    KamikazeEnemy(PApplet p, PVector position, int xSize, int ySize, float timer) {
        super(p, position, xSize, ySize, timer);
        shouldBeDestoryded = true;
    }


    @Override
    void loadedImage() {
        PImage e = p.loadImage("Sprite/kamakazi.png");
        sprites = new PImage[] {e};
        spriteInt = 0;
    }

    @Override
    void move(){

    }

    @Override
    void display() {
        if(sprites == null){
            p.ellipse(position.x,position.y,playerWidth,playerHeight);
            loadedImage();
        }else {

            p.pushMatrix();
            p.translate(position.x,position.y);
            p.rotate(angle-90);
            p.image(sprites[spriteInt],-playerWidth/2,-playerHeight/2,playerWidth,playerHeight);
            p.popMatrix();




        }
    }

    @Override
    void anythingRelatedToThePlayer(PlayerShip s) {

            diffX = s.position.x -position.x;
            diffY = s.position.y - position.y;
            angle = (float) Math.atan2(diffY, diffX);
            velocity.x = (float) (4 * Math.cos(angle));
            velocity.y = (float) (4 * Math.sin(angle));
            position.add(velocity);

    }
}
