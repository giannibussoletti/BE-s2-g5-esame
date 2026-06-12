package giannibussoletti.entities;

import java.util.ArrayList;
import java.util.List;

public class Boardgames extends Collection {
    protected final int numOfPlayers;
    protected final int totalGameLength;

    List<Boardgames> boardgamesList = new ArrayList<>();

    public Boardgames(String id, String title, int yearRelease, double price, int numOfPlayers, int totalGameLength) {
        super(id, title, yearRelease, price);
        this.numOfPlayers = numOfPlayers;
        this.totalGameLength = totalGameLength;

    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

//    public void searchByNumOfPlayers(int numOfPlayers) {
//mainColletion.stream()
//    }

    @Override
    public String getId() {
        return super.getId();
    }
}
