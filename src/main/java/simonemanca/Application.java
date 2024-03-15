package simonemanca;

import simonemanca.catalogo.Libro;
import simonemanca.catalogo.Rivista;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it")); // Crea un'istanza con fraker per l'italianità

        // ciclo for per creazione di libri, che faccio 10
        int numberOfBooks = 10;
        List<Libro> books = new ArrayList<>();
        for (int i = 0; i < numberOfBooks; i++) {
            //oggetto libro con dati fittizi
            Libro book = new Libro(
                    faker.code().isbn13(), // Genera un ISBN fittizio
                    faker.book().title(), // Genera un titolo fittizio
                    faker.number().numberBetween(1900, 2021), // Genera un anno di pubblicazione compreso tra 1900 e 2021
                    faker.number().numberBetween(100, 1000), // Genera un numero di pagine compreso tra 100 e 1000
                    faker.book().author(), // Genera un nome di autore fittizio
                    faker.book().genre() // Genera un genere fittizio
            );
            books.add(book); // Aggiunge il libro fittizio alla lista
        }

        // ciclo per stampare dettagli dei libri che ho creato con il ciclo di prima:
        for (Libro book : books) {
            System.out.println("Libro: " + book.getTitolo() + ", Autore: " + book.getAutore() + ", ISBN: " + book.getIsbn());
        }

        // enum periodicita
        Rivista.Periodicita periodicita = Rivista.Periodicita.values()[faker.number().numberBetween(0, Rivista.Periodicita.values().length)];
        // Creazione di un oggetto Rivista con dati fittizi
        Rivista fakeMagazine = new Rivista(
                faker.code().isbn13(),
                faker.book().title(),
                faker.number().numberBetween(1900, 2021),
                faker.number().numberBetween(20, 100),
                periodicita
        );

        // Stampaaa:
        System.out.println("Rivista: " + fakeMagazine.getTitolo() + ", Periodicità: " + fakeMagazine.getPeriodicita());
    }
}


