import processing.core.PApplet;
import processing.core.PVector;

public class PowerUp extends Entity {
    String name; //"name" = den powerup det er.
    boolean active;

    float slowmotimer = 0;
    float bulletTimer = 0;

    //en player
   // PlayerShip Pls = PlayScreen.player;

    PowerUp(PApplet p, PVector position, int xSize, int ySize, String n) {
        super(p, position, xSize, ySize);
        name = n;
    }

    @Override
    void display() {
        p.fill(255,0,0);

        p.ellipse(position.x,position.y,playerWidth,playerHeight);
        p.fill(255);
        p.text(name,position.x - p.textWidth(name)/2,position.y);

        move();
    }

    @Override
    void move() {
        position.y += 1; //Bevæg nedad
        if(p.height < position.y){


            position.y = -1000;
            active = false;
           // turn =0;

            //slowmo ting
            if(slowmotimer<0){
                p.frameRate=30;
            }else{
                slowmotimer-=1;
            }

            //bullet ting
            if(bulletTimer<0){
              //  Pls.bulletSpeed = -4;
            }else{
                bulletTimer-=1;
            }
        }
    }
    boolean collsionWithPlayer(PlayerShip player){
        if(collision(position.x, position.y, playerWidth, playerHeight, player.position.x, player.position.y, player.playerWidth, player.playerHeight)){
            issuePowerUp(player);
            return true;
        } else{
            return false;
        }
    }
    void issuePowerUp(PlayerShip player) {
        //yanderedev kode men det gør ikke noget
        if(this.name.equals("SlowBullets")){
            player.endTimer = 40;
            bulletTimer=300;
        } else if(this.name.equals("SlowMo")){
            p.frameRate = 15;
            slowmotimer=75; //Det her svarer til 5 sek slowmo.
        } else if(this.name.equals("HealthPickup")){
            player.life++;
        } else if(this.name.equals("Ankh")){
            player.ankhed = true;
        } else if(this.name.equals("Jesos")){
            player.BulletList.clear();
            player.position.y -= p.height;
        }
        else if(this.name.equals("burstMode")){
            player.slutBurst = 5;
        }
        else if(this.name.equals("fastBullets")){
            player.endTimer=10;
        }

    }
}
