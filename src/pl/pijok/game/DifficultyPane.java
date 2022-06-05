package pl.pijok.game;

import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import pl.pijok.Controllers;
import pl.pijok.Settings;

public class DifficultyPane extends StackPane {

    private VBox vBox;
    private HBox hBox;
    private Label titleLabel;
    private Label aModeLabel;
    private Label bModeLabel;

    public DifficultyPane(){
        createElements();
        createLayout();
    }

    public void createElements(){
        vBox = new VBox();
        vBox.setMinWidth(Settings.getWidth() / 2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(35);

        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(25);

        titleLabel = new Label("Choose game type");
        aModeLabel = new Label("3 Ramps (Game A)");
        bModeLabel = new Label("4 Ramps (Game B)");

    }

    public void createLayout(){
        hBox.getChildren().addAll(aModeLabel, bModeLabel);

        vBox.getChildren().addAll(titleLabel, hBox);
        getChildren().add(vBox);
    }

}
