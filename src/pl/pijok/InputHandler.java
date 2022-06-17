package pl.pijok;

import pl.pijok.game.GameType;
import pl.pijok.menu.MenuController;
import pl.pijok.screen.ScreenController;
import pl.pijok.screen.ScreenType;

public class InputHandler {

    private static ScreenController screenController;
    private static MenuController menuController;

    public static void setup(){
        screenController = Controllers.getScreenController();
        menuController = Controllers.getMenuController();
    }

    public static void handleLeftA(){
        switch (screenController.getCurrentScreenType()){
            case MAIN_MENU -> {
                Controllers.getMenuController().selectPreviousOption();
            }
            case GAME -> {
                Controllers.getGameController().moveHands(0);
            }
        }
    }

    public static void handleLeftB(){
        switch (screenController.getCurrentScreenType()){
            case MAIN_MENU -> {
                Controllers.getMenuController().selectNextOption();
            }
            case GAME -> {
                Controllers.getGameController().moveHands(1);
            }
        }
    }

    public static void handleGameA(){
        switch (screenController.getCurrentScreenType()){
            case MAIN_MENU -> {
                switch (Controllers.getMenuController().getSelectedOption()){
                    case 0 -> {
                        Controllers.getScreenController().activate(ScreenType.DIFFICULTY);
                    }
                    case 1 -> {
                        Controllers.getScreenController().activate(ScreenType.LEADERBOARD);
                    }
                    case 2 -> {
                        GameAndWatch.getGameStage().close();
                    }
                }
            }
            case DIFFICULTY -> {
                Controllers.getScreenController().activate(ScreenType.GAME);
                Controllers.getGameController().reset(GameType.GameA);
            }
        }
    }

    public static void handleGameB(){
        switch (screenController.getCurrentScreenType()){
            case MAIN_MENU -> {
                switch (Controllers.getMenuController().getSelectedOption()){
                    case 0 -> {
                        Controllers.getScreenController().activate(ScreenType.DIFFICULTY);
                    }
                    case 1 -> {
                        Controllers.getScreenController().activate(ScreenType.LEADERBOARD);
                    }
                    case 2 -> {
                        GameAndWatch.getGameStage().close();
                    }
                }
            }
            case DIFFICULTY -> {
                Controllers.getScreenController().activate(ScreenType.GAME);
                Controllers.getGameController().reset(GameType.GameB);
            }
        }
    }

    public static void handleRightA(){
        switch (screenController.getCurrentScreenType()){
            case GAME -> {
                Controllers.getGameController().moveHands(2);
            }
        }
    }

    public static void handleRightB(){
        switch (screenController.getCurrentScreenType()){
            case GAME -> {
                Controllers.getGameController().moveHands(3);
            }
        }
    }

    public static void handleTime(){
        switch (screenController.getCurrentScreenType()){
            case LEADERBOARD -> {
                Controllers.getScreenController().activate(ScreenType.MAIN_MENU);
            }
        }
    }

}
