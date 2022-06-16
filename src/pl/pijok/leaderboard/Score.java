package pl.pijok.leaderboard;

import java.io.Serializable;

public record Score(String nickname, int score, int time) implements Serializable {

    @Override
    public String toString() {
        return nickname + " " + score;
    }
}
