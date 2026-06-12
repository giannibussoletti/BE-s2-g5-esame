package giannibussoletti.entities;

import giannibussoletti.enums.Genre;
import giannibussoletti.enums.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Videogames extends Collection {
    static Scanner scanner = new Scanner(System.in);
    static List<Videogames> onlyVideogames = new ArrayList<>();
    protected final Platform platform;
    protected final int totalGameLength;
    protected final Genre genre;
//mainColletion.addAll(onlyVideogames);


    public Videogames(String id, String title, int yearRelease, double price, Platform platform, int totalGameLength, Genre genre) {
        super(id, title, yearRelease, price);
        this.platform = platform;
        this.totalGameLength = totalGameLength;
        this.genre = genre;

    }

    public static void createVideogame() {
        System.out.println("Aggiungiamo un nuovo gioco alla lista");
        String gameTitle = "";
        while (true) {
            System.out.println("Dimmi il titolo:");
            if (scanner.hasNextLine()) {
                gameTitle = scanner.nextLine();
                break;
            } else if (scanner.hasNextDouble()) {
                gameTitle = Double.toString(scanner.nextDouble());
                break;
            } else {
                System.out.println("Titolo non valido");
                scanner.nextLine();
            }
        }

        int gameYearRelease = 0;
        while (true) {
            System.out.println("In che anno è stato rilasciato?");
            if (scanner.hasNextInt()) {
                gameYearRelease = scanner.nextInt();
                if (gameYearRelease < 1971 || gameYearRelease > 2030) {
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

        double gamePrice = 0.0;
        while (true) {
            System.out.println("Quanto costa?");
            if (scanner.hasNextDouble()) {
                gamePrice = scanner.nextDouble();
                if (gamePrice <= 0) {
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

        Platform gamePlatform = null;
        while (true) {
            System.out.println("Su quale piattaforma è stato rilasciato? Usa i numeri indicati");
            System.out.println("""
                    1) PC
                    2) XBOX
                    3) SWITCH
                    4) PLAYSTATION
                    5) MULTIPLE
                    6) ALTRE PIATTAFORME""");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice <= 6 && choice >= 1) {
                    switch (choice) {
                        case 1 -> gamePlatform = Platform.PC;
                        case 2 -> gamePlatform = Platform.XBOX;
                        case 3 -> gamePlatform = Platform.SWITCH;
                        case 4 -> gamePlatform = Platform.PLAYSTATION;
                        case 5 -> gamePlatform = Platform.MULTIPLE;
                        case 6 -> gamePlatform = Platform.ALTRE_PIATTAFORME;
                    }
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Numero non valido");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Valore non valido");
                scanner.nextLine();

            }
        }

        int length = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                scanner.nextLine();
                if (length > 0) break;
                else {
                    System.out.println("Il valore deve essere almeno 1");
                    scanner.nextLine();

                }
            }
        }

        Genre gameGenre = null;
        while (true) {
            System.out.println("Quale è il suo genere principale? Usa i numeri indicati");
            System.out.println(
                    "1) ACTION,\n" +
                            "2) HORROR,\n" +
                            "3) COZY,\n" +
                            "4) PUZZLE,\n" +
                            "5) RPG,\n" +
                            "6) JRPG,\n" +
                            "7) STEALTH,\n" +
                            "8) FIRST_PERSON_SHOOTER,\n" +
                            "9) MMO"
            );
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice <= 9 && choice >= 1) {
                    switch (choice) {
                        case 1 -> gameGenre = Genre.ACTION;
                        case 2 -> gameGenre = Genre.HORROR;
                        case 3 -> gameGenre = Genre.COZY;
                        case 4 -> gameGenre = Genre.PUZZLE;
                        case 5 -> gameGenre = Genre.RPG;
                        case 6 -> gameGenre = Genre.JRPG;
                        case 7 -> gameGenre = Genre.STEALTH;
                        case 8 -> gameGenre = Genre.FIRST_PERSON_SHOOTER;
                        case 9 -> gameGenre = Genre.MMO;
                    }
                    break;

                } else {
                    System.out.println("Numero non valido");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Valore non valido");
                scanner.nextLine();

            }
        }

        onlyVideogames.add(new Videogames("id", gameTitle, gameYearRelease, gamePrice, gamePlatform, length, gameGenre));
        onlyVideogames.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Videogames{" +
                "platform=" + platform +
                ", totalGameLength=" + totalGameLength +
                ", genre=" + genre +
                "} " + super.toString();
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
