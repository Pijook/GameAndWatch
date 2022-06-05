package pl.pijok.mainPane.right;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class RightBClickListener implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        System.out.println("Right B");
    }
}
