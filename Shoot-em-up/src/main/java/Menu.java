import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public abstract class Menu {
    PApplet p;
    Boolean visibale = true ;
    public float size = 1;
    //listen med alle knapperne

    ArrayList<Button> btnList = new ArrayList<>();

    Menu(PApplet p){
        this.p = p;
    }


    void addImageToAllBtn(PImage pImage){
        for(int i = 0; i<btnList.size();++i){
            btnList.get(i).addImage(pImage);
        }

    }

    void editAllBtnColor(PVector background, PVector text){
        for(int i = 0; i<btnList.size();++i){
            btnList.get(i).changeBTNColor(background);
            btnList.get(i).changeTextColor(text);
        }
    }
    void display(){
        if(visibale){
            draw();
            if(btnList != null){
                for(int i = 0; i<btnList.size();++i){
                    btnList.get(i).display();
                }
            }

        }
    }
     abstract void draw();


    void mousePressed(float mx, float my) {
        if(visibale){
            mousePushed();
            if(btnList != null){
                for(int i = 0; i<btnList.size();++i){
                    btnList.get(i).click(mx,my);
                }
            }
        }
    }

    abstract void mousePushed();


    void keyPressed(char key) {
        if(visibale){

        }
    }

    void reSizeMenu(float s){
        size = s;
        for(int i = 0; i <btnList.size();++i){
            btnList.get(i).size = s;
            btnList.get(i).reSize();
            size = s;
        }


    }
}
