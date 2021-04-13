import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.scene.input.KeyCode;
import processing.core.PApplet;
import processing.core.PVector;
import processing.data.Table;
import sun.util.resources.LocaleData;

import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class PlayScreen {
    PApplet p;
    boolean newGame = false;
    Table scorebord;
    Boolean visibale = false;
    PlayerShip player;
    spawnerManger spawnerManger;

    ArrayList<PowerUp> powerUpList = new ArrayList<PowerUp>();
    ArrayList<Entity> enemyList = new ArrayList<Entity>();

    PlayScreen(PApplet p,Table scorebord){
        this.p = p;
        this.scorebord = scorebord;




        //p.saveTable(scorebord,"Shoot-em-up/src/main/java/resources/scorebord.csv");

        PowerUp powerUp = new PowerUp(p,new PVector(p.width/2,0),50,50, "Jesos" );
        powerUpList.add(null);
        powerUpList.add(powerUp);
        player = new PlayerShip(p,new PVector(p.width/2,p.height/2),50,50);
        spawnerManger = new spawnerManger(p, enemyList, powerUpList,player);
        spawnerManger.spawnEnemy();

    }

    void saveScooreBord() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        String name = "AlbertGaming";
        String score = String.valueOf(player.score);

        int rowC = scorebord.getRowCount();
        scorebord.setString(rowC,0,name);
        scorebord.setString(rowC,1,score);
        scorebord.setString(rowC,2,date);

        boolean success = p.saveTable(scorebord,"/src/main/java/resources/scorebord.csv");
        System.out.println("done: " + success);
    }

    void newGame() {
        visibale = false;

        powerUpList.clear();
        enemyList.clear();
        PowerUp powerUp = new PowerUp(p,new PVector(p.width/2,0),50,50, "burstMode" );
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