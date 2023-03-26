package ru.boost;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;

import java.text.DecimalFormat;

public class EpicBattle {
    DecimalFormat df = new DecimalFormat("#.####");
    private MainSceneController controller;

    private ThreadGroup threadGroup;
    private Fighter batman = null;
    private Fighter joker = null;
    private int stage = 0;

    public EpicBattle(MainSceneController controller){
        this.controller = controller;
    }

    public void update(){
        controller.updateProgress();
    }

    public int getStage(){
        return stage;
    }

    public double getBatmanScore() {
        if(batman == null){
            return Fighter.getStartScore();
        }
        return batman.getScore();
    }

    public double getJokerScore() {
        if(joker == null){
            return Fighter.getStartScore();
        }
        return joker.getScore();
    }

    public void stopBattle(){
        if(threadGroup != null) {
            threadGroup.stop();
        }
    }

    public void setStage(int stage){
        update();
        if(stage == 0){
            batman = null;
            joker = null;
            controller.setButtonText("Start!");
            controller.restart();
            this.stage = 0;
        }
        if(stage == 1){
            if(this.stage == 0) {
                threadGroup = new ThreadGroup("EpicFight");
                batman = new Fighter("Batman",this);//("Batman", progressBarA, progressBarB);
                joker = new Fighter("Joker",this);//("Joker", progressBarB, progressBarA);
                batman.setEnemy(joker,threadGroup);
                joker.setEnemy(batman,threadGroup);
                batman.getThread().start();
                joker.getThread().start();
            }
            else if(this.stage == 2){
                batman.getThread().resume();
                joker.getThread().resume();
            }
            controller.setButtonText("Stop!");
            this.stage = 1;
        }
        else if(stage == 2){
            batman.getThread().suspend();
            joker.getThread().suspend();
            controller.setButtonText("Resume...");
            this.stage = 2;
        }
        else if(stage == 3){
            controller.setButtonText("Restart!");
            this.stage = 3;
        }

    }


}
