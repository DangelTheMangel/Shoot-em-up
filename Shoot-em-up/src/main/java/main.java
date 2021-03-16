import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("main");
    }

    PlayerShip player ;

    ArrayList<Entity> enemyList = new ArrayList<Entity>();
    @Override
    public void settings() {
        size(1000,1000);
    }

    @Override
    public void setup() {
        for (int i = 0; i< 10;++i){
            enemyList.add(new BasicEnemyEntity(this,new PVector(random(width/4,width-width/4),i*10),50,50));
        }

        player = new PlayerShip(this,new PVector(width/2,height/2),50,50);


    }

    @Override
    public void draw() {
        clear();
        for(int i = 0; i<enemyList.size();++i ){
            Entity enemy = enemyList.get(i);
            enemy.display();
            enemy.move();
        }

        player.display();
        player.shoot();

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
