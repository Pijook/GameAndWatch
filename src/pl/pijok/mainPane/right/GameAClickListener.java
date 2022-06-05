package pl.pijok.mainPane.right;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import pl.pijok.Controllers;
import pl.pijok.screen.ScreenType;

public class GameAClickListener implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        System.out.println("Game A");

        ScreenType currentScreenType = Controllers.getScreenController().getCurrentScreenType();

        switch (currentScreenType){
            case MAIN_MENU -> {
                switch (Controllers.getMenuController().getSelectedOption()){
                    case 0 -> {
                        System.out.println("New game");
                    }
                    case 1 -> {
                        System.out.println("Leaderboard");
                    }
                    case 2 -> {
                        System.out.println("Exit");
                    }
                }
            }
        }
    }

}
