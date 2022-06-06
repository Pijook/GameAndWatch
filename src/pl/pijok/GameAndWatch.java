package pl.pijok;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pl.pijok.game.DifficultyPane;
import pl.pijok.game.GamePane;
import pl.pijok.game.GamePaneA;
import pl.pijok.game.GamePaneB;
import pl.pijok.mainPane.MainPane;
import pl.pijok.menu.MenuPane;
import pl.pijok.screen.ScreenType;

public class GameAndWatch extends Application {

    private static Scene scene;
    private static MainPane mainPane;
    private static MenuPane menuPane;
    private static DifficultyPane difficultyPane;
    private static GamePaneA gamePaneA;
    private static GamePaneB gamePaneB;

    public static void main(String[] args) {

        launch();

    }

    @Override
    public void init() throws Exception {
        super.init();

        Settings.load();
        Assets.load();

        mainPane = new MainPane();
        menuPane = new MenuPane();
        difficultyPane = new DifficultyPane();
        gamePaneA = new GamePaneA();
        gamePaneB = new GamePaneB();

        Controllers.load();
        InputHandler.setup();

        Controllers.getScreenController().addScreen(ScreenType.MAIN_MENU, menuPane);
        Controllers.getScreenController().addScreen(ScreenType.DIFFICULTY, difficultyPane);
        Controllers.getScreenController().addScreen(ScreenType.GAME_A, gamePaneA);
        Controllers.getScreenController().addScreen(ScreenType.GAME_B, gamePaneB);
        Controllers.getScreenController().setMainPane(mainPane.getGamePane());
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(mainPane, Settings.getWidth(), Settings.getHeight());

        Controllers.getScreenController().activate(ScreenType.MAIN_MENU);

        stage.setScene(scene);
        stage.setTitle(Settings.getTitle());
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static BorderPane getMainPane() {
        return mainPane;
    }

    public static Scene getScene() {
        return scene;
    }

    public static MenuPane getMenuPane() {
        return menuPane;
    }

    public static DifficultyPane getDifficultyPane() {
        return difficultyPane;
    }

    public static GamePaneA getGamePaneA() {
        return gamePaneA;
    }

    public static GamePaneB getGamePaneB() {
        return gamePaneB;
    }
}
