package pl.pijok.mainPane;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pl.pijok.InputHandler;
import pl.pijok.Settings;
import pl.pijok.mainPane.left.LeftAClickListener;
import pl.pijok.mainPane.left.LeftBClickListener;
import pl.pijok.mainPane.right.*;

public class MainPane extends BorderPane {

    //Elements
    private VBox leftVBox;
    private VBox rightVBox;

    private Pane gamePane;

    private Button leftButtonA;
    private Button leftButtonB;

    private Button gameButtonA;
    private Button gameButtonB;
    private Button timeButton;

    private Button rightButtonA;
    private Button rightButtonB;

    //Listeners
    private LeftAClickListener leftAClickListener;
    private LeftBClickListener leftBClickListener;

    private GameAClickListener gameAClickListener;
    private GameBClickListener gameBClickListener;

    private RightAClickListener rightAClickListener;
    private RightBClickListener rightBClickListener;

    private TimeClickListener timeClickListener;

    public MainPane(){
        setMinWidth(Settings.getWidth());
        setMinHeight(Settings.getHeight());

        createElements();
        createLayout();
    }

    private void createElements(){
        leftVBox = new VBox();
        leftVBox.setAlignment(Pos.CENTER);
        leftVBox.setMinWidth(Settings.getWidth() / 4);

        rightVBox = new VBox();
        rightVBox.setAlignment(Pos.CENTER);
        rightVBox.setMinWidth(Settings.getWidth() / 4);

        leftButtonA = new Button("Left A");
        leftButtonA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleLeftA();
            }
        });

        leftButtonB = new Button("Left B");
        leftButtonB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleLeftB();
            }
        });

        gameButtonA = new Button("Game A");
        gameButtonA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleGameA();
            }
        });

        gameButtonB = new Button("Game B");
        gameButtonB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleGameB();
            }
        });

        timeButton = new Button("Time");
        timeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleTime();
            }
        });

        rightButtonA = new Button("Right A");
        rightButtonA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleRightA();
            }
        });

        rightButtonB = new Button("Right B");
        rightButtonB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleRightB();
            }
        });

        gamePane = new StackPane();
        gamePane.setMaxHeight(Settings.getHeight() / 2);
        gamePane.setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)
        ));

        addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                //if()
                /*
                R P
                F L
                u i o
                 */
                if(keyEvent.getCode() == KeyCode.R){
                    InputHandler.handleLeftA();
                }
                else if(keyEvent.getCode() == KeyCode.F){
                    InputHandler.handleLeftB();
                }
                else if(keyEvent.getCode() == KeyCode.P){
                    InputHandler.handleRightA();
                }
                else if(keyEvent.getCode() == KeyCode.L){
                    InputHandler.handleRightB();
                }
                else if(keyEvent.getCode() == KeyCode.U){
                    InputHandler.handleGameA();
                }
                else if(keyEvent.getCode() == KeyCode.I){
                    InputHandler.handleGameB();
                }
                else if(keyEvent.getCode() == KeyCode.O){
                    InputHandler.handleTime();
                }
            }
        });
    }

    private void createLayout(){
        rightVBox.getChildren().addAll(gameButtonA, gameButtonB, timeButton, rightButtonA, rightButtonB);

        leftVBox.getChildren().addAll(leftButtonA, leftButtonB);

        setLeft(leftVBox);
        setRight(rightVBox);
        setCenter(gamePane);
    }

    public VBox getLeftVBox() {
        return leftVBox;
    }

    public VBox getRightVBox() {
        return rightVBox;
    }

    public Pane getGamePane() {
        return gamePane;
    }

    public Button getLeftButtonA() {
        return leftButtonA;
    }

    public Button getLeftButtonB() {
        return leftButtonB;
    }

    public Button getGameButtonA() {
        return gameButtonA;
    }

    public Button getGameButtonB() {
        return gameButtonB;
    }

    public Button getTimeButton() {
        return timeButton;
    }

    public Button getRightButtonA() {
        return rightButtonA;
    }

    public Button getRightButtonB() {
        return rightButtonB;
    }

    public LeftAClickListener getLeftAClickListener() {
        return leftAClickListener;
    }

    public LeftBClickListener getLeftBClickListener() {
        return leftBClickListener;
    }

    public GameAClickListener getGameAClickListener() {
        return gameAClickListener;
    }

    public GameBClickListener getGameBClickListener() {
        return gameBClickListener;
    }

    public RightAClickListener getRightAClickListener() {
        return rightAClickListener;
    }

    public RightBClickListener getRightBClickListener() {
        return rightBClickListener;
    }

    public TimeClickListener getTimeClickListener() {
        return timeClickListener;
    }
}
