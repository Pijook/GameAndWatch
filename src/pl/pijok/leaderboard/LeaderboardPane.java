package pl.pijok.leaderboard;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;

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
        playerScores.setCellFactory(new Callback<ListView<Score>, ListCell<Score>>() {
            @Override
            public ListCell<Score> call(ListView<Score> scoreListView) {
                return new ScoreView();
            }
        });

        playerScores.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Score>() {
            @Override
            public void changed(ObservableValue<? extends Score> observableValue, Score score, Score t1) {
                if(t1 == null){
                    return;
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Score");
                alert.setHeaderText(t1.nickname());
                alert.setContentText("Game Type: " + t1.gameType().toString() + "\nScore: " + t1.score() + "\nTime: " + t1.time());

                alert.show();
            }
        });

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
