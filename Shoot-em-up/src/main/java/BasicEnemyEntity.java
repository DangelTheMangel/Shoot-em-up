import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Random;

public class BasicEnemyEntity extends Entity {
    int turn =(int) p.random(-10,10);
    float swing = p.random((float) 0.01,(float) 0.09);
    boolean dead = false;
    float timer;
    ArrayList<Bullet> BulletList = new ArrayList<Bullet>();
    BasicEnemyEntity(PApplet p, PVector position, int xSize, int ySize, float timer) {
        super(p, position, xSize, ySize);
        this.timer = timer;


    }

    @Override
    void display() {
        p.ellipse(position.x,position.y,playerWidth,playerHeight);
        move();
    }

    @Override
    void move() {
        timer = timer +1;
        p.println(timer);
        if(timer>61){
            timer = 0;
        }
        int sin = (int) (10*p.sin((float) (turn * swing)));
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
            Bullet bulletClass = new Bullet(p, new PVector(0, 4), new PVector(position.x, position.y), 10, 10);
            BulletList.add(bulletClass);
        }
    }

    void collisionWithPlayer(PlayerShip s) {
        if (collision(s.position.x, s.position.y, s.playerWidth, s.playerHeight, position.x, position.y, playerWidth, playerHeight)) {
            s.position.x = -4000;
            s.life = s.life-1;
        }
    }
        void collisionWithBullets(ArrayList<Bullet> e){
            for(int i = 0 ; i<e.size();++i){
                Bullet b = e.get(i);
            if (collision(position.x, position.y, playerWidth, playerHeight, b.position.x, b.position.y, b.playerWidth, b.playerHeight)) {
                dead = true;

            }
            }
        }


    void shoot() {

    }
}
