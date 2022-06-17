package pl.pijok;

public class Settings {

    private static int width;
    private static int height;
    private static String title;

    private static int lives;
    private static int defaultSpawnRate;
    private static int spawnRateDecrease;

    public static void load(){
        width = 1280;
        height = 720;
        title = "Consolus";

        lives = 4;
        defaultSpawnRate = 5000;
        spawnRateDecrease = 100;
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

    public static int getLives() {
        return lives;
    }

    public static int getDefaultSpawnRate() {
        return defaultSpawnRate;
    }

    public static int getSpawnRateDecrease() {
        return spawnRateDecrease;
    }
}
