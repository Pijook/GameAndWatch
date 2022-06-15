package pl.pijok.game;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import pl.pijok.Assets;
import pl.pijok.Settings;

public class GamePane extends Pane {

    private Label scoreLabel;
    private Label gameTypeLabel;
    private Label missedEggsLabel;
    private ImageView rampLeftA;
    private ImageView rampLeftB;
    private ImageView rampRightA;
    private ImageView rampRightB;
    
    private ImageView crewMate;
    private ImageView hands;

    public GamePane(){
        createElements();
        createLayout();
    }

    private void createElements(){
        scoreLabel = new Label("0");
        gameTypeLabel = new Label("Game A");
        missedEggsLabel = new Label("0");

        hands = new ImageView(Assets.getHandsImage());
        crewMate = new ImageView(Assets.getCrewMateImage());

        rampLeftA = new ImageView(Assets.getRampLeftImage());
        rampLeftB = new ImageView(Assets.getRampLeftImage());
        rampRightA = new ImageView(Assets.getRampRightImage());
        rampRightB = new ImageView(Assets.getRampRightImage());

    }

    private void createLayout(){

        scoreLabel.setLayoutX(50);
        scoreLabel.setLayoutY(50);

        gameTypeLabel.setLayoutX(100);
        gameTypeLabel.setLayoutY(100);

        missedEggsLabel.setLayoutX(150);
        missedEggsLabel.setLayoutY(150);

        hands.setLayoutX(200);
        hands.setLayoutY(200);
        
        crewMate.setLayoutX(225);
        crewMate.setLayoutY(75);

        rampLeftA.setLayoutX(Settings.getWidth() / 2 - rampLeftA.getImage().getWidth());
        rampLeftA.setLayoutY(75);

        rampLeftB.setLayoutX(Settings.getWidth() / 2 - rampLeftB.getImage().getWidth());
        rampLeftB.setLayoutY(225);

        rampRightA.setLayoutX(0);
        rampRightA.setLayoutY(75);

        rampRightB.setLayoutX(0);
        rampRightB.setLayoutY(225);

        getChildren().addAll(scoreLabel, gameTypeLabel, missedEggsLabel, hands, crewMate, rampLeftA, rampLeftB, rampRightA, rampRightB);
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

    public ImageView getRampLeftA() {
        return rampLeftA;
    }

    public ImageView getRampLeftB() {
        return rampLeftB;
    }

    public ImageView getRampRightA() {
        return rampRightA;
    }

    public ImageView getHands() {
        return hands;
    }

    public ImageView getCrewMate() {
        return crewMate;
    }
}
