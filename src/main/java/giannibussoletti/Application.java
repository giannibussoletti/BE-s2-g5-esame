package giannibussoletti;

import giannibussoletti.entities.Boardgames;
import giannibussoletti.entities.Videogames;

public class Application {

    public static void main(String[] args) {

        Videogames placeVideo = new Videogames() {
        };
        Boardgames placeBoard = new Boardgames() {
        };

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

    }
}
