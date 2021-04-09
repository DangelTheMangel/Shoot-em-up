import processing.core.PApplet;
import processing.core.PVector;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class spawnerManger {
    PApplet p;
    String[] powerUpTypes = {
            "HealthPickup", "HealthPickup", "HealthPickup", "HealthPickup", "HealthPickup", "HealthPickup",
            "SlowBullets", "SlowBullets","SlowBullets",
            "SlowMo", "SlowMo","SlowMo",
            "Ankh",
            "Jesos"
    };

    ArrayList<Entity> enemyList;
    ArrayList<PowerUp> powerUpList ;
    PlayerShip player;
    PowerUp powerUp ;
    int spawnRate ;
    spawnerManger(PApplet p, ArrayList<Entity> enemyList, ArrayList<PowerUp> powerUpList,PlayerShip player){
        this.p = p;
        this.enemyList = enemyList;
        this.powerUpList = powerUpList;
        spawnRate = (int) p.random(2000,6000);
        this.player = player;
    }



    void spawnEnemy(){
      if(enemyList.size() < 2){
                player.score += 10;
            for (int i = 0; i< p.random(5,50);++i){

                if(Math.random() < 0.7) {
                    float timer = p.random(0,500);
                    PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                    enemyList.add(new BasicEnemyEntity(p,pos, 50, 50, timer));
                }else{
                    float timer = p.random(0,500);
                    PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                    enemyList.add(new TanEnemy(p,pos, 50, 50, timer));
                }
            }
        }
    }

    void spawnPowerUp(){
        //System.out.println("\n spawnrate " + (p.frameCount% spawnRate));
        if(p.frameCount% spawnRate==0){
            String s = powerUpTypes[(int) p.random(0,powerUpTypes.length)];
            PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),-10);
            PowerUp powerUp = new PowerUp(p,pos,50,50, s );
            powerUpList.add(powerUp);
            spawnRate = (int) p.random(2000,6000);
        }
    }
}
