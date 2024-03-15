package simonemanca;

import simonemanca.catalogo.*;
import com.github.javafaker.Faker;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // Crea un'istanza di Faker per l'italianità
        Faker faker = new Faker(new Locale("it"));

        // Creo il catalogo
        Catalogo catalogo = new Catalogo();

        // Aggiungo elementi fissi per mantenere consistenza tra le esecuzioni
        aggiungiElementiFissi(catalogo);

        // Aggiungo alcuni elementi generati da Faker per varietà
        aggiungiElementiVari(catalogo, faker);

        // Stampa il catalogo prima del salvataggio su disco
        System.out.println("Catalogo prima del salvataggio:");
        catalogo.getItems().forEach(System.out::println);

        // Prova a salvare il catalogo su disco
        try {
            catalogo.salvaSuDisco("catalogo.ser");
            System.out.println("Catalogo salvato con successo.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del catalogo: " + e.getMessage());
            e.printStackTrace();
        }

        // Interazione con l'utente tramite console
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        while (continua) {
            System.out.println("\nGestione Catalogo");
            System.out.println("1. Visualizza Catalogo");
            System.out.println("2. Carica Catalogo da Disco");
            System.out.println("3. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    // Stampa il catalogo
                    System.out.println("\nCatalogo completo:");
                    catalogo.getItems().forEach(System.out::println);
                    break;
                case 2:
                    // Carica il catalogo da disco e stampa
                    try {
                        catalogo.caricaDaDisco("catalogo.ser");
                        System.out.println("Catalogo caricato da disco con successo.");
                        System.out.println("Catalogo dopo il caricamento da disco:");
                        catalogo.getItems().forEach(System.out::println);
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Errore durante il caricamento del catalogo: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Uscita...");
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }
        scanner.close();
    }



    private static void aggiungiElementiFissi(Catalogo catalogo) {
        // Esempi di dati fissi
        catalogo.aggiungiElemento(new Libro("123-456-789", "Le avventure di Byte", 2000, 300, "Coder Anonimo", "Informatica"));
        catalogo.aggiungiElemento(new Rivista("987-654-321", "Misteri dell'Informatica", 2020, 50, Rivista.Periodicita.MENSILE));
    }

    private static void aggiungiElementiVari(Catalogo catalogo, Faker faker) {
        // Questo ciclo aggiunge 10 libri con dati generati casualmente
        for (int i = 0; i < 10; i++) {
            catalogo.aggiungiElemento(new Libro(
                    faker.code().isbn13(),
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2021),
                    faker.number().numberBetween(100, 1000),
                    faker.book().author(),
                    faker.book().genre()
            ));
        }

        // posso aggiungere riviste con Faker
        // esempio:
        for (int i = 0; i < 5; i++) {
            catalogo.aggiungiElemento(new Rivista(
                    faker.code().isbn13(),
                    faker.company().name(),
                    faker.number().numberBetween(1900, 2021),
                    faker.number().numberBetween(20, 100),
                    Rivista.Periodicita.values()[faker.random().nextInt(Rivista.Periodicita.values().length)]
            ));
        }
    }
}



