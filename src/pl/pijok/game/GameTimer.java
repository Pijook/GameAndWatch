package pl.pijok.game;

import javafx.application.Platform;
import pl.pijok.Controllers;
import pl.pijok.Settings;

public class GameTimer extends Thread {

    private int time;
    private int spawnRate;
    private int spawnTimer;

    public GameTimer(){
        spawnRate = Settings.getDefaultSpawnRate();
        spawnTimer = 0;
        time = 0;
    }

    @Override
    public void run() {
        super.run();

        while (!isInterrupted()){

            time++;

            spawnTimer++;

            if(spawnTimer >= spawnRate){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(spawnRate > 500){
                            spawnRate = spawnRate - Settings.getSpawnRateDecrease();
                        }
                        Controllers.getGameController().spawnEgg();
                    }
                });
                spawnTimer = 0;
            }

            if(time >= 1000){
                Controllers.getGameController().setTime(Controllers.getGameController().getTime() + 1);
                if(Controllers.getGameController().getTime() % 5 == 0){
                    Controllers.getGameController().changeCrewMateVisibility();
                }
                time = 0;
            }

            try {
                sleep(1);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSpawnRate() {
        return spawnRate;
    }

    public void setSpawnRate(int spawnRate) {
        this.spawnRate = spawnRate;
    }

    public int getSpawnTimer() {
        return spawnTimer;
    }

    public void setSpawnTimer(int spawnTimer) {
        this.spawnTimer = spawnTimer;
    }
}
