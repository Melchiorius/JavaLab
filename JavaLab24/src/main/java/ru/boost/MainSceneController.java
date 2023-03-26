package ru.boost;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainSceneController {
    //private Lock mutex = new ReentrantLock();

    EpicBattle battle;
    @FXML
    private Button startButton;
    @FXML
    private ProgressBar progressBarA;
    @FXML
    private ProgressBar progressBarB;
    @FXML
    LineChart<String, Double> lineChart;
    int N0 = 0;
    int N1 = 0;
    public void setBattle(EpicBattle battle) {
        XYChart.Series<String, Double> seriesA = new XYChart.Series<>();
        XYChart.Series<String, Double> seriesB = new XYChart.Series<>();
        seriesA.setName("Batman");
        seriesB.setName("Joker");
        lineChart.getData().addAll(seriesA,seriesB);
        this.battle = battle;
    }

    public void stopBattle(){
        battle.stopBattle();
    }

    public void setButtonText(String text){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                startButton.setText(text);
            }
        });
    }

    public void restart(){
        progressBarA.setProgress(0);
        progressBarB.setProgress(0);
        lineChart.getData().get(0).getData().clear();
        lineChart.getData().get(1).getData().clear();
        N0 = 0;
        N1 = 0;
    }
    public void updateProgress(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(progressBarA.getProgress()<1.0 && progressBarA.getProgress() != battle.getBatmanScore()){
                    double score = battle.getBatmanScore();
                    progressBarA.setProgress(score);
                    ObservableList<XYChart.Data<String, Double>> data = lineChart.getData().get(0).getData();
                    int size = data.size();
                    if(size > 50){
                        data.remove(0);
                    }
                    data.add(new XYChart.Data<>((N0++)+"", score));
                }
                if(progressBarB.getProgress()<1.0 && progressBarB.getProgress() != battle.getJokerScore()){
                    double score = battle.getJokerScore();
                    progressBarB.setProgress(score);
                    ObservableList<XYChart.Data<String, Double>> data = lineChart.getData().get(1).getData();
                    int size = data.size();
                    if(size > 50){
                        data.remove(0);
                    }
                    data.add(new XYChart.Data<>((N1++)+"", score));
                }
            }
        });
    }

    @FXML
    private void startButtonClicked() {
        if(battle != null) {
            if (battle.getStage() == 0) {

                battle.setStage(1);
            } else if (battle.getStage() == 1) {
                battle.setStage(2);
            } else if (battle.getStage() == 2) {
                battle.setStage(1);
            } else if (battle.getStage() == 3) {
                battle.setStage(0);
            }
        }
    }

}
