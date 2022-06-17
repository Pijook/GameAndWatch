package pl.pijok.leaderboard;

import pl.pijok.game.GameType;

import java.io.Serializable;

public record Score(String nickname, int score, int time, GameType gameType) implements Serializable {

    @Override
    public String toString() {
        return "Score{" +
                "nickname='" + nickname + '\'' +
                ", score=" + score +
                ", time=" + time +
                "} ";
    }
}
