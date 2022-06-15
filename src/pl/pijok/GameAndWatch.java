package pl.pijok;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pl.pijok.game.DifficultyPane;
import pl.pijok.game.GamePane;
import pl.pijok.game.GamePaneA;
import pl.pijok.game.GamePaneB;
import pl.pijok.leaderboard.LeaderboardPane;
import pl.pijok.mainPane.MainPane;
import pl.pijok.menu.MenuPane;
import pl.pijok.screen.ScreenType;

public class GameAndWatch extends Application {

    private static Scene scene;
    private static MainPane mainPane;
    private static MenuPane menuPane;
    private static DifficultyPane difficultyPane;
    private static LeaderboardPane leaderboardPane;
    private static GamePane gamePane;

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
        gamePane = new GamePane();
        leaderboardPane = new LeaderboardPane();

        Controllers.load();
        InputHandler.setup();

        Controllers.getScreenController().addScreen(ScreenType.MAIN_MENU, menuPane);
        Controllers.getScreenController().addScreen(ScreenType.DIFFICULTY, difficultyPane);
        Controllers.getScreenController().addScreen(ScreenType.GAME, gamePane);
        Controllers.getScreenController().addScreen(ScreenType.LEADERBOARD, leaderboardPane);
        Controllers.getScreenController().setMainPane(mainPane.getGamePane());
        Controllers.getLeaderboardController().load();
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
        Controllers.getLeaderboardController().save();
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

    public static GamePane getGamePane() {
        return gamePane;
    }

    public static LeaderboardPane getLeaderboardPane() {
        return leaderboardPane;
    }
}
