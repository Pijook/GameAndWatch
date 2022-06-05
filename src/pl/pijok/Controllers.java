package pl.pijok;

import pl.pijok.menu.MenuController;
import pl.pijok.screen.ScreenController;

public class Controllers {

    private static ScreenController screenController;
    private static MenuController menuController;

    public static void load(){
        screenController = new ScreenController();
        menuController = new MenuController();
    }

    public static ScreenController getScreenController() {
        return screenController;
    }

    public static MenuController getMenuController() {
        return menuController;
    }
}
