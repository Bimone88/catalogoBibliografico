package simonemanca.catalogo;
import java.io.Serializable;
public class Rivista extends CatalogoItem implements Serializable{
    public enum Periodicita { SETTIMANALE, MENSILE, SEMESTRALE }
    private Periodicita periodicita;

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
    @Override
    public String toString() {
        return String.format("Rivista{periodicita=%s, isbn='%s', titolo='%s', annoPubblicazione=%d, numeroPagine=%d}",
                getPeriodicita().name(), getIsbn(), getTitolo(), getAnnoPubblicazione(), getNumeroPagine());
    }





}

