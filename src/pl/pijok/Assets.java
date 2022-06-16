package pl.pijok;

import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class Assets {

    private static Image eggImage;
    private static Image rampLeftImage;
    private static Image rampRightImage;
    private static Image backgroundImage;
    private static Image handsImage;
    private static Image crewMateImage;
    private static Image crewMateFlippedImage;
    private static Image shyCrewMateImage;
    private static Image susBackground;
    private static Image bucketImage;

    private static Font minecraftFont;

    public static void load(){
        rampRightImage = new Image("file:assets/img/ramp.png");
        rampLeftImage = new Image("file:assets/img/ramp2.png");
        //backgroundImage = new Image("file:assets/img/MC-252.png");
        backgroundImage = new Image("file:assets/img/consolus.png");
        eggImage = new Image("file:assets/img/egg.png");
        handsImage = new Image("file:assets/img/hands.png");
        crewMateImage = new Image("file:assets/img/crewmate.png");
        crewMateFlippedImage = new Image("file:assets/img/crewmateFlipped.png");
        susBackground = new Image("file:assets/img/susbackground.png");
        shyCrewMateImage = new Image("file:assets/img/shycrewmate.png");
        bucketImage = new Image("file:assets/img/bucket.png");

        //minecraftFont = Font.loadFont("assets/fonts/Minecraft.ttf", 36);
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

    public static Image getCrewMateImage() {
        return crewMateImage;
    }

    public static Image getSusBackground() {
        return susBackground;
    }

    public static Image getShyCrewMateImage() {
        return shyCrewMateImage;
    }

    public static Image getBucketImage() {
        return bucketImage;
    }

    public static Font getMinecraftFont() {
        return minecraftFont;
    }

    public static Image getCrewMateFlippedImage() {
        return crewMateFlippedImage;
    }
}
