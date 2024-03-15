package simonemanca.catalogo;
import java.io.Serializable;
public abstract class CatalogoItem implements Serializable{
    //attributi per elementi del catalogo:
    protected String isbn;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;

    // Costruttore per inizializzare un oggetto CatalogoItem
    public CatalogoItem(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {

        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }
//GETTERS :&SETTERSSS:
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}

