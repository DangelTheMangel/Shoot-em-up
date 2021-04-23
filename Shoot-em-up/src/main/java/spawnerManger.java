import processing.core.PApplet;
import processing.core.PVector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class spawnerManger {
    PApplet p;
    boolean start = true;
    float startTime = 0,roundHealthStart = 0, lastEnemyCount = 0, roundEnemyCount = 51;
    String[] powerUpTypes = {
            "HealthPickup", "HealthPickup", "HealthPickup", "HealthPickup", "HealthPickup", "HealthPickup",
            "SlowBullets", "SlowBullets","SlowBullets",
            "SlowMo", "SlowMo","SlowMo",
            "Ankh",
            "Jesos",
            "fastBullets","fastBullets",
            "burstMode",
    };
    List<String> objects = Arrays.asList("Jesos","two","three");
    List<Double> chance = Arrays.asList(0.25, 0.25, 0.5);
    //https://stackoverflow.com/questions/41965243/choose-an-object-randomly-with-different-probability
    ArrayList<Entity> enemyList;
    ArrayList<PowerUp> powerUpList ;
    PlayerShip player;
    PowerUp powerUp;
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

                float spawnFloat;

                if(!start){

                    //Du skal tilføje til så fjenderne for tidliger rundte også er med
                    float maksEnemyCount = p.random(50,roundEnemyCount);
                    float tid = p.frameCount -startTime;
                    float health = roundHealthStart -player.life;
                    System.out.println(tid);

                    spawnFloat = (int) (((maksEnemyCount/tid)*100)+ ((health/100)*maksEnemyCount/2)) ;
                    lastEnemyCount = spawnFloat;
                    for (int i = 0; i< spawnFloat;++i){
                        //
                        if(Math.random() < 0.5) {
                            float timer = p.random(0,500);
                            PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                            enemyList.add(new BasicEnemyEntity(p,pos, 50, 50, timer));
                        }else  if(Math.random() < 0.7) {
                            float timer = p.random(0,500);
                            PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                            enemyList.add(new TanEnemy(p,pos, 50, 50, timer));
                        }else {
                            float timer = p.random(0,500);
                            PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                            enemyList.add(new KamikazeEnemy(p,pos, 50, 50, timer));

                        }
                    }
                    roundEnemyCount +=1;
                }else {
                    spawnFloat = p.random(5,10);
                    start = false;
                    for (int i = 0; i< spawnFloat;++i){



               if(Math.random() < 0.7) {
                    float timer = p.random(0,500);
                    PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                    enemyList.add(new BasicEnemyEntity(p,pos, 50, 50, timer));
                }else  if(Math.random() < 0.7) {
                    float timer = p.random(0,500);
                    PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                    enemyList.add(new TanEnemy(p,pos, 50, 50, timer));
                }else {
                    float timer = p.random(0,500);
                    PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                    enemyList.add(new KamikazeEnemy(p,pos, 50, 50, timer));

                }

                    }
                }

          System.out.println("StartTime: " + startTime + "healtStart" +roundHealthStart);
            startTime =p.frameCount;
            roundHealthStart =player.life;
        }
    }

    void spawnPowerUp(){

        if(p.frameCount% spawnRate==0){
            String s = powerUpTypes[(int) p.random(0,powerUpTypes.length)];
            PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),-10);
            PowerUp powerUp = new PowerUp(p,pos,50,50, s );
            powerUpList.add(powerUp);
            spawnRate = (int) p.random(2000,6000);
        }
    }
}
