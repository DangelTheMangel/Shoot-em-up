import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class spawnerManger {
    PApplet p;
    ArrayList<BasicEnemyEntity> enemyList;
    spawnerManger(PApplet p, ArrayList<BasicEnemyEntity> enemyList){
        this.p = p;
        this.enemyList = enemyList;
    }

    void startGame(){
        for (int i = 0; i< 10;++i){
            enemyList.add(new BasicEnemyEntity(p,new PVector(p.random(p.width/4,p.width-p.width/4),i*10),50,50, p.random(0,50)));
        }
    }

    void spawnEnemy(){
        if(enemyList.size() < 2){
            for (int i = 0; i< 10;++i){
                enemyList.add(new BasicEnemyEntity(p,new PVector(p.random(p.width/4,p.width-p.width/4),i*10),50,50,p.random(0,50)));
            }
        }
    }
}
