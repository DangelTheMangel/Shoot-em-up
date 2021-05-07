import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public abstract class Entity {
    PApplet p;
    float rw,rh;
    int playerWidth = 10;
    int playerHeight= 10;
    PVector position = new PVector();
    PVector velocity = new PVector();
    Entity(PApplet p, PVector position, int xSize, int ySize){
        this.p = p;
        this.position = position;
        rw = xSize;
        rh = ySize;
        this.playerWidth = xSize;
        this.playerHeight = ySize;
       // position.set(100,this.p.height/2);
    }


    void reSizeEntity(float s){
        playerHeight = (int) ( rh *s);
        playerWidth = (int) (rw *s);
    }
    abstract void display();


    abstract void move();

    boolean collision(float px, float py, float pw, float ph, float rx, float ry, float rw, float rh){
        if(px+pw > rx && px< rx+rw &&  py+ph> ry && py+ph <ry+rh){
            return true;
        }else{
            return false;
        }

    }
}
