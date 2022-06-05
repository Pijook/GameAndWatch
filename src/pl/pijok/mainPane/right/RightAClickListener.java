package pl.pijok.mainPane.right;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class RightAClickListener implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        System.out.println("Right A");
    }
}
