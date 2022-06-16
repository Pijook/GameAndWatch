package pl.pijok.menu;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import pl.pijok.Assets;

public class MenuPane extends StackPane {

    private VBox vBox;
    private Label titleLabel;
    private Label newGameLabel;
    private Label highscoresLabel;
    private Label exitLabel;

    public MenuPane(){
        createElements();
        createLayout();
    }

    private void createElements(){
        titleLabel = new Label("Amogus");
        //titleLabel.setFont(Assets.getMinecraftFont());
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(new Font(30));

        newGameLabel = new Label("New Game");
        newGameLabel.setTextFill(Color.WHITE);
        newGameLabel.setFont(new Font(20));

        highscoresLabel = new Label("High Scores");
        highscoresLabel.setTextFill(Color.WHITE);
        highscoresLabel.setFont(new Font(20));

        exitLabel = new Label("Exit");
        exitLabel.setTextFill(Color.WHITE);
        exitLabel.setFont(new Font(20));

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
    }

    private void createLayout(){
        vBox.getChildren().addAll(
                titleLabel,
                newGameLabel,
                highscoresLabel,
                exitLabel
        );

        getChildren().addAll(vBox);
    }

    public Label getTitleLabel() {
        return titleLabel;
    }

    public Label getNewGameLabel() {
        return newGameLabel;
    }

    public Label getHighscoresLabel() {
        return highscoresLabel;
    }

    public Label getExitLabel() {
        return exitLabel;
    }

    public VBox getvBox() {
        return vBox;
    }
}
