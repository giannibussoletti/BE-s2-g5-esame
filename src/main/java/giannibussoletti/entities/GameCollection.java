package giannibussoletti.entities;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class GameCollection {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    //    static List<GameCollection> mainCollection = new ArrayList<>();
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

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void searchGameByID(String gameID) {
        String foundGame = mainCollection.stream().filter(gameCollection -> gameCollection.getId().equals(gameID)).limit(1).map(GameCollection::getTitle).toString();
        if (!foundGame.isEmpty()) {
            System.out.println(foundGame);
        } else {
            System.out.println("Gioco non trovato nell'archivio");
        }
    }

    public void searchGameByPrice(double searchedPrice) {
        List<GameCollection> filteredByPrice = mainCollection.stream().filter(gameCollection -> gameCollection.getPrice() < searchedPrice).toList();
        if (!filteredByPrice.isEmpty()) filteredByPrice.forEach(System.out::println);
        else System.out.println("non ho trovato giochi nella lista");
    }

    public void printMain() {
        mainCollection.forEach(System.out::println);
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

