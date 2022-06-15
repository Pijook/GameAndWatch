package pl.pijok.mainPane;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pl.pijok.Assets;
import pl.pijok.InputHandler;
import pl.pijok.Settings;

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

    private BackgroundImage susBackground;
    private ImageView backgroundImage;

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
        rightVBox.setAlignment(Pos.TOP_CENTER);
        rightVBox.setMinWidth(Settings.getWidth() / 4);

        leftButtonA = new Button("Left A");
        leftButtonA.setOpacity(0);
        leftButtonA.setPadding(new Insets(25, 25, 25, 25));
        leftButtonA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleLeftA();
            }
        });

        leftButtonB = new Button("Left B");
        leftButtonB.setOpacity(0);
        leftButtonB.setPadding(new Insets(25, 25, 25, 25));
        leftButtonB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleLeftB();
            }
        });

        gameButtonA = new Button("Game A");
        gameButtonA.setOpacity(0);
        gameButtonA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleGameA();
            }
        });

        gameButtonB = new Button("Game B");
        gameButtonB.setOpacity(0);
        gameButtonB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleGameB();
            }
        });

        timeButton = new Button("Time");
        timeButton.setOpacity(0);
        timeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleTime();
            }
        });

        rightButtonA = new Button("Right A");
        rightButtonA.setOpacity(0);
        rightButtonA.setPadding(new Insets(25, 25, 25, 25));
        rightButtonA.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleRightA();
            }
        });

        rightButtonB = new Button("Right B");
        rightButtonB.setOpacity(0);
        rightButtonB.setPadding(new Insets(25, 25, 25, 25));
        rightButtonB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                InputHandler.handleRightB();
            }
        });

        gamePane = new StackPane();
        gamePane.setMaxHeight(Settings.getHeight() / 2);
        gamePane.setMaxWidth(620);
        gamePane.setMinWidth(620);
        gamePane.setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)
        ));

        susBackground = new BackgroundImage(Assets.getSusBackground(), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        backgroundImage = new ImageView(Assets.getBackgroundImage());

        addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
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
        AnchorPane rightAnchorPane = new AnchorPane();
        rightAnchorPane.setMinWidth(Settings.getWidth() / 4);

        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.setMinWidth(Settings.getWidth() / 4);

        AnchorPane.setTopAnchor(gameButtonA, 80.0);
        AnchorPane.setRightAnchor(gameButtonA, 130.0);

        AnchorPane.setTopAnchor(gameButtonB, 165.0);
        AnchorPane.setRightAnchor(gameButtonB, 130.0);

        AnchorPane.setTopAnchor(timeButton, 250.0);
        AnchorPane.setRightAnchor(timeButton, 140.0);

        AnchorPane.setTopAnchor(rightButtonA, 445.0);
        AnchorPane.setRightAnchor(rightButtonA, 120.0);

        AnchorPane.setTopAnchor(rightButtonB, 565.0);
        AnchorPane.setRightAnchor(rightButtonB, 120.0);

        AnchorPane.setTopAnchor(leftButtonA, 445.0);
        AnchorPane.setRightAnchor(leftButtonA, 130.0);

        AnchorPane.setTopAnchor(leftButtonB, 565.0);
        AnchorPane.setRightAnchor(leftButtonB, 130.0);

        rightAnchorPane.getChildren().addAll( gameButtonA, gameButtonB, timeButton, rightButtonA, rightButtonB);
        //leftVBox.getChildren().addAll(leftButtonA, leftButtonB);
        leftAnchorPane.getChildren().addAll(leftButtonA, leftButtonB);

        getChildren().add(backgroundImage);

        setLeft(leftAnchorPane);
        setRight(rightAnchorPane);
        setCenter(gamePane);

        setBackground(new Background(susBackground));
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
}
