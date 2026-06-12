package giannibussoletti.entities;

import giannibussoletti.enums.Genre;
import giannibussoletti.enums.Platform;

public class Videogames extends GameCollection {
    protected int totalGameLength;
    protected Genre genre;
    protected Platform platform;


    public Videogames(String id, String title, int yearRelease, double price, Platform platform, int totalGameLength, Genre genre) {
        super(id, title, yearRelease, price);
        this.platform = platform;
        this.totalGameLength = totalGameLength;
        this.genre = genre;

    }

    public Videogames() {
        
    }


    @Override
    public void createGame() {
        super.createGame();
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
                        case 1 -> this.platform = Platform.PC;
                        case 2 -> this.platform = Platform.XBOX;
                        case 3 -> this.platform = Platform.SWITCH;
                        case 4 -> this.platform = Platform.PLAYSTATION;
                        case 5 -> this.platform = Platform.MULTIPLE;
                        case 6 -> this.platform = Platform.ALTRE_PIATTAFORME;
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

        while (true) {
            if (scanner.hasNextInt()) {
                this.totalGameLength = scanner.nextInt();
                scanner.nextLine();
                if (this.totalGameLength > 0) break;
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
                    """
                            1) ACTION,
                            2) HORROR,
                            3) COZY,
                            4) PUZZLE,
                            5) RPG,
                            6) JRPG,
                            7) STEALTH,
                            8) FIRST_PERSON_SHOOTER,
                            9) MMO"""
            );
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice <= 9 && choice >= 1) {
                    switch (choice) {
                        case 1 -> this.genre = Genre.ACTION;
                        case 2 -> this.genre = Genre.HORROR;
                        case 3 -> this.genre = Genre.COZY;
                        case 4 -> this.genre = Genre.PUZZLE;
                        case 5 -> this.genre = Genre.RPG;
                        case 6 -> this.genre = Genre.JRPG;
                        case 7 -> this.genre = Genre.STEALTH;
                        case 8 -> this.genre = Genre.FIRST_PERSON_SHOOTER;
                        case 9 -> this.genre = Genre.MMO;
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

        while (true) {
            long randomIdSeed = random.nextLong();
            String iDChecker = mainColletion.stream().filter(gameCollection -> gameCollection.id.equals(randomIdSeed)).toString();
            if (iDChecker.isEmpty()) {
                this.id = Long.toString(randomIdSeed);
                break;
            }
        }
        mainColletion.add(new Videogames(this.id, this.title, this.yearRelease, this.price, this.platform, this.totalGameLength, this.genre));

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
