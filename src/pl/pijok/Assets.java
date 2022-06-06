package pl.pijok;

import javafx.scene.image.Image;

public class Assets {

    private static Image eggImage;

    public static void load(){
        eggImage = new Image("C:\\Users\\s24322\\IdeaProjects\\GameAndWatch\\assets\\img\\egg.png");
    }

    public static Image getEggImage() {
        return eggImage;
    }
}
