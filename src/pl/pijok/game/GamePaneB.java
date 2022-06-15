package pl.pijok.game;

import javafx.scene.image.ImageView;
import pl.pijok.Assets;
import pl.pijok.Settings;

public class GamePaneB extends GamePane {

    private ImageView rampRightB;

    public GamePaneB() {
        super();
        getGameTypeLabel().setText("Game B");

        createElements();
        createLayout();
    }

    private void createElements() {

        rampRightB = new ImageView(Assets.getRampRightImage());

    }

    private void createLayout(){

        rampRightB.setLayoutX(0);
        rampRightB.setLayoutY(225);

        getChildren().addAll(rampRightB);

    }
}
