package pl.pijok.game;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import pl.pijok.Assets;

public abstract class GamePane extends Pane {

    private Label scoreLabel;
    private Label gameTypeLabel;
    private Label missedEggsLabel;
    private ImageView eggImage;

    public GamePane(){
        createElements();
        createLayout();
    }

    private void createElements(){
        scoreLabel = new Label("0");
        gameTypeLabel = new Label("Game A");
        missedEggsLabel = new Label("0");
        eggImage = new ImageView(Assets.getEggImage());

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(100), eggImage);
        //rotateTransition.setDelay(Duration.ZERO);
        rotateTransition.setByAngle(360000);
        //rotateTransition.setByAngle(Animation.INDEFINITE);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.play();

    }

    private void createLayout(){
        scoreLabel.setLayoutX(50);
        scoreLabel.setLayoutY(50);

        gameTypeLabel.setLayoutX(100);
        gameTypeLabel.setLayoutY(100);

        missedEggsLabel.setLayoutX(150);
        missedEggsLabel.setLayoutY(150);

        eggImage.setLayoutX(200);
        eggImage.setLayoutY(200);

        getChildren().addAll(scoreLabel, gameTypeLabel, missedEggsLabel, eggImage);
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
