package giannibussoletti.entities;

public class Boardgames extends Collection {
    private final int numOfPlayers;
    private final int totalGameLength;

    public Boardgames(String title, int yearOfRelease, double price, int numOfPlayers, int totalGameLength) {
        this.title = title;
        this.yearRelease = yearOfRelease;
        this.price = price;
        this.numOfPlayers = numOfPlayers;
        this.totalGameLength = totalGameLength;


    }
}
