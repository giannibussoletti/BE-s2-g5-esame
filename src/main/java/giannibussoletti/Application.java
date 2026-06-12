package giannibussoletti;

import giannibussoletti.entities.Boardgames;
import giannibussoletti.entities.Videogames;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Videogames placeVideo = new Videogames() {
        };
        Boardgames placeBoard = new Boardgames() {
        };

        while (true) {
            System.out.println("""
                    1) Aggiungi un gioco
                    2) Ricerca per ID
                    3) Ricerca i giochi per prezzo massimo
                    4) Ricerca per numero di giocatori
                    5) Rimuovi un gioco
                    6) Aggiorna un gioco
                    7) Stampa le statistiche della collezione
                    0) Esci
                    """);
            while (true) {
                if (scanner.hasNextInt())
                    switch (scanner.nextInt()) {
                        case 1 -> {
                            while (true) {
                                System.out.println("""
                                        Che tipo di gioco vuoi aggiungere?
                                        1) Videogioco?
                                        2) Gioco da tavolo?
                                        """);
                                if (scanner.hasNextInt()) {
                                    int choice = scanner.nextInt();
                                    if (choice == 1) {
                                        placeVideo.createGame();
                                        break;
                                    } else if (choice == 2) {
                                        placeBoard.createGame();
                                        break;
                                    } else {
                                        System.out.println("Numero non valido");
                                        scanner.nextLine();
                                    }
                                } else {
                                    System.out.println("Valore non valido non valido");
                                    scanner.nextLine();
                                }
                            }
                        }
                    }
//                    case 2 ->
//                    case 3 ->
//                    case 4 ->
//                    case 5 ->
//                    case 6 ->
//                    case 7 ->
//                      case default ->
//                    case 0 -> System.exit(0);
            }
        }

    }

}

