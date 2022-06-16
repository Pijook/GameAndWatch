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
        System.out.println("Left A");
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
        System.out.println("Left B");
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
        System.out.println("Game A");
        switch (screenController.getCurrentScreenType()){
            case MAIN_MENU -> {
                switch (Controllers.getMenuController().getSelectedOption()){
                    case 0 -> {
                        System.out.println("New game");
                        Controllers.getScreenController().activate(ScreenType.DIFFICULTY);
                    }
                    case 1 -> {
                        System.out.println("Leaderboard");
                        Controllers.getScreenController().activate(ScreenType.LEADERBOARD);
                    }
                    case 2 -> {
                        System.out.println("Exit");
                        GameAndWatch.getGameStage().close();
                    }
                }
            }
            case DIFFICULTY -> {
                Controllers.getScreenController().activate(ScreenType.GAME);
                //Controllers.getGameController().setGameType(GameType.GameA);
                Controllers.getGameController().reset(GameType.GameA);
            }
        }
    }

    public static void handleGameB(){
        System.out.println("Game B");
        switch (screenController.getCurrentScreenType()){
            case MAIN_MENU -> {
                switch (Controllers.getMenuController().getSelectedOption()){
                    case 0 -> {
                        System.out.println("New game");
                        Controllers.getScreenController().activate(ScreenType.DIFFICULTY);
                    }
                    case 1 -> {
                        System.out.println("Leaderboard");
                        Controllers.getScreenController().activate(ScreenType.LEADERBOARD);
                    }
                    case 2 -> {
                        System.out.println("Exit");
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
        System.out.println("Right A");
        switch (screenController.getCurrentScreenType()){
            case GAME -> {
                Controllers.getGameController().moveHands(2);
            }
        }
    }

    public static void handleRightB(){
        System.out.println("Right B");
        switch (screenController.getCurrentScreenType()){
            case GAME -> {
                Controllers.getGameController().moveHands(3);
            }
        }
    }

    public static void handleTime(){
        System.out.println("Time");
        switch (screenController.getCurrentScreenType()){
            case GAME -> {
                //Controllers.getGameController().spawnEgg();
            }
            case LEADERBOARD -> {
                Controllers.getScreenController().activate(ScreenType.MAIN_MENU);
            }
        }
    }

}
