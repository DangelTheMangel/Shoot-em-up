import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class PowerUp extends Entity {
    String name; //"name" = den powerup det er.
    boolean active;

    float slowmotimer = 0;
    PImage pic = null;

    //en player
   // PlayerShip Pls = PlayScreen.player;

    PowerUp(PApplet p, PVector position, int xSize, int ySize, String n) {
        super(p, position, xSize, ySize);
        name = n;
    }

    @Override
    void display() {
        if(pic == null){
            p.fill(255,0,0);

            p.ellipse(position.x,position.y,playerWidth,playerHeight);
            p.fill(255);
            p.text(name,position.x - p.textWidth(name)/2,position.y);
        }else {
            p.image(pic,position.x,position.y,playerWidth,playerHeight);

        }


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


            }

        }

    boolean collsionWithPlayer(PlayerShip player){
        if(collision(position.x, position.y, playerWidth, playerHeight, player.position.x, player.position.y, player.playerWidth, player.playerHeight)){
            issuePowerUp(player);
            player.powerupUsed = name;
            main.soundManager.playSFX(main.soundManager.sfxFiles.get(3));
            return true;
        } else{
            return false;
        }
    }


    void issuePowerUp(PlayerShip player) {

        //yanderedev kode men det gør ikke noget
        if(this.name.equals("SlowBullets")){

            player.endTimer = 40;
            player.powerUpTimer=200;
        } else if(this.name.equals("Speed")){
            player.speed += 2;
            player.powerUpTimer = 2000;
        } else if(this.name.equals("HealthPickup")){
            player.life++;
            updateTimer(player);

        } else if(this.name.equals("")){
            player.ankhed = true;
        } else if(this.name.equals("Jesos")){
            player.BulletList.clear();
            player.position = new PVector(p.random(0,p.width),p.random(0,p.height));
            updateTimer(player);

        }
        else if(this.name.equals("burstMode")){
            player.slutBurst = 5;
            player.powerUpTimer = 200;
        }
        else if(this.name.equals("fastBullets")){
            player.endTimer=10;
            player.powerUpTimer  =200;


        }

    }

    void updateTimer(PlayerShip player){
        player.timer = 0;
        player.endTimer = 400;

    }
}
