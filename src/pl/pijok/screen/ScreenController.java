package pl.pijok.screen;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

public class ScreenController {

    private final HashMap<ScreenType, Pane> screens;
    private StackPane mainPane;

    public ScreenController(){
        screens = new HashMap<>();
    }

    public void addScreen(ScreenType screenType, Pane pane){
        screens.put(screenType, pane);
    }

    public void removeScreen(ScreenType screenType){
        screens.remove(screenType);
    }

    public void activate(ScreenType screenType){
        //mainPane.setRoot(screens.get(screenType));
        mainPane.getChildren().clear();
        mainPane.getChildren().add(screens.get(screenType));
    }

    public HashMap<ScreenType, Pane> getScreens() {
        return screens;
    }

    public StackPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(StackPane mainPane) {
        this.mainPane = mainPane;
    }
}
