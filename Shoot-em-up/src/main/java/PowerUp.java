import processing.core.PApplet;
import processing.core.PVector;

public class PowerUp extends Entity {
    String name; //"name" = den powerup det er.
    boolean active;

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
            position.x = -100;
            position.y = -100;
            active = false;
           // turn =0;
        }
    }

    void issuePowerUp() {
        //yanderedev kode men det gør ikke noget
        if(this.name == "SlowBullets"){

        }
        if(this.name == "SlowMo"){
            p.frameRate = 15;
        }
        if(this.name == "HealthPickup"){

        }
        if(this.name == "Ankh"){

        }
    }
}
