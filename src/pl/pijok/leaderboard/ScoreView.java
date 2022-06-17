package pl.pijok.leaderboard;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class ScoreView extends ListCell<Score> {

    @Override
    protected void updateItem(Score score, boolean b) {
        super.updateItem(score, b);
        Label label;
        if(score != null){
            label = new Label( score.nickname() + " " + score.score());
        }
        else {
            label = new Label("");
        }
        setAlignment(Pos.CENTER);
        setGraphic(label);
    }
}
