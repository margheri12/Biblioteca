package gestione;

import java.time.LocalDate;

/**
 * La classe Libro rappresenta un libro in una biblioteca.
 * Estende la classe Biblioteca.
 */
public class Libro extends Biblioteca {

    private String titolo;
    private String autore;
    private String editore;
    private int numPagine;
    private int codISBN;
    private double prezzo;
    private LocalDate dataPubblicazione;

    /**
     * Costruttore della classe Libro.
     * @param titolo Il titolo del libro.
     * @param autore L'autore del libro.
     * @param editore L'editore del libro.
     * @param numPagine Il numero di pagine del libro.
     * @param codISBN Il codice ISBN del libro.
     * @param prezzo Il prezzo del libro.
     * @param dataPubblicazione La data di pubblicazione del libro.
     */
    public Libro(String titolo, String autore, String editore, int numPagine, int codISBN, double prezzo, LocalDate dataPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.editore = editore;
        this.numPagine = numPagine;
        this.codISBN = codISBN;
        this.prezzo = prezzo;
        this.dataPubblicazione = dataPubblicazione;
    }

    /**
     * Restituisce il titolo del libro.
     * @return Il titolo del libro.
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Imposta il titolo del libro.
     * @param titolo Il nuovo titolo del libro.
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Restituisce l'autore del libro.
     * @return L'autore del libro.
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Imposta l'autore del libro.
     * @param autore Il nuovo autore del libro.
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }

    /**
     * Restituisce l'editore del libro.
     * @return L'editore del libro.
     */
    public String getEditore() {
        return editore;
    }

    /**
     * Imposta l'editore del libro.
     * @param editore Il nuovo editore del libro.
     */
    public void setEditore(String editore) {
        this.editore = editore;
    }

    /**
     * Restituisce il numero di pagine del libro.
     * @return Il numero di pagine del libro.
     */
    public int getNumPagine() {
        return numPagine;
    }

    /**
     * Imposta il numero di pagine del libro.
     * @param numPagine Il nuovo numero di pagine del libro.
     */
    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }

    /**
     * Restituisce il codice ISBN del libro.
     * @return Il codice ISBN del libro.
     */
    public int getCodISBN() {
        return codISBN;
    }

    /**
     * Imposta il codice ISBN del libro.
     * @param codISBN Il nuovo codice ISBN del libro.
     */
    public void setCodISBN(int codISBN) {
        this.codISBN = codISBN;
    }

    /**
     * Restituisce il prezzo del libro.
     * @return Il prezzo del libro.
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il prezzo del libro.
     * @param prezzo Il nuovo prezzo del libro.
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Restituisce la data di pubblicazione del libro.
     * @return La data di pubblicazione del libro.
     */
    public LocalDate getDataPubblicazione() {
        return dataPubblicazione;
    }

    /**
     * Imposta la data di pubblicazione del libro.
     * @param dataPubblicazione La nuova data di pubblicazione del libro.
     */
    public void setDataPubblicazione(LocalDate dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    /**
     * Restituisce una stringa formattata rappresentante il libro.
     * @return Una stringa che rappresenta il libro con tutti i suoi dettagli.
     */
    public String stampaLibro() {
        return ("Titolo: " + titolo + " / Autore: " + autore + " / Editore: " + editore +
                " / Numero pagine:" + numPagine + " / Codice ISBN: " + codISBN +
                " / Prezzo: " + prezzo + " / Data pubblicazione: " + dataPubblicazione);
    }

    /**
     * Restituisce una stringa contenente i dettagli del libro da mettere in un file.
     * @return Una stringa contenente i dettagli del libro.
     */
    @Override
    public String toString() {
        return (titolo + "/" + autore + "/" + editore + "/" + numPagine +
                "/" + codISBN + "/" + prezzo + "/" + dataPubblicazione);
    }
}
