import processing.core.PApplet;

public class HealthBar {
    float x,y,w,h,size = 1;
    float rX,rY,rW,rh;
    float textSize = 16;
    float alpha = 255;
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
    void drawHealthBar(){

        if(player.position.x  > rX - player.playerWidth &&
                player.position.x < rX + rW + player.playerWidth &&
                player.position.y > rY -player.playerHeight &&
                player.position.y < rY + rh + player.playerHeight){
            alpha = 100;

        }else {
            alpha = 255;
        }
        String healt = name +": " + player.life +"/"+100;
        String Score = "Score: " + player.score;
        String powerup = "Powerup: " +player.powerupUsed;
        int boxSize = (int) (p.textWidth(healt) + rX/25);
        int sBoxSize = (int) (p.textWidth(Score) + rX/25);

        if(boxSize> sBoxSize){
            sBoxSize = boxSize;
        }
        p.textAlign(p.LEFT);
        p.fill(200,200,200,alpha);
        p.rect(rX ,rY,rW,rh);
        p.rect(rX ,rY,boxSize,rh);
        p.rect((rX + rW)-(sBoxSize) ,rY,sBoxSize,rh);
        p.fill(0,0,0,alpha);
        p.rect(rX,rY,rW,rh/2);

        p.fill(250,0,0,alpha);
        double playerH = (double) player.life/(double) 100;
        double hSize = (double) rW* playerH;
        p.rect(rX,rY, (float) hSize,rh/2);
        p.textSize(textSize);
        p.fill(0,0,0,alpha);
        p.text(healt,rX + rX/100,rY +rh- textSize/2);
        p.text(Score,(rX + rW)-(sBoxSize)+ rX/100,rY +rh- textSize/2);
        p.text(powerup,rX+rW/2-p.textWidth(powerup)/2,rY +rh- textSize/2);





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