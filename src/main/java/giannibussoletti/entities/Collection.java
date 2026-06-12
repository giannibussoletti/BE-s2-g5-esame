package giannibussoletti.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Collection {
    static Scanner scanner = new Scanner(System.in);
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

