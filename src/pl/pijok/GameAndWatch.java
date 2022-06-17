package pl.pijok;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pl.pijok.game.DifficultyPane;
import pl.pijok.game.GamePane;
import pl.pijok.leaderboard.LeaderboardPane;
import pl.pijok.mainPane.MainPane;
import pl.pijok.menu.MenuPane;
import pl.pijok.screen.ScreenType;

public class GameAndWatch extends Application {

    private static Stage gameStage;
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

        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            final KeyCombination keyComb = new KeyCodeCombination(KeyCode.Q, KeyCombination.SHIFT_DOWN, KeyCombination.CONTROL_DOWN);
            public void handle(KeyEvent ke) {
                if (keyComb.match(ke)) {
                    if(Controllers.getScreenController().getCurrentScreenType().equals(ScreenType.GAME)) {
                        if (!Controllers.getGameController().isEnded()) {
                            Controllers.getGameController().end();
                        }
                    }
                    else{
                        Controllers.getScreenController().activate(ScreenType.MAIN_MENU);
                    }
                }
            }
        });

        Controllers.getScreenController().activate(ScreenType.MAIN_MENU);

        stage.setScene(scene);
        stage.setTitle(Settings.getTitle());
        stage.show();

        gameStage = stage;
    }

    @Override
    public void stop() throws Exception {
        if(Controllers.getGameController().getGameTimer() != null && !Controllers.getGameController().getGameTimer().isInterrupted()){
            Controllers.getGameController().getGameTimer().interrupt();
        }

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

    public static Stage getGameStage() {
        return gameStage;
    }
}
