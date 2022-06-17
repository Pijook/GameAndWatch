package pl.pijok.leaderboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pijok.GameAndWatch;
import pl.pijok.game.GameType;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeaderboardController {

    //private List<Score> playerScores;
    private ObservableList<Score> playerScores;

    public LeaderboardController(){

    }

    public void load() throws IOException, ClassNotFoundException {
        System.out.println("Loading");
        File file = new File("leaderboard.txt");

        if(!file.exists()){
            playerScores = FXCollections.observableArrayList(
                    new Score("Pijok", 100, 60, GameType.GameA),
                    new Score("Fade", 75, 15, GameType.GameA),
                    new Score("Hex", -1, -1, GameType.GameA)
            );
            return;
        }


        FileInputStream fileInputStream = new FileInputStream("leaderboard.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        List<Score> temp = (List<Score>) objectInputStream.readObject();

        playerScores = FXCollections.observableList(temp);
        objectInputStream.close();

        GameAndWatch.getLeaderboardPane().getPlayerScores().setItems(playerScores);
    }

    public void save() throws IOException {
        System.out.println("Saving");
        for(Score score : playerScores){
            System.out.println(score);
        }
        File file = new File("leaderboard.txt");

        if(file.exists()){
            file.delete();
        }
        file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream("leaderboard.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        List<Score> temp = new ArrayList<>(playerScores);

        objectOutputStream.writeObject(temp);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public void addScore(String nickname, int score, int time, GameType gameType){
        playerScores.add(new Score(nickname, score, time, gameType));
        playerScores.sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.score() - o1.score();
            }
        });
    }

}
