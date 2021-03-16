import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

import static processing.core.PConstants.*;
import static processing.core.PConstants.LEFT;

public class PlayerShip extends Entity {

    boolean down,up,left,right = false;
    boolean ready = true;
    boolean actionPressed = false;
   Bullet bulletClass;
    ArrayList<Bullet> BulletList = new ArrayList<Bullet>();

    PlayerShip(PApplet p, PVector position, int playerWidth, int playerWidth2) {
        super(p, position, playerWidth, playerWidth2);

    }


    void changePosition(){

        position.add(velocity);
        position.x =p.constrain(position.x,0,p.width-playerWidth);
        position.y=  p.constrain(position.y,0,p.height-playerHeight);
    }


    void display(){
        changePosition();
        p.rect(position.x,position.y,playerWidth,playerHeight);
        changePosition();


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
                        bulletClass = new Bullet(p,new PVector(position.x,position.y),10,10);
                        BulletList.add(bulletClass);
                        bulletClass.draw();
                        bulletClass.move();
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


