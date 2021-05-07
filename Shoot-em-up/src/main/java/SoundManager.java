import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SoundManager {
    Clip bgmusic;
    Clip sfx ;
    ArrayList<File> musicFiles = new ArrayList<>();
    public ArrayList<File> sfxFiles = new ArrayList<>();
    public ArrayList<File> shootingSFXFiles = new ArrayList<>();
    public ArrayList<File> explotionSXFiles = new ArrayList<>();
    SoundManager(){
        loadMusic();
        loadSFX();
        loopMusic(musicFiles.get(0));

        //File file = new File("Shoot-em-up/Music/bm.wav");
    }
    void loadSFX(){
        try {
            File file = new File("Shoot-em-up/Sounds/SFX/btn.wav");
            sfxFiles.add(file);
            File file3 = new File("Shoot-em-up/Sounds/SFX/hurt.wav");
            sfxFiles.add(file3);
            File file2 = new File("Shoot-em-up/Sounds/SFX/hurt2.wav");
            sfxFiles.add(file2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for(int i = 1; i<7;++i){
                File file = new File("Shoot-em-up/Sounds/SFX/Shooting/s"+i+".wav");
                shootingSFXFiles.add(file);
            }
            System.out.println("done lodning sfx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for(int i = 1; i<7;++i){
                File file = new File("Shoot-em-up/Sounds/SFX/explotion/e"+i+".wav");
                explotionSXFiles.add(file);
            }
            System.out.println("done lodning sfx");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    void loadMusic(){
        try {
            File file = new File("Shoot-em-up/Sounds/Music/bm.wav");
            musicFiles.add(file);
            File file2 = new File("Shoot-em-up/Sounds/Music/beck.wav");
            musicFiles.add(file2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void loopMusic(File file){
        try {

            Scanner scanner = new Scanner(System.in);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
             bgmusic = AudioSystem.getClip();
            bgmusic.open(audioInputStream);
            bgmusic.loop(Clip.LOOP_CONTINUOUSLY);




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void playSFX(File file) {
        try {

            Scanner scanner = new Scanner(System.in);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            sfx = AudioSystem.getClip();
            sfx.open(audioInputStream);
            sfx.start();




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
