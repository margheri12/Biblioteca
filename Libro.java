package gestione;

import java.time.LocalDate;

public class Libro extends Biblioteca{
	private String titolo;
	private String autore;
	private String editore;
	private int numPagine;
	private int codISBN;
	private double prezzo;
	private LocalDate dataPubblicazione;
	
	public Libro(String titolo, String autore, String editore, int numPagine, int codISBN, double prezzo, LocalDate dataPubblicazione) {
			this.titolo = titolo;
			this.autore = autore;
			this.editore = editore; 
			this.numPagine = numPagine;
			this.codISBN = codISBN;
			this.prezzo = prezzo;
			this.dataPubblicazione = dataPubblicazione;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getAutore() {
		return autore;
	}
	
	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	public String getEditore() {
		return editore;
	}
	
	public void setEditore(String editore) {
		this.editore = editore;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}

	public int getCodISBN() {
		return codISBN;
	}

	public void setCodISBN(int codISBN) {
		this.codISBN = codISBN;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public LocalDate getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(LocalDate dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}
	
	public String toString() {
		return ("Titolo: " + titolo + " / Autore: " + autore + " / Editore: " + editore + " / Numero pagine:" + numPagine + " / Codice ISBN: " + codISBN + " / Prezzo: " + prezzo + " / Data pubblicazione: " + dataPubblicazione );
	}
}
