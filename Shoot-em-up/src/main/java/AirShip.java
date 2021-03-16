import processing.core.PApplet;
import processing.core.PVector;

public abstract class AirShip {
    PApplet p;

    int playerWidth = 10;
    int playerHeight= 10;
    PVector position = new PVector();
    PVector velocity = new PVector();
    AirShip(PApplet p,PVector position,int xSize, int ySize){
        this.p = p;
        this.position = position;
        this.playerWidth = xSize;
        this.playerHeight = ySize;
       // position.set(100,this.p.height/2);
    }



    abstract void display();
    abstract void move();
    abstract void shoot();

    boolean collision(float px, float py, float pw, float ph, float rx, float ry, float rw, float rh){
        if(px+pw > rx && px< rx+rw &&  py+ph> ry && py+ph <ry+rh){
            return true;
        }else{
            return false;
        }

    }
}
