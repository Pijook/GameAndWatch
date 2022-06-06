package pl.pijok.game;

import java.util.Random;

public class GameController {

    private int score;
    private int missedEggs;
    private int time;
    private boolean minnieShowed;
    private GameType gameType;

    public GameController(){
        reset();
    }

    public void reset(){
        score = 0;
        missedEggs = 0;
        time = 0;
        minnieShowed = false;
        gameType = GameType.GameA;
    }

    public void spawnEgg(){
        int range;
        if(gameType == GameType.GameA){
            range = 3;
        }
        else{
            range = 4;
        }

        int rampNumber = new Random().nextInt(range);


    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMissedEggs() {
        return missedEggs;
    }

    public void setMissedEggs(int missedEggs) {
        this.missedEggs = missedEggs;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isMinnieShowed() {
        return minnieShowed;
    }

    public void setMinnieShowed(boolean minnieShowed) {
        this.minnieShowed = minnieShowed;
    }
}
