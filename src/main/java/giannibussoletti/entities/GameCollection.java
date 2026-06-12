package giannibussoletti.entities;

import giannibussoletti.enums.Genre;
import giannibussoletti.enums.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class GameCollection {
    static Scanner scanner = new Scanner(System.in);
    static List<GameCollection> mainColletion = new ArrayList<>();
    static Random random = new Random();
    protected String id;
    protected String title;
    protected int yearRelease;
    protected double price;


    public GameCollection(String id, String title, int yearRelease, double price) {
        this.id = id;
        this.title = title;
        this.yearRelease = yearRelease;
        this.price = price;
    }

    public GameCollection() {
    }


    public void createGame() {
        System.out.println("Aggiungiamo un nuovo gioco alla lista");

        while (true) {
            System.out.println("Dimmi il titolo:");
            if (scanner.hasNextLine()) {
                this.title = scanner.nextLine();
                break;
            } else if (scanner.hasNextDouble()) {
                this.title = Double.toString(scanner.nextDouble());
                break;
            } else {
                System.out.println("Titolo non valido");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.println("In che anno è stato rilasciato?");
            if (scanner.hasNextInt()) {
                this.yearRelease = scanner.nextInt();
                if (this.yearRelease < 1971 || this.yearRelease > 2030) {
                    System.out.println("Anno non valido");
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                    break;
                }
            } else {
                System.out.println("Anno non valido, inserire un valore valido");
                scanner.nextLine();
            }
        }


        while (true) {
            System.out.println("Quanto costa?");
            if (scanner.hasNextDouble()) {
                this.price = scanner.nextDouble();
                if (this.price <= 0) {
                    System.out.println("Non puoi inserire un valore negativo");
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                    break;
                }
            } else {
                System.out.println("Valore non valido");
                scanner.nextLine();
            }
        }
    }


    public String getId() {
        return id;
    }

    public void searchGameByID(String gameID) {
        Videogames testGame = new Videogames("12345", "IL pianeta", 2020, 20.20, Platform.PC, 20, Genre.ACTION);
        String foundGame = mainColletion.stream().filter(collection -> collection.getId().equals(gameID)).map(gameCollection -> gameCollection.getId()).toString();
        if (foundGame.isEmpty()) {
            System.out.println("Gioco non trovato nell'archivio");
        } else {
            System.out.println("Il tuo gioco è " + title);
        }
    }

    public void printMain() {
        mainColletion.forEach(System.out::println);
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

