package pl.pijok;

public class Settings {

    private static int width;
    private static int height;
    private static String title;

    public static void load(){
        width = 1280;
        height = 720;
        title = "Consolus";
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static String getTitle() {
        return title;
    }
}
