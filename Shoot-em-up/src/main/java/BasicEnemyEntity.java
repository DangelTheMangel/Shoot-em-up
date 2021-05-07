import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Random;

public class BasicEnemyEntity extends Entity {
    int turn =(int) p.random(-10,10);
    float swing = p.random((float) 0.01,(float) 0.09);
    boolean dead = false;
    boolean shouldBeDestoryded = false;
    PImage[] sprites;
    int spriteInt;
    float timer;
    ArrayList<Bullet> BulletList = new ArrayList<Bullet>();
    BasicEnemyEntity(PApplet p, PVector position, int xSize, int ySize, float timer) {
        super(p, position, xSize, ySize);
        this.timer = timer;


    }

    void loadedImage(){
       PImage e = p.loadImage("Sprite/Enemy.png") ;
       PImage le = p.loadImage("Sprite/LEnemy.png") ;
       PImage re = p.loadImage("Sprite/REnemy.png") ;
       PImage bullet = p.loadImage("Sprite/EBullet.png") ;
       sprites = new PImage[]{e,le,re,bullet};

    }

    @Override
    void display() {
        if(sprites == null){
            p.ellipse(position.x,position.y,playerWidth,playerHeight);
            loadedImage();
        }else {
            p.image(sprites[spriteInt],position.x,position.y,playerWidth,playerHeight);
        }


    }

    void anythingRelatedToThePlayer(PlayerShip s){ }

    @Override
    void move() {
        timer = timer +1;

        if(timer>500){
            timer = 0;
        }
        int sin = (int) (10*p.sin((float) (turn * swing)));
        if(sin<0){
            spriteInt = 1;
        } else if(sin>0){
            spriteInt = 2;
        }
        turn ++;
        position.x += sin/2;
        position.y += 0.5;
        if(p.height < position.y){
            position.x = p.random(p.width/4,p.width-p.width/4);
            position.y = 0;
            turn =0;

        }

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
        if(timer == 60) {
            Bullet bulletClass = new Bullet(p, new PVector(0, 2), new PVector(position.x, position.y), playerWidth/5, playerWidth/5);
            bulletClass.sprite = sprites[sprites.length-1];
            BulletList.add(bulletClass);
        }
    }

    boolean collisionWithPlayer(PlayerShip s) {
        boolean col = false;
        if (collision(s.position.x, s.position.y, s.playerWidth, s.playerHeight, position.x, position.y, playerWidth, playerHeight)) {
            s.position.y += 20;
            s.life = s.life-1;
            if(shouldBeDestoryded)
            col = true;
        }
        return col;
    }


        void collisionWithBullets(PlayerShip playerShip){
            ArrayList<Bullet> e = playerShip.BulletList;
            for(int i = 0 ; i<e.size();++i){
                Bullet b = e.get(i);
            if (collision(position.x, position.y, playerWidth, playerHeight, b.position.x, b.position.y, b.playerWidth, b.playerHeight)) {
                dead = true;
                playerShip.score ++;
                b.dead = true;
            }
            }
        }


    void shoot() {

    }
}
