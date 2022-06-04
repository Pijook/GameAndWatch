package pl.pijok;

import pl.pijok.screen.ScreenController;

public class Controllers {

    private static ScreenController screenController;

    public static void load(){
        screenController = new ScreenController();
    }

    public static ScreenController getScreenController() {
        return screenController;
    }
}
