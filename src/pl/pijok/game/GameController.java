package pl.pijok.game;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;
import pl.pijok.Assets;
import pl.pijok.Controllers;
import pl.pijok.GameAndWatch;
import pl.pijok.screen.ScreenType;

import java.util.Random;

public class GameController {

    private SimpleIntegerProperty score;
    private SimpleIntegerProperty missedEggs;
    private int time;
    private boolean minnieShowed;
    private GameType gameType;

    private Point[] eggSpawnPoints;
    private Point[] handsPoints;

    private GameTimer gameTimer;

    private int currentHandsPoint;
    private boolean animationLocked;

    private boolean ended;

    public GameController(){
        score = new SimpleIntegerProperty();
        missedEggs = new SimpleIntegerProperty();
        gameTimer = null;

        GamePane gamePane = GameAndWatch.getGamePane();
        gamePane.getScoreLabel().textProperty().bind(score.asString());
        gamePane.getMissedEggsLabel().textProperty().bind(missedEggs.asString());

        eggSpawnPoints = new Point[]{
                new Point(14, 48),
                new Point(14, 198),
                new Point(627, 48),
                new Point(627, 198)
        };

        handsPoints = new Point[]{
                new Point(-25, -55),
                new Point(-25, 95),
                new Point(250, -55),
                new Point(250, 95)
        };

        animationLocked = false;
        ended = false;
    }

    public void reset(GameType type){
        score.set(0);
        missedEggs.set(0);
        time = 0;
        minnieShowed = false;
        gameType = type;
        currentHandsPoint = 0;
        animationLocked = false;

        gameTimer = new GameTimer();
        gameTimer.start();
        ended = false;
    }

    public void end(){
        ended = true;
        gameTimer.interrupt();

        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Game Over");
        textInputDialog.setHeaderText("Game Over");
        textInputDialog.setContentText("Enter your nickname");

        textInputDialog.show();

        textInputDialog.setOnCloseRequest(new EventHandler<DialogEvent>() {
            @Override
            public void handle(DialogEvent dialogEvent) {
               Controllers.getLeaderboardController().addScore(textInputDialog.getResult(), score.get(), time, gameType);
               Controllers.getScreenController().activate(ScreenType.LEADERBOARD);
            }
        });

    }

