package simonemanca.catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Catalogo {
    private List<CatalogoItem> items = new ArrayList<>();

    // Metodo per aggiungere un elemento al catalogo
    public void aggiungiElemento(CatalogoItem item) {
        items.add(item);
    }

    // Metodo per rimuovere un elemento dal catalogo tramite ISBN
    public boolean rimuoviElementoPerIsbn(String isbn) {
        return items.removeIf(item -> item.getIsbn().equals(isbn));
    }

    // Metodo per cercare un elemento per ISBN
    public CatalogoItem cercaPerIsbn(String isbn) {
        return items.stream()
                .filter(item -> item.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null); // Ritorna null se non viene trovato nessun elemento con l'ISBN
    }

    // Metodo per cercare elementi per anno di pubblicazione
    public List<CatalogoItem> cercaPerAnnoPubblicazione(int anno) {
        return items.stream()
                .filter(item -> item.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    // Metodo per cercare libri per autore :
    public List<Libro> cercaLibriPerAutore(String autore) {
        return items.stream()
                .filter(item -> item instanceof Libro)
                .map(item -> (Libro)item)
                .filter(libro -> libro.getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    // Getter per ottenere tutti gli elementi del catalogo
    public List<CatalogoItem> getItems() {
        return new ArrayList<>(items);
    }
}

