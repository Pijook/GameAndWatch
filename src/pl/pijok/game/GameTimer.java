package pl.pijok.game;

import javafx.application.Platform;
import pl.pijok.Controllers;

public class GameTimer extends Thread {

    private int time;
    private int spawnRate;
    private int spawnTimer;

    public GameTimer(){
        spawnRate = 5;
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
                        Controllers.getGameController().spawnEgg();
                    }
                });
                spawnTimer = 0;
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
