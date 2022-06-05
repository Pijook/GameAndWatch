package pl.pijok.mainPane.left;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import pl.pijok.Controllers;
import pl.pijok.screen.ScreenType;

public class LeftAClickListener implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        System.out.println("Left A");

        ScreenType currentScreenType = Controllers.getScreenController().getCurrentScreenType();

        switch (currentScreenType){
            case MAIN_MENU -> {
                Controllers.getMenuController().selectPreviousOption();
            }
        }
    }

}