    public void moveHands(int pointIndex){
        if(animationLocked){
            return;
        }

        if(pointIndex == 0 || pointIndex == 1){
            GameAndWatch.getGamePane().getCrewMate().setImage(Assets.getCrewMateFlippedImage());
        }
        else{
            GameAndWatch.getGamePane().getCrewMate().setImage(Assets.getCrewMateImage());
        }

        System.out.println("Trying to move hands");
        GamePane gamePane = (GamePane) Controllers.getScreenController().getScreens().get(ScreenType.GAME);

        Point currentPoint = handsPoints[currentHandsPoint];
        Point newPoint = handsPoints[pointIndex];

        Path path = new Path();
        path.getElements().add(new MoveTo(currentPoint.getX(), currentPoint.getY()));
        path.getElements().add(new LineTo(newPoint.getX(), newPoint.getY()));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(gamePane.getHands());
        pathTransition.setPath(path);
        pathTransition.setDuration(Duration.millis(500));

        animationLocked = true;
        pathTransition.play();

        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currentHandsPoint = pointIndex;
                animationLocked = false;
            }
        });
    }

    public void spawnEgg(){
        int range;
        if(gameType == GameType.GameA){
            range = 3;
        }
        else{
            range = 4;
        }

        System.out.println(range);

        int rampNumber = new Random().nextInt(range);
        Point startingPoint = eggSpawnPoints[rampNumber];

        ImageView egg = new ImageView(Assets.getShyCrewMateImage());
        Controllers.getScreenController().getCurrentScreen().getChildren().add(egg);

        Path path = new Path();
        path.getElements().add(new MoveTo(startingPoint.getX(), startingPoint.getY()));

        if(rampNumber <= 1){
            path.getElements().add(new LineTo(startingPoint.getX() + Assets.getRampLeftImage().getWidth(), startingPoint.getY() + Assets.getRampLeftImage().getHeight()));
        }
        else{
            path.getElements().add(new LineTo(startingPoint.getX() - Assets.getRampLeftImage().getWidth(), startingPoint.getY() + Assets.getRampLeftImage().getHeight()));
        }


        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(3));
        rotateTransition.setNode(egg);

        if(rampNumber <= 1){
            rotateTransition.setByAngle(720);
        }
        else{
            rotateTransition.setByAngle(-720);
        }


        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(path);
        pathTransition.setNode(egg);
        pathTransition.setDuration(Duration.seconds(3));

        pathTransition.play();
        rotateTransition.play();

        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(rampNumber == currentHandsPoint){
                    score.set(score.get() + 100);
                    Controllers.getScreenController().getCurrentScreen().getChildren().remove(egg);
                }
                else{

                    Path deathPath = new Path();
                    if(rampNumber <= 1){
                        deathPath.getElements().add(
                                new MoveTo(
                                        startingPoint.getX() + Assets.getRampLeftImage().getWidth(),
                                        startingPoint.getY() + Assets.getRampLeftImage().getHeight()));

                        deathPath.getElements().add(
                                new QuadCurveTo(
                                        startingPoint.getX() + Assets.getRampLeftImage().getWidth() + 50,
                                        startingPoint.getY() + Assets.getRampLeftImage().getHeight() + 50,
                                        startingPoint.getX() + Assets.getRampLeftImage().getWidth() + 100,
                                        startingPoint.getY() + Assets.getRampLeftImage().getHeight() + 50));
                    }
                    else{
                        deathPath.getElements().add(
                                new MoveTo(
                                        startingPoint.getX() - Assets.getRampLeftImage().getWidth(),
                                        startingPoint.getY() + Assets.getRampLeftImage().getHeight()));

                        deathPath.getElements().add(
                                new QuadCurveTo(
                                        startingPoint.getX() - Assets.getRampLeftImage().getWidth() - 50,
                                        startingPoint.getY() + Assets.getRampLeftImage().getHeight() + 50,
                                        startingPoint.getX() - Assets.getRampLeftImage().getWidth() - 100,
                                        startingPoint.getY() + Assets.getRampLeftImage().getHeight() + 50));
                    }


                    PathTransition deathTransition = new PathTransition();
                    deathTransition.setNode(egg);
                    deathTransition.setPath(deathPath);
                    deathTransition.setDuration(Duration.seconds(3));

                    RotateTransition deathRotate = new RotateTransition();
                    deathRotate.setNode(egg);
                    if(rampNumber <= 1){
                        deathRotate.setByAngle(720);
                    }
                    else{
                        deathRotate.setByAngle(-720);
                    }

                    deathRotate.setDuration(Duration.seconds(3));

                    FadeTransition fadeTransition = new FadeTransition();
                    fadeTransition.setNode(egg);
                    fadeTransition.setFromValue(100);
                    fadeTransition.setToValue(0);
                    fadeTransition.setDuration(Duration.seconds(3.1));

                    fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Controllers.getScreenController().getCurrentScreen().getChildren().remove(egg);
                            missedEggs.set(missedEggs.get() + 1);

                            if(missedEggs.get() >= 3){
                                if(!ended){
                                    end();
                                }
                            }
                        }
                    });

                    deathTransition.play();
                    fadeTransition.play();
                    deathRotate.play();

                }
            }
        });

    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
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

    public Point[] getEggSpawnPoints() {
        return eggSpawnPoints;
    }

    public void setEggSpawnPoints(Point[] eggSpawnPoints) {
        this.eggSpawnPoints = eggSpawnPoints;
    }

    public Point[] getHandsPoints() {
        return handsPoints;
    }

    public void setHandsPoints(Point[] handsPoints) {
        this.handsPoints = handsPoints;
    }

    public int getCurrentHandsPoint() {
        return currentHandsPoint;
    }

    public void setCurrentHandsPoint(int currentHandsPoint) {
        this.currentHandsPoint = currentHandsPoint;
    }

    public GameTimer getGameTimer() {
        return gameTimer;
    }
}


