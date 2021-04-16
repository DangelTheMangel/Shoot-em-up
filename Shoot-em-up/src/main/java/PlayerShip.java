import processing.core.PApplet;
import processing.core.PImage;
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
    PImage sky;
    int skyBoxInt = 0;
    int score = 0;
    int life = 100;
    boolean moveKeyPressed,actionKeyPressed = false;
    ArrayList<Bullet> BulletList = new ArrayList<Bullet>();
    PImage[] sprite;
    int spriteInt  = 0;
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
        PImage rightSprite = p.loadImage("Sprite/RairPlane.png");
        PImage leftSprite = p.loadImage("Sprite/LairPlane.png");
        PImage nomalSprite = p.loadImage("Sprite/airPlane.png");
        PImage bullet = p.loadImage("Sprite/Bullet.png");

        sprite = new PImage[]{nomalSprite, leftSprite, rightSprite, bullet};

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
            slutBurst = 0;
            endTimer = 20;

            powerUpTimer = -1;
        }


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


            //p.rect(position.x, position.y, playerWidth, playerHeight);
            p.image(sprite[spriteInt],position.x, position.y, playerWidth, playerHeight);
            changePosition();

            for (int i = 0; i < BulletList.size(); ++i) {
                Bullet bulletClass = BulletList.get(i);
                bulletClass.draw();
                bulletClass.move();
                if(bulletClass.dead){
                    BulletList.remove(i);
                }

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
            Bullet bulletClass = new Bullet(p,new PVector(0,-4),new PVector(position.x,position.y),32,32);
            bulletClass.sprite = sprite[sprite.length-1];
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
                        actionKeyPressed = true;

                    }else{
                        actionPressed = false;
                    }
                }break;

                case 's': {
                    if((pressed) &&(ready)) {
                        down = true;
                        moveKeyPressed = true;
                    }
                    else{
                        down=false;}

                }break;

                case 'w': {
                    if((pressed) &&(ready)) {
                        moveKeyPressed = true;
                        up = true;

                    }
                    else
                        up=false;

                }break;
                case 'a': {
                    if((pressed) &&(ready)){
                        left=true;
                        moveKeyPressed = true;
                    }
                    else
                        left=false;

                }break;
                case 'd': {
                    if((pressed) &&(ready)){
                        right=true;
                        moveKeyPressed = true;
                    }
                    else
                        right=false;

                }break;


            }
        else{
            switch (keyCode){

                case DOWN: {
                    if((pressed) &&(ready)) {
                        down = true;
                        moveKeyPressed = true;
                    }
                    else{
                        down=false;}

                }break;

                case UP: {
                    if((pressed) &&(ready)) {
                        up = true;
                        moveKeyPressed = true;
                    }
                    else{
                        up=false;}

                }break;
                case RIGHT: {
                    if((pressed) &&(ready)){
                        right=true;
                        moveKeyPressed = true;
                    }
                    else{
                        right=false;}


                }break;
                case LEFT: {
                    if((pressed) &&(ready)){
                        left=true;
                        moveKeyPressed = true;
                    }
                    else{
                        left=false;}


                }break;
                case 32:{
                    if((pressed) && (ready)) {
                        actionPressed = true;
                        Bullet bulletClass = new Bullet(p,new PVector(0,-4),new PVector(position.x,position.y),10,10);
                        BulletList.add(bulletClass);
                        actionKeyPressed = true;

                    }else{
                        actionPressed = false;
                    }
                }break;

            }


        }

        if(left){
            spriteInt = 1;
        }else  if(right){
            spriteInt = 2;
        }else if(up||down){
            spriteInt = 0;
        }
        velocity.set(((right)?2:0) +((left)?-2:0),(((up)?-2:0) +((down)?2:0)));
    }

    void collisionWithBullets(ArrayList<Bullet> e){
        for(int i = 0 ; i<e.size();++i){
            Bullet b = e.get(i);
            if (collision(position.x, position.y, playerWidth, playerHeight, b.position.x, b.position.y, b.playerWidth, b.playerHeight)) {
                life--;
                dead = true;

            }
        }
    }




}


