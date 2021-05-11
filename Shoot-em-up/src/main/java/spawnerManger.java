import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.lang.reflect.Array;
import java.util.*;

public class spawnerManger {
    PApplet p;
    boolean start = true;
    float rew = 50;
    float enemyWidth = 50;
    float startTime = 0,roundHealthStart = 0, lastEnemyCount = 0, roundEnemyCount = 51;
    int wave = -1;
    boolean tutorial;
    boolean check = false;
    List<String> objects = Arrays.asList("Jesos","SlowBullets","Speed","HealthPickup","Ankh","burstMode","fastBullets");
    List<Double> chance = Arrays.asList(0.05, 0.10, 0.20,0.20,0.20,0.15,0.10);
    TreeMap<Double, String> map = new TreeMap<>();
    TreeMap<Double, PImage> picMap = new TreeMap<>();
    //https://stackoverflow.com/questions/41965243/choose-an-object-randomly-with-different-probability
    ArrayList<Entity> enemyList;
    ArrayList<PowerUp> powerUpList ;
    ArrayList<PImage> sprite = new ArrayList<>() ;
    PlayerShip player;
    PowerUp powerUp;
    int spawnRate ;
    spawnerManger(PApplet p, ArrayList<Entity> enemyList, ArrayList<PowerUp> powerUpList,PlayerShip player){
        this.p = p;
        for(int i = 0; i<7;++i){
            sprite.add(p.loadImage("Sprite/PowerUps/p"+i+".png"));
        }
        this.enemyList = enemyList;
        this.powerUpList = powerUpList;
        spawnRate = (int) p.random(2000,6000);
        this.player = player;
        double total = 0.0d;

        for (int i = 0; i < objects.size(); i++) {
            map.put(total += chance.get(i), objects.get(i));
            picMap.put(total ,sprite.get(i));
            System.out.println(total + " objekt: " + objects.get(i));
        }
    }



    void spawnEnemy(){
        if(tutorial == false) {
            if (enemyList.size() < 2) {
                player.score += 10;

                float spawnFloat;

                if (!start) {

                    //Du skal tilføje til så fjenderne for tidliger rundte også er med
                    float maksEnemyCount = p.random(50, roundEnemyCount);
                    float tid = p.frameCount - startTime;
                    float health = roundHealthStart - player.life;
                    System.out.println(tid);

                    spawnFloat = (int) (((maksEnemyCount / tid) * 100) + ((health / 100) * maksEnemyCount / 2));
                    lastEnemyCount = spawnFloat;
                    for (int i = 0; i < spawnFloat; ++i) {
                        //
                        if (Math.random() < 0.5) {
                            float timer = p.random(0, 500);
                            PVector pos = new PVector(p.random(p.width / 4, p.width - p.width / 4), i * 10);
                            enemyList.add(new BasicEnemyEntity(p, pos, (int) rew, (int) rew, timer));
                        } else if (Math.random() < 0.7) {
                            float timer = p.random(0, 500);
                            PVector pos = new PVector(p.random(p.width / 4, p.width - p.width / 4), i * 10);
                            enemyList.add(new TanEnemy(p, pos, (int) rew, (int) rew, timer));
                        } else {
                            float timer = p.random(0, 500);
                            PVector pos = new PVector(p.random(p.width / 4, p.width - p.width / 4), i * 10);
                            enemyList.add(new KamikazeEnemy(p, pos, (int) rew, (int) rew, timer));

                        }
                    }
                    roundEnemyCount += 1;
                } else {
                    spawnFloat = p.random(5, 10);
                    start = false;
                    for (int i = 0; i < spawnFloat; ++i) {


                        if (Math.random() < 0.7) {
                            float timer = p.random(0, 500);
                            PVector pos = new PVector(p.random(p.width / 4, p.width - p.width / 4), i * 10);
                            enemyList.add(new BasicEnemyEntity(p, pos, (int) rew, (int) rew, timer));
                        } else if (Math.random() < 0.7) {
                            float timer = p.random(0, 500);
                            PVector pos = new PVector(p.random(p.width / 4, p.width - p.width / 4), i * 10);
                            enemyList.add(new TanEnemy(p, pos, (int) rew, (int) rew, timer));
                        } else {
                            float timer = p.random(0, 500);
                            PVector pos = new PVector(p.random(p.width / 4, p.width - p.width / 4), i * 10);
                            enemyList.add(new KamikazeEnemy(p, pos, (int) rew, (int) rew, timer));

                        }

                    }
                }

                System.out.println("StartTime: " + startTime + "healtStart" + roundHealthStart);
                startTime = p.frameCount;
                roundHealthStart = player.life;
            }
        }
if(tutorial ==true) {
    if (check)
        if (enemyList.size() < 1) {
            wave = wave + 1;
            check = false;

        }
    if(wave ==0 ){

    }
    if (wave == 1 && enemyList.size() < 1) {
        float timer = p.random(0,500);
        for (int i = 0; i < 6; i++) {
            PVector pos = new PVector(p.random(p.width, p.width + 400), p.random(0, p.height));
            enemyList.add(new BasicEnemyEntity(p,pos, (int)rew, (int)rew, timer));
            check = true;

        }
    }
    if (wave == 2 && enemyList.size() < 1) {
        float timer = p.random(0,500);
        for (int i = 0; i < 6; i++) {
            PVector pos = new PVector(p.random(p.width, p.width + 400), p.random(0, p.height));
            enemyList.add(new TanEnemy(p,pos, (int)rew, (int)rew, timer));
            check = true;
        }
    }
    if (wave == 3 && enemyList.size() < 1) {
        float timer = p.random(0,500);
        for (int i = 0; i < 6; i++) {
            PVector pos = new PVector(p.random(p.width, p.width + 400), p.random(0, p.height));
            enemyList.add(new KamikazeEnemy(p,pos, (int)rew, (int)rew, timer));

            check = true;
        }

    }
}
    }

    void spawnPowerUp() {
        if (tutorial == false) {
            if (p.frameCount % spawnRate == 0) {


                Random generator = new Random();
                double value = generator.nextDouble();
                //System.out.println("value: " + value + " obj: " + map.ceilingEntry(value).getValue());

                PImage pic = picMap.ceilingEntry(value).getValue();
                String object = map.ceilingEntry(value).getValue();

                PVector pos = new PVector(p.random(p.width / 4, p.width - p.width / 4), -10);
                PowerUp powerUp = new PowerUp(p, pos, (int) rew, (int) rew, object);
                powerUp.pic = pic;
                powerUpList.add(powerUp);
                spawnRate = (int) p.random(2000, 6000);

            }
        }
    }

    void reSize(float s){
        rew = s * enemyWidth;
    }
}
