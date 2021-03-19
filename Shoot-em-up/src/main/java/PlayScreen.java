import javafx.scene.input.KeyCode;
import processing.core.PApplet;
import processing.core.PVector;

import java.security.Key;
import java.util.ArrayList;

public class PlayScreen {
    PApplet p;
    PlayerShip player ;
    spawnerManger spawnerManger;

    ArrayList<BasicEnemyEntity> enemyList = new ArrayList<BasicEnemyEntity>();

    PlayScreen(PApplet p){
        this.p = p;
        player = new PlayerShip(p,new PVector(p.width/2,p.height/2),50,50);
        spawnerManger = new spawnerManger(p, enemyList);
        spawnerManger.startGame();

    }

    void draw(){
        p.clear();
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

    void keyPressed(char key, int keyCode ){
        player.controls(key,keyCode,true);
    }

    void keyReleased(char key, int keyCode) {
        player.controls(key,keyCode,false);
    }
}
