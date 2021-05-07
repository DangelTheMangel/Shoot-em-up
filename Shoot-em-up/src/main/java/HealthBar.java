import processing.core.PApplet;

public class HealthBar {
    float x,y,w,h,size = 1;
    float rX,rY,rW,rh;
    float textSize = 16;
    PlayerShip player;
    String name = "Health";
    PApplet p;
    HealthBar(PApplet p,float x, float y,float w,float h, PlayerShip player){
        this.p = p;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        rX = x;
        rY = y;
        rh = h;
        rW = w;
        this.player = player;
        textSize = rh/(15/4);
    }
    void tegnHealthBar(){
        String info = name +": " + player.life +"/"+100;
        p.textAlign(p.LEFT);
        p.fill(200);
        p.rect(rX ,rY,p.textWidth(info) + rX/25,rh);

        p.fill(0,0,0);
        p.rect(rX,rY,rW,rh/2);

        p.fill(250,0,0);
        double playerH = (double) player.life/(double) 100;
        double hSize = (double) rW* playerH;
        p.rect(rX,rY, (float) hSize,rh/2);
        p.textSize(textSize);
        p.fill(0);
        p.text(info,rX + rX/100,rY +rh- textSize/2);
        System.out.println("rX: " + rX + " rY: " + rY);




    }

    void reSizeHealthBar(float s){
        size = s;
        rX = x *size;
        rY = y *size ;
        rW = w *size;
        rh = h *size;
        textSize = rh/(15/4);

    }
}