package pl.pijok.leaderboard;

import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pl.pijok.GameAndWatch;
import pl.pijok.Settings;

public class LeaderboardPane extends Pane {

    private VBox vBox;
    private ListView<Score> playerScores;

    public LeaderboardPane(){
        createElements();
        createLayout();
    }

    public void createElements(){
        vBox = new VBox();
        vBox.setMinWidth(Settings.getWidth() / 2);

        playerScores = new ListView<>();
        playerScores.setMinWidth(Settings.getWidth() / 2);

    }

    public void createLayout(){
        vBox.getChildren().add(playerScores);

        getChildren().add(vBox);
    }

    public ListView<Score> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(ListView<Score> playerScores) {
        this.playerScores = playerScores;
    }
}
