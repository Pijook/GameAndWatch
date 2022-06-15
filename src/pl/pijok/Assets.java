package pl.pijok;

import javafx.scene.image.Image;

public class Assets {

    private static Image eggImage;
    private static Image rampLeftImage;
    private static Image rampRightImage;
    private static Image backgroundImage;
    private static Image handsImage;

    public static void load(){
        rampRightImage = new Image("file:assets/img/ramp.png");
        rampLeftImage = new Image("file:assets/img/ramp2.png");
        backgroundImage = new Image("file:assets/img/MC-252.png");
        eggImage = new Image("file:assets/img/egg.png");
        handsImage = new Image("file:assets/img/hands.png");
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

    public static Image getBackgroundImage() {
        return backgroundImage;
    }

    public static Image getHandsImage() {
        return handsImage;
    }
}
