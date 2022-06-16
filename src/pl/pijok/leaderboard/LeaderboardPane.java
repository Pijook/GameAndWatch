package pl.pijok.leaderboard;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LeaderboardPane extends Pane {

    private VBox vBox;
    private ListView<Score> playerScores;
    private Label titleLabel;
    private Label backLabel;

    public LeaderboardPane(){
        createElements();
        createLayout();
    }

    public void createElements(){
        vBox = new VBox();
        vBox.setMinWidth(620);

        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(10);

        playerScores = new ListView<>();
        playerScores.setMinWidth(300);
        playerScores.setPrefHeight(200);

        titleLabel = new Label("Leaderboard");
        titleLabel.setFont(new Font(48));
        titleLabel.setTextFill(Color.WHITE);

        backLabel = new Label("Press Time to return");
        backLabel.setFont(new Font(30));
        backLabel.setTextFill(Color.WHITE);

    }

    public void createLayout(){
        vBox.getChildren().addAll(titleLabel, playerScores, backLabel);

        getChildren().add(vBox);
    }

    public ListView<Score> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(ListView<Score> playerScores) {
        this.playerScores = playerScores;
    }

    public Label getBackLabel() {
        return backLabel;
    }
}
