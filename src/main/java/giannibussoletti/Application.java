package giannibussoletti;

import giannibussoletti.entities.Boardgames;
import giannibussoletti.entities.GameCollection;
import giannibussoletti.entities.Videogames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        List<GameCollection> mainColletion = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Videogames placeVideo = new Videogames() {
        };
        Boardgames placeBoard = new Boardgames() {
        };
        GameCollection gameCollection = new GameCollection() {
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
                if (scanner.hasNextInt()) {
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

                        case 2 -> {
                            System.out.println("Inserisci l'Id");
                            String id = scanner.nextLine();
                            scanner.nextLine();
                            gameCollection.searchGameByID(mainColletion, id);
                            gameCollection.printMain();
                        }
                        case 3 -> {
                            while (true) {
                                System.out.println("Inserisci il prezzo massimo");
                                if (scanner.hasNextDouble()) {
                                    double price = scanner.nextDouble();
                                    if (price > 0) {
                                        gameCollection.searchGameByPrice(price);
                                        break;
                                    }
                                    break;
                                } else {
                                    System.out.println("Valore non valido");
                                    scanner.nextLine();
                                }
                            }

                        }
                        case 0 -> System.exit(0);
                    }
                    break;
                }
            }
        }
    }
}

