import javafx.scene.input.KeyCode;
import processing.core.PApplet;
import processing.core.PVector;

import java.security.Key;
import java.util.ArrayList;

public class PlayScreen {
    PApplet p;
    Boolean visibale = true;
    PlayerShip player;
    spawnerManger spawnerManger;

    ArrayList<PowerUp> powerUpList = new ArrayList<PowerUp>();
    ArrayList<Entity> enemyList = new ArrayList<Entity>();

    PlayScreen(PApplet p){
        this.p = p;
        PowerUp powerUp = new PowerUp(p,new PVector(p.width/2,0),50,50, "Jesos" );
        powerUpList.add(null);
        powerUpList.add(powerUp);
        player = new PlayerShip(p,new PVector(p.width/2,p.height/2),50,50);
        spawnerManger = new spawnerManger(p, enemyList, powerUpList,player);
        spawnerManger.spawnEnemy();

    }

    void draw(){
        p.clear();
        for(int i = 0; i<enemyList.size();++i ){
            BasicEnemyEntity enemy = (BasicEnemyEntity) enemyList.get(i);
            enemy.display();
            enemy.move();
            enemy.collisionWithPlayer(player);
            enemy.collisionWithBullets(player);
            player.collisionWithBullets(enemy.BulletList);
            if(enemy.dead){
                enemyList.remove(i);
                i = i-1;
            }

        }
        p.text("HP: " + player.life + "\nSCORE:\n" + player.score, 100,p.height-200 );
        player.display();
        player.shoot();
        spawnerManger.spawnEnemy();
        spawnerManger.spawnPowerUp();
        //powerup

        for(int i = 0; i<powerUpList.size();++i ) {

            PowerUp powerUp = powerUpList.get(i);
            if(powerUp != null) {
                powerUp.display();
                if(powerUp.collsionWithPlayer(player)){
                   powerUpList.remove(i);
                }
            }
        }
    }


    void keyPressed(char key, int keyCode ){
        player.controls(key,keyCode,true);
    }

    void keyReleased(char key, int keyCode) {
        player.controls(key,keyCode,false);
    }


}