package pl.pijok.screen;

import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenController {

    private final HashMap<ScreenType, Pane> screens;
    private Pane mainPane;
    private Pane currentScreen;
    private ScreenType currentScreenType;

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
        mainPane.getChildren().clear();
        mainPane.getChildren().add(screens.get(screenType));
        currentScreenType = screenType;
        currentScreen = screens.get(screenType);
    }

    public HashMap<ScreenType, Pane> getScreens() {
        return screens;
    }

    public Pane getMainPane() {
        return mainPane;
    }

    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    public Pane getCurrentScreen() {
        return currentScreen;
    }

    public ScreenType getCurrentScreenType() {
        return currentScreenType;
    }
}
