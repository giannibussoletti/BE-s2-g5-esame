package giannibussoletti.entities;

import java.util.ArrayList;
import java.util.List;

public class Boardgames extends GameCollection {
    static List<Boardgames> boardgamesList = new ArrayList<>();
    protected int numOfPlayers;
    protected int totalGameLength;

    public Boardgames(String id, String title, int yearRelease, double price, int numOfPlayers, int totalGameLength) {
        super(id, title, yearRelease, price);
        this.numOfPlayers = numOfPlayers;
        this.totalGameLength = totalGameLength;
    }

    public Boardgames() {

    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }


    @Override
    public void createGame() {
        super.createGame();

        while (true) {
            System.out.println("Quale è il numero minimo di giocatori? (espressi in numeri)");
            if (scanner.hasNextInt()) {
                this.numOfPlayers = scanner.nextInt();
                if (this.numOfPlayers > 0) break;
                else System.out.println("Ci deve essere almeno un giocatore");
            } else {
                System.out.println("Valore non valido");
            }
        }

        while (true) {
            System.out.println("Quanti minuti dura una partita?");
            if (scanner.hasNextInt()) {
                this.totalGameLength = scanner.nextInt();
                if (this.totalGameLength > 0) break;
                else System.out.println("il gioco non può durare 0 minuti");
            } else {
                System.out.println("Valore non valido");
            }
        }

        while (true) {
            long randomIdSeed = random.nextLong();
            String iDChecker = mainCollection.stream().filter(gameCollection -> gameCollection.id.equals(randomIdSeed)).toString();
            if (iDChecker.isEmpty()) {
                this.id = Long.toString(randomIdSeed);
                break;
            }
        }
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
