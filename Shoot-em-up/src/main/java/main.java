import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("main");
    }

    PlayerShip player ;
    spawnerManger spawnerManger;

    ArrayList<BasicEnemyEntity> enemyList = new ArrayList<BasicEnemyEntity>();
    @Override
    public void settings() {
        size(1000,1000);
    }

    @Override
    public void setup() {


        player = new PlayerShip(this,new PVector(width/2,height/2),50,50);
        spawnerManger = new spawnerManger(this, enemyList);
        spawnerManger.startGame();
    }

    @Override
    public void draw() {
        clear();
        for(int i = 0; i<enemyList.size();++i ){
            BasicEnemyEntity enemy = enemyList.get(i);
            enemy.display();
            enemy.move();
            enemy.collisionWithPlayer(player);
            enemy.collisionWithBullets(player.BulletList);
            if(enemy.dead){
                enemyList.remove(i);
                i = i-1;
            }

        }

        player.display();
        player.shoot();
        spawnerManger.spawnEnemy();
    }

    @Override
    public void keyPressed() {
        player.controls(key,keyCode,true);
    }

    @Override
    public void keyReleased() {
        player.controls(key,keyCode,false);
    }






}
