package pl.pijok;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameAndWatch extends Application {

    private static Group root;
    private static Scene scene;
    private static BorderPane mainPane;

    public static void main(String[] args) {

        launch();

    }

    @Override
    public void init() throws Exception {
        super.init();

        Settings.load();
        Controllers.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        scene = new Scene(root, Settings.getWidth(), Settings.getHeight());

        stage.setScene(scene);

        mainPane = new BorderPane();
        mainPane.setMinWidth(Settings.getWidth());
        mainPane.setMinHeight(Settings.getHeight());

        Button leftA = new Button("Left A");
        Button leftB = new Button("Left B");

        Button rightA = new Button("Right A");
        Button rightB = new Button("Right B");

        stage.setTitle(Settings.getTitle());
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static BorderPane getMainPane() {
        return mainPane;
    }

    public static Group getRoot() {
        return root;
    }

    public static Scene getScene() {
        return scene;
    }
}
