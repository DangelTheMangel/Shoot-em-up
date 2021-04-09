import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreBoard extends Menu{
    PlayScreen playScreen;
    boolean calBest = false;
    String[] score = {"...","...","...","...","...", "..."};
    ScoreBoard(PApplet p, PlayScreen playScreen) {
        super(p);
        this.playScreen = playScreen;
        visibale = false;
        Button btnBack = new Button(p.width/2,p.height-200,200,50,"Back",p);
        btnBack.addAction(new Action() {
            @Override
            public void execute() {
                visibale = false;
                main.mainMenu.visibale = true;
            }
        });

        btnList.add(btnBack);
    }


    @Override
    void draw() {
        if(calBest){
            calBestScore();
            calBest = false;
        }
        for(int i = 0; i<score.length;++i){
            System.out.println(score[i]);
        }


    }
    void calBestScore(){

        ArrayList<score> bestScores = new ArrayList<>();
        Table s = playScreen.scorebord;
        for(int i = 2; i<s.getRowCount(); ++i){

            score score = new score(s.getString(i,0),s.getInt(i,1),s.getString(i,2));
            bestScores.add(score);
        }

        bestScores = scoreBubbleSort(bestScores);
        Collections.reverse(bestScores);

        for(int i = 0; i<score.length;++i){

            if (i < bestScores.size()){
                String info = bestScores.get(i).name+ " " + bestScores.get(i).score + " " + bestScores.get(i).date;
                score[i] = info;
            }
        }



    }

    ArrayList<score> scoreBubbleSort(ArrayList<score> bestScores) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < bestScores.size() - 1; i++) {
                if ( bestScores.get(i).score> bestScores.get(i+1).score) {
                    temp = bestScores.get(i).score;
                    bestScores.get(i).score = bestScores.get(i+1).score;
                    bestScores.get(i+1).score = temp;
                    sorted = false;
                }
            }
        }

        return bestScores;
    }
    @Override
    void mousePushed() {

    }
}
