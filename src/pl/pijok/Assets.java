package pl.pijok;

import javafx.scene.image.Image;

import java.io.File;

public class Assets {

    private static Image eggImage;
    private static Image rampLeftImage;
    private static Image rampRightImage;

    public static void load(){
        eggImage = new Image("C:\\Users\\s24322\\IdeaProjects\\GameAndWatch\\assets\\img\\egg.png");
        rampLeftImage = new Image("C:\\Users\\s24322\\IdeaProjects\\GameAndWatch\\assets\\img\\rampLeft.png");
        rampRightImage = new Image("C:\\Users\\s24322\\IdeaProjects\\GameAndWatch\\assets\\img\\rampRight.png");
    }

    public static Image getEggImage() {
        return eggImage;
    }

    public static Image getRampLeftImage() {
        return rampLeftImage;
    }

    public static Image getRampRightImage() {
        return rampRightImage;
    }
}
