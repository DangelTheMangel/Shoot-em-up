import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Button {
    //denne variable indholder pde bibloteket
    PApplet p;
    PImage imageButton;
    //dette er variablerne for x,y postionerne samt knappens høje og brede
    float x,y,w,h,size = 1;
    float rX,rY,rW,rh;
    // denne string indholder hvad der skal stå på knappen
    String text;
    //dette er den instieret interface som indholder funktionen
    Action a;
    //dette er farvene
    PVector textColor = new PVector(0,0,0);
    PVector btnColor = new PVector(255,255,255);

    Button(float x, float y,float w,float h,String text, PApplet p){

        //her siger jeg at tingene fra construkteren er det samme som det i klassen
        this.p = p;
        rX = x;
        rY = y;
        rh = h;
        rW = w;
        this.text = text;
        reSize();
    }
    void addImage(PImage photo){
        imageButton = photo;
    }
    void addAction(Action a){
        //her overwriter jeg funktionen med den givet funktion
        this.a = a;
    }

    void  display(){

        p.textAlign(p.CENTER);
        if(imageButton != null){
            p.image(imageButton , x,y,w,h);
        }else {
            //her tegner jeg firekanten af knappen
            p.fill(btnColor.x,btnColor.y,btnColor.z);
            p.rect(x,y,w,h);

        }

        //her tegner jeg texten som står på knappen
        p.fill(textColor.x,textColor.y,textColor.z);
        p.text(text,x + w/8 +p.textWidth(text)/2,y+h/2);

    }

    //dette er så du kan ændre farverne det var ikke en del af opgaven men synes det var vigigt
    void changeTextColor(PVector a){textColor = a;}
    void changeBTNColor(PVector b){btnColor = b;}

    void click(float mx, float my){
        //her siger jeg at de private variabler mouseX og mouseY er
        // det samme som mx og my. grunden til at jeg gøre det
        // på denne måde er så jeg kunne gennembruge gammel kode da jeg går indfor genbrug
        float mouseX = mx;
        float mouseY = my;

        //her tjekker den at vis musen er indenfor firekanten og du klikker på knappen så ville den køre a.execute
        if (mouseX > x &&
                mouseX < x + w &&
                mouseY > y &&
                mouseY < y + h) {

            //her siger jeg at den skal gøre funktionen inden i action som vi oven over har omskrivet til det vi ønsker
            a.execute();

        }
    }

    void  reSize(){
        x = rX *size;
        y = rY *size ;
        w = rW *size;
        h = rh *size;

        System.out.println(this +"\nx: " + x + " y: " + y + " w: " + w + " h: " + h);
    }


}