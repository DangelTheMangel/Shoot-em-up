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
            /*

            Den er fræk og despanwer ikke.
            Dette følger at der kun skal være 1 powerup på skærmen ad gangen.
            Så hvorfor ikke bare have den ene?
            Den går bare ud af skærmen når den ikke bliver brugt.

             */
            position.x = p.random(p.width/4,p.width-p.width/4);
            position.y = 0;
           // turn =0;
        }
    }

    @Override
    void shoot() {

    }
}
