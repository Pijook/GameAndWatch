package pl.pijok.game;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import pl.pijok.Assets;
import pl.pijok.Settings;

public abstract class GamePane extends Pane {

    private Label scoreLabel;
    private Label gameTypeLabel;
    private Label missedEggsLabel;
    private ImageView rampLeftA;
    private ImageView rampLeftB;
    private ImageView rampRightA;

    public GamePane(){
        createElements();
        createLayout();
    }

    private void createElements(){
        scoreLabel = new Label("0");
        gameTypeLabel = new Label("Game A");
        missedEggsLabel = new Label("0");

        rampLeftA = new ImageView(Assets.getRampLeftImage());
        rampLeftB = new ImageView(Assets.getRampLeftImage());
        rampRightA = new ImageView(Assets.getRampRightImage());

    }

    private void createLayout(){
        scoreLabel.setLayoutX(50);
        scoreLabel.setLayoutY(50);

        gameTypeLabel.setLayoutX(100);
        gameTypeLabel.setLayoutY(100);

        missedEggsLabel.setLayoutX(150);
        missedEggsLabel.setLayoutY(150);

        rampLeftA.setLayoutX(Settings.getWidth() / 2 - rampLeftA.getImage().getWidth());
        rampLeftA.setLayoutY(50);

        rampLeftB.setLayoutX(Settings.getWidth() / 2 - rampLeftB.getImage().getWidth());
        rampLeftB.setLayoutY(200);

        rampRightA.setLayoutX(0);
        rampRightA.setLayoutY(50);

        getChildren().addAll(scoreLabel, gameTypeLabel, missedEggsLabel, rampLeftA, rampLeftB, rampRightA);
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
