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
    int life = 2;
    ArrayList<Bullet> BulletList = new ArrayList<Bullet>();

    //spam
    boolean ankhed = false;

    PlayerShip(PApplet p, PVector position, int playerWidth, int playerWidth2) {
        super(p, position, playerWidth, playerWidth2);

    }


    void changePosition(){

        position.add(velocity);
        position.x = p.constrain(position.x,0,p.width-playerWidth);
        position.y = p.constrain(position.y,0,p.height-playerHeight);
    }


    void display(){
        if(life<=0){
            dead=true;
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
        p.text(life,p.width-20,p.height-20);


    }

    @Override
    void move() {

    }

    void shoot(){
        if(actionPressed){

        }

    }

    void controls(char key, int keyCode,  boolean pressed){
        velocity.set(0,0);
        if (key != p.CODED)
            switch(key){

                case 'f':{
                    if((pressed) && (ready)) {
                        actionPressed = true;
                        Bullet bulletClass = new Bullet(p,new PVector(0,-4),new PVector(position.x,position.y),10,10);
                        BulletList.add(bulletClass);

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

            }


        }
        velocity.set(((right)?2:0) +((left)?-2:0),(((up)?-2:0) +((down)?2:0)));
    }





}


