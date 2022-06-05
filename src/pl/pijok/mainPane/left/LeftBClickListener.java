package pl.pijok.mainPane.left;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import pl.pijok.Controllers;
import pl.pijok.screen.ScreenType;

public class LeftBClickListener implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("Left B");

        ScreenType currentScreenType = Controllers.getScreenController().getCurrentScreenType();

        switch (currentScreenType){
            case MAIN_MENU -> {
                Controllers.getMenuController().selectNextOption();
            }
        }
    }

}
