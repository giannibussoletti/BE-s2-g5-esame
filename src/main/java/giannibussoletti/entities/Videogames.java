package giannibussoletti.entities;

import giannibussoletti.enums.Genre;

public class Videogames extends Collection {
    private final String platform;
    private final double totalGameLength;
    private final Genre genre;

    public Videogames(String title, int yearOfRelease, double price, String platform, double totalGameLength, Genre genre) {
        this.title = title;
        this.yearRelease = yearOfRelease;
        this.price = price;
        this.platform = platform;
        this.totalGameLength = totalGameLength;
        this.genre = genre;

    }
}
