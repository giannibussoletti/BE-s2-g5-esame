package giannibussoletti.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    protected String id;
    protected String title;
    protected int yearRelease;
    protected double price;

    List<Collection> mainColletion = new ArrayList<>();


    public Collection(String id, String title, int yearRelease, double price) {
        this.id = id;
        this.title = title;
        this.yearRelease = yearRelease;
        this.price = price;
    }


    public String getId() {
        return id;
    }

    public void searchGameByID(String gameID) {
        String foundGame = mainColletion.stream().filter(collection -> collection.getId().equals(gameID)).toString();
        if (foundGame.isEmpty()) {
            System.out.println("Gioco non trovato nell'archivio");
        } else {
            System.out.println("Il tuo gioco è " + title);
        }
    }

    @Override
    public String toString() {
        return "Collection{" +
                "price=" + price +
                ", yearRelease=" + yearRelease +
                ", title='" + title + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

