package ru.boost;

public class Fighter {
    private static int SLEEP = 100;
    private static double SPEED = 10;
    private static double MIN_STEP = 0.01*SPEED;
    private static double MAX_STEP = 0.02*SPEED;
    private static double START_SCORE = 0.0;

    private String name;
    private Fighter enemy;
    private Thread thread;
    private double score;
    private EpicBattle battle;

    public Fighter(String name, EpicBattle battle) {
        this.name = name;
        this.score = getStartScore();
        this.battle = battle;
    }

    public static double getStartScore(){
        return START_SCORE;
    }

    public String getName() {
        return name;
    }

    public Thread getThread() {
        return thread;
    }

    private boolean theHit() {
        if(score<1.0 && enemy.getScore()<1.0) {
            double value = MIN_STEP+Math.random()*(MAX_STEP-MIN_STEP);
            setScore(score + value);
            if (enemy.getScore() > MAX_STEP) {
                enemy.setScore(enemy.getScore() - value);
            }
            return true;
        }
        return false;
    }

    public void setEnemy(Fighter enemy, ThreadGroup group) {
        thread = new Thread(group, () -> {
            while (theHit()) {
                battle.update();
                try {
                    Thread.sleep(SLEEP);
                } catch (InterruptedException e) {
                    //Thread.interrupted();
                    e.printStackTrace();
                }
            }
            battle.setStage(3);
            group.interrupt();
            group.stop();
        });
        Runtime.getRuntime().addShutdownHook(thread);
        this.enemy = enemy;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
