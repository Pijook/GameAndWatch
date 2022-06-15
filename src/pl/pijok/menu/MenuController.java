package pl.pijok.menu;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pl.pijok.GameAndWatch;

public class MenuController {

    private int selectedOption;
    private int maxOptions;

    public MenuController(){
        selectedOption = 0;
        maxOptions = GameAndWatch.getMenuPane().getvBox().getChildren().size() - 1;

        updateMenuPane(selectedOption, selectedOption);
    }

    public void selectNextOption(){
        int newOption = selectedOption + 1;
        if(newOption >= maxOptions){
            newOption = 0;
        }
        updateMenuPane(selectedOption, newOption);
        selectedOption = newOption;
    }

    public void selectPreviousOption(){
        int newOption = selectedOption - 1;
        if(newOption < 0){
            newOption = maxOptions - 1;
        }
        updateMenuPane(selectedOption, newOption);
        selectedOption = newOption;
    }

    public void updateMenuPane(int previousOption, int newOption){
        Label previousLabel = (Label) GameAndWatch.getMenuPane().getvBox().getChildren().get(previousOption + 1);
        Label newLabel = (Label) GameAndWatch.getMenuPane().getvBox().getChildren().get(newOption + 1);
        previousLabel.setBorder(new Border(new BorderStroke(
                Color.TRANSPARENT,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.EMPTY
        )));

        newLabel.setBorder(new Border(new BorderStroke(
                Color.WHITE,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT
        )));
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }

    public int getMaxOptions() {
        return maxOptions;
    }

    public void setMaxOptions(int maxOptions) {
        this.maxOptions = maxOptions;
    }
}
