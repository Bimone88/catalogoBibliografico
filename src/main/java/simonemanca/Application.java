package simonemanca;

import simonemanca.catalogo.Libro;
import simonemanca.catalogo.Rivista;
import com.github.javafaker.Faker;

import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it"));

        Libro fakeBook = new Libro(
                faker.code().isbn13(),
                faker.book().title(),
                faker.number().numberBetween(1900, 2021),
                faker.number().numberBetween(100, 1000),
                faker.book().author(),
                faker.book().genre()
        );

        Rivista.Periodicita periodicita = Rivista.Periodicita.values()[faker.number().numberBetween(0, Rivista.Periodicita.values().length)];
        Rivista fakeMagazine = new Rivista(
                faker.code().isbn13(),
                faker.book().title(),
                faker.number().numberBetween(1900, 2021),
                faker.number().numberBetween(20, 100),
                periodicita
        );

        System.out.println("Libro: " + fakeBook.getTitolo() + ", Autore: " + fakeBook.getAutore());
        System.out.println("Rivista: " + fakeMagazine.getTitolo() + ", Periodicità: " + fakeMagazine.getPeriodicita());
    }
}

