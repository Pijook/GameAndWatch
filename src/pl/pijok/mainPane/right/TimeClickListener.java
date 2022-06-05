package pl.pijok.mainPane.right;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class TimeClickListener implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        System.out.println("Time");
    }

}
