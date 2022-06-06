package pl.pijok.game;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public abstract class GamePane extends Pane {

    private Label scoreLabel;
    private Label gameTypeLabel;
    private Label missedEggsLabel;

    public GamePane(){
        createElements();
        createLayout();
    }

    private void createElements(){
        scoreLabel = new Label("0");
        gameTypeLabel = new Label("Game A");
        missedEggsLabel = new Label("0");
    }

    private void createLayout(){
        scoreLabel.setLayoutX(50);
        scoreLabel.setLayoutY(50);

        gameTypeLabel.setLayoutX(100);
        gameTypeLabel.setLayoutY(100);

        missedEggsLabel.setLayoutX(150);
        missedEggsLabel.setLayoutY(150);

        getChildren().addAll(scoreLabel, gameTypeLabel, missedEggsLabel);
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public Label getGameTypeLabel() {
        return gameTypeLabel;
    }

    public void setGameTypeLabel(Label gameTypeLabel) {
        this.gameTypeLabel = gameTypeLabel;
    }

    public Label getMissedEggsLabel() {
        return missedEggsLabel;
    }

    public void setMissedEggsLabel(Label missedEggsLabel) {
        this.missedEggsLabel = missedEggsLabel;
    }
}
