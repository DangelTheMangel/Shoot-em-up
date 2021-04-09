import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;


import static processing.core.PConstants.*;
import static processing.core.PConstants.LEFT;

public class PlayerShip extends Entity {

    boolean down,up,left,right = false;
    boolean ready = true;
    boolean actionPressed = false;
    boolean dead = false;
    float powerUpTimer = -1;
    boolean stopPowerUp = false;
    int score = 0;
    int life = 100;

    ArrayList<Bullet> BulletList = new ArrayList<Bullet>();

    //spam
    boolean ankhed = false;
    float bulletSpeed;
    float timer;
    //når timeren starter forfra
    float endTimer = 20;
    //man må kun ændre på slutburst hvis slutburst er det samme som startburst skyder den en bullet af gangen, jo større forskel jo flere bullets bliver der skudt af gangen.
    float startBurst =0;
    float slutBurst = 0;
    //
    PlayerShip(PApplet p, PVector position, int playerWidth, int playerWidth2) {
        super(p, position, playerWidth, playerWidth2);

    }


    void changePosition(){

        position.add(velocity);
        position.x = p.constrain(position.x,0,p.width-playerWidth);
        position.y = p.constrain(position.y,0,p.height-playerHeight);
    }


    void display(){
        timer+=1;
        if(timer >endTimer){
            timer = 0;
        }
        powerUpTimer-=1;
        if(powerUpTimer<0){
            stopPowerUp = true;
            powerUpTimer = -1;
        }
        p.println(powerUpTimer);
        if(life<=0 & ankhed){
            life=1;
            ankhed=false;
        }else if(life<=0){
            dead=true;
        }else{
            dead=false;
        }
        if (dead){

        }else {
            changePosition();
            p.rect(position.x, position.y, playerWidth, playerHeight);
            changePosition();

            for (int i = 0; i < BulletList.size(); ++i) {
                Bullet bulletClass = BulletList.get(i);
                bulletClass.draw();
                bulletClass.move();

            }

            for (int i = 0; i < BulletList.size(); ++i) {
                Bullet bulletClass = BulletList.get(i);
                bulletClass.draw();
                bulletClass.move();
            }
        }



    }

    @Override
    void move() {

    }

    void shoot(){
        if(actionPressed&& timer>=startBurst && timer<=slutBurst ){
            Bullet bulletClass = new Bullet(p,new PVector(0,-4),new PVector(position.x,position.y),10,10);
            BulletList.add(bulletClass);
        }

    }

    void controls(char key, int keyCode,  boolean pressed){
        velocity.set(0,0);
        if (key != p.CODED)
            switch(key){

                case 'f':{
                    if((pressed) && (ready)) {
                        actionPressed = true;


                    }else{
                        actionPressed = false;
                    }
                }break;

                case 's': {
                    if((pressed) &&(ready))
                        down=true;
                    else{
                        down=false;}

                }break;

                case 'w': {
                    if((pressed) &&(ready))
                        up = true;
                    else
                        up=false;

                }break;
                case 'a': {
                    if((pressed) &&(ready))
                        left=true;
                    else
                        left=false;

                }break;
                case 'd': {
                    if((pressed) &&(ready))
                        right=true;
                    else
                        right=false;

                }break;


            }
        else{
            switch (keyCode){

                case DOWN: {
                    if((pressed) &&(ready))
                        down=true;
                    else{
                        down=false;}

                }break;

                case UP: {
                    if((pressed) &&(ready))
                        up=true;
                    else{
                        up=false;}

                }break;
                case RIGHT: {
                    if((pressed) &&(ready))
                        right=true;
                    else{
                        right=false;}


                }break;
                case LEFT: {
                    if((pressed) &&(ready))
                        left=true;
                    else{
                        left=false;}


                }break;
                case 32:{
                    if((pressed) && (ready)) {
                        actionPressed = true;
                        Bullet bulletClass = new Bullet(p,new PVector(0,-4),new PVector(position.x,position.y),10,10);
                        BulletList.add(bulletClass);

                    }else{
                        actionPressed = false;
                    }
                }break;

            }


        }
        velocity.set(((right)?2:0) +((left)?-2:0),(((up)?-2:0) +((down)?2:0)));
    }

    void collisionWithBullets(ArrayList<Bullet> e){
        for(int i = 0 ; i<e.size();++i){
            Bullet b = e.get(i);
            if (collision(position.x, position.y, playerWidth, playerHeight, b.position.x, b.position.y, b.playerWidth, b.playerHeight)) {
                life--;

            }
        }
    }




}


