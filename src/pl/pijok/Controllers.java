package pl.pijok;

import pl.pijok.game.GameController;
import pl.pijok.leaderboard.LeaderboardController;
import pl.pijok.menu.MenuController;
import pl.pijok.screen.ScreenController;

public class Controllers {

    private static ScreenController screenController;
    private static MenuController menuController;
    private static GameController gameController;
    private static LeaderboardController leaderboardController;

    public static void load(){
        screenController = new ScreenController();
        menuController = new MenuController();
        gameController = new GameController();
        leaderboardController = new LeaderboardController();
    }

    public static ScreenController getScreenController() {
        return screenController;
    }

    public static MenuController getMenuController() {
        return menuController;
    }

    public static GameController getGameController() {
        return gameController;
    }

    public static LeaderboardController getLeaderboardController() {
        return leaderboardController;
    }
}
