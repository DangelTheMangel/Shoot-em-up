import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class spawnerManger {
    PApplet p;
    ArrayList<Entity> enemyList;
    spawnerManger(PApplet p, ArrayList<Entity> enemyList){
        this.p = p;
        this.enemyList = enemyList;
    }

    void startGame(){
        for (int i = 0; i< 1;++i){
            PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
            enemyList.add(new BasicEnemyEntity(p,pos,50,50,p.random(0,50)));
        }
    }

    void spawnEnemy(){
       if(enemyList.size() < 2){
            for (int i = 0; i< p.random(5,20);++i){
                if(Math.random() < 0.7) {
                    PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                    enemyList.add(new BasicEnemyEntity(p,pos, 50, 50, p.random(0,50)));
                }else{
                    PVector pos =  new PVector(p.random(p.width / 4, p.width - p.width / 4),i*10);
                    enemyList.add(new TanEnemy(p,pos, 50, 50, p.random(0,50)));
                }
            }
        }
    }
}
