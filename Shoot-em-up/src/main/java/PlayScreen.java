import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import processing.data.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PlayScreen {
    PApplet p;
    float size = 1;
    boolean newGame = false;
    Table scorebord;
    PImage sky;
    int skyBoxInt = 0;
    Boolean visibale = false;
    PlayerShip player;
    spawnerManger spawnerManger;
    HealthBar healthBar ;


    public ArrayList<PImage> sprites = new ArrayList<>();

    ArrayList<PowerUp> powerUpList = new ArrayList<PowerUp>();
    ArrayList<Entity> enemyList = new ArrayList<Entity>();

    PlayScreen(PApplet p, Table scorebord) {
        this.p = p;
        this.scorebord = scorebord;
        sky = p.loadImage("lowResSky.png");
        //p.saveTable(scorebord,"Shoot-em-up/src/main/java/resources/scorebord.csv");


        powerUpList.add(null);

        player = new PlayerShip(p, new PVector(p.width / 2, p.height / 2), 50, 50);
        spawnerManger = new spawnerManger(p, enemyList, powerUpList, player);
        spawnerManger.spawnEnemy();

        spawnerManger.spawnPowerUp();
        healthBar = new HealthBar(p,p.width/2 -200, 25, 400 , 40,player);

    }

    void backGround() {
       // int c1 = p.color(255, 170, 0);
        //int c2 = p.color(0, 183, 255);
       // setGradient(0, 0, p.width, p.height, c1, c2);
        p.background(3, 211, 252);

        p.image(sky, 0, skyBoxInt, p.width, p.height * 2);
        p.image(sky, 0, -p.height * 2 + skyBoxInt, p.width, p.height * 2);
        skyBoxInt += 2;

        if (skyBoxInt > p.height*2 ) {
            skyBoxInt = 0;
        }
    }


    void saveScooreBord() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        String name = main.mainMenu.settingsMenu.username;
        String score = String.valueOf(player.score);

        int rowC = scorebord.getRowCount();
        scorebord.setString(rowC, 0, name);
        scorebord.setString(rowC, 1, score);
        scorebord.setString(rowC, 2, date);
        System.out.println(scorebord.getString(rowC, 0) +"-"+scorebord.getString(rowC, 1));
        /*
        /src/main/java/resources/scorebord.csv
        */

        boolean success = p.saveTable(scorebord, "Shoot-em-up/Score/scorebord.csv");

        System.out.println("done: " + success + " wait 10 sec");
    }

    void newGame() {
        visibale = false;

        powerUpList.clear();
        enemyList.clear();
        PowerUp powerUp = new PowerUp(p, new PVector(p.width / 2, 0), 50, 50, "burstMode");
        powerUpList.add(null);
        powerUpList.add(powerUp);
        player = new PlayerShip(p, new PVector(p.width / 2, p.height / 2), 50, 50);
        spawnerManger = new spawnerManger(p, enemyList, powerUpList, player);
        spawnerManger.spawnEnemy();
        healthBar.player = player;
    }

    void draw() {
        p.clear();
        backGround();


        for (int i = 0; i < enemyList.size(); ++i) {
            BasicEnemyEntity enemy = (BasicEnemyEntity) enemyList.get(i);
            enemy.display();
            enemy.move();
            enemy.anythingRelatedToThePlayer(player);
            if(enemy.collisionWithPlayer(player)){
                enemyList.remove(i);
                i--;
            }
            enemy.collisionWithBullets(player);

            player.collisionWithBullets(enemy.BulletList);
            if (enemy.dead) {
                enemyList.remove(i);
                i = i - 1;
            }

        }

        player.display();
        player.shoot();
        spawnerManger.spawnEnemy();
        spawnerManger.spawnPowerUp();
        //powerup

        for (int i = 0; i < powerUpList.size(); ++i) {

            PowerUp powerUp = powerUpList.get(i);
            if (powerUp != null) {
                powerUp.display();
                if (powerUp.collsionWithPlayer(player)) {
                    powerUpList.remove(i);
                }
            }
        }

        healthBar.drawHealthBar();
    }

    void reSizeGame(float s){
        size = s;
        healthBar.reSizeHealthBar(s);
        player.reSizeEntity(s);
        spawnerManger.reSize(s);
        for(int i = 0 ; i<spawnerManger.enemyList.size();++i){
            spawnerManger.enemyList.get(i).reSizeEntity(s);
        }
    }

    void keyPressed(char key, int keyCode) {
        player.controls(key, keyCode, true);
    }

    void keyReleased(char key, int keyCode) {
        player.controls(key, keyCode, false);
    }


}