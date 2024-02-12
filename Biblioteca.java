package gestione;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.*;

/**
 * La classe Biblioteca rappresenta un gestore di libri con funzionalità di
 * aggiunta, modifica, rimozione, ricerca, stampa su file e caricamento da file.
 * I libri vengono gestiti attraverso un array di oggetti Libro.
 */
public class Biblioteca {

	private Libro[] libri;

	private enum DatiLibro {
		Titolo, Autore, Editore, Numero_Pagine, Codice_ISBN, Prezzo, Data_Pubblicazione
	};

	/**
	 * Costruttore della classe Biblioteca. Inizializza l'array di libri con una
	 * dimensione predefinita di 50.
	 */
	public Biblioteca() {
		this.libri = new Libro[50];
	}

	/**
	 * Aggiunge un libro all'array di libri della biblioteca.
	 * 
	 * @param libro Il libro da aggiungere.
	 */
	public void aggiungiLibro(Libro libro) {
		int i = 0;
		boolean inserito = false;

		while (i < libri.length && !inserito) {
			if (libri[i] == null) {
				libri[i] = libro;
				inserito = true;
				System.out.println("Libro inserito correttamente");
			} else
				System.out.println("Capacita' massima di libri raggiunta");
			i++;
		}
	}

	/**
	 * Modifica un libro dell'array di libri in base all'input dell'utente.
	 * 
	 */
	public void modificaLibro() {
		Scanner scanner = new Scanner(System.in);
		int scelta;
		String modifica;
		DatiLibro[] dati = DatiLibro.values();
		int i = 0;
		System.out.println("Scegli il libro da modificare inserendo il numero:");
		System.out.println("-------------------------");

		while (i < libri.length) {
			if (libri[i] != null)
				System.out.println((i + 1) + "- " + libri[i].stampaLibro());
			i++;
		}

		int modificaInt = scanner.nextInt();
		try {
			System.out.println("Cosa vuoi modificare del libro " + libri[modificaInt - 1].getTitolo() + "?");
			for (int j = 0; i < DatiLibro.values().length; i++)
				System.out.println((j + 1) + "-" + dati[j].name());
			scelta = scanner.nextInt();
			switch (scelta) {
			case 1:
				System.out.println("Modifica titolo:");
				scanner.nextLine();
				modifica = scanner.nextLine();
				libri[modificaInt - 1].setTitolo(modifica);
				break;
			case 2:
				System.out.println("Modifica autore:");
				scanner.nextLine();
				modifica = scanner.nextLine();
				libri[modificaInt - 1].setAutore(modifica);
				break;
			case 3:
				System.out.println("Modifica editore:");
				scanner.nextLine();
				modifica = scanner.nextLine();
				libri[modificaInt - 1].setEditore(modifica);
				break;
			case 4:
				System.out.println("Modifica numero pagine:");
				scelta = scanner.nextInt();
				libri[modificaInt - 1].setNumPagine(scelta);
				break;
			case 5:
				System.out.println("Modifica codice ISBN:");
				scelta = scanner.nextInt();
				libri[modificaInt - 1].setCodISBN(scelta);
				break;
			case 6:
				System.out.println("Modifica prezzo:");
				double prezzo = scanner.nextDouble();
				libri[modificaInt - 1].setPrezzo(prezzo);
				break;
			case 7:
				System.out.println("Modifica data pubblicazione: (formato AAAA-MM-GG)");
				scanner.nextLine();
				String data = scanner.nextLine();
				LocalDate data1 = dateInput(data);
				libri[modificaInt - 1].setDataPubblicazione(data1);
				break;
			}
			salvaLibriInFile();
		} catch (DateTimeParseException e) {
			System.out.println("Hai usato un formato della data non valido");
		} catch (NullPointerException e) {
			System.out.println("Stai cercando di modificare un libro che non esiste");
		}
	}

	/**
	 * Rimuove un libro dall'array di libri in base all'input dell'utente.
	 */
	public void rimozioneLibro() {
		System.out.println("Inserire libro da rimuovere");
		int i = 0;
		while (i<libri.length) {
			if(libri[i] != null) {
				System.out.println((i + 1) + "- " + libri[i].stampaLibro());
			}
			i++;
		}
		
		Scanner scanner = new Scanner(System.in);
		int rimuovi = scanner.nextInt();
		libri[rimuovi - 1] = null;
		salvaLibriInFile();

	}

	/**
	 * Ricerca libri nell'array in base alla scelta specificata dall'utente.
	 * 
	 * @param scelta Tipo di ricerca (1: titolo, 2: autore, ..., 7: data di
	 *               pubblicazione).
	 * @throws Exception
	 */
	public void ricercaLibro() {
		Scanner scanner = new Scanner(System.in);
		String ricercaString;
		int ricercaInt;
		DatiLibro[] dati = DatiLibro.values();
		System.out.println("-------------------------");
		System.out.println("In base a cosa vuoi visualizzare i libri?");
		System.out.println("-------------------------");

		for (int j = 0; j < DatiLibro.values().length; j++)
			System.out.println((j + 1) + "-" + dati[j].name());

		int sceltaLibro = scanner.nextInt();
		switch (sceltaLibro) {
		case 1:

			System.out.println("Inserire titolo da cercare:");
			ricercaString = scanner.nextLine();
			for (int i = 0; i < libri.length; i++) {
				if (libri[i] != null && libri[i].getTitolo().equals(ricercaString))
					System.out.println((i + 1) + "-" + libri[i].stampaLibro());
			}
			break;
		case 2:
			System.out.println("Inserire autore da cercare:");
			ricercaString = scanner.nextLine();
			for (int i = 0; i < libri.length; i++) {
				if (libri[i] != null && libri[i].getAutore().equals(ricercaString))
					System.out.println((i + 1) + "-" + libri[i].stampaLibro());
			}
			break;
		case 3:
			System.out.println("Inserire editore da cercare:");
			ricercaString = scanner.nextLine();
			for (int i = 0; i < libri.length; i++) {
				if (libri[i] != null && libri[i].getAutore().equals(ricercaString))
					System.out.println((i + 1) + "-" + libri[i].stampaLibro());
			}
			break;
		case 4:
			System.out.println("Inserire numero pagine da cercare:");
			ricercaInt = scanner.nextInt();
			for (int i = 0; i < libri.length; i++) {
				if (libri[i] != null && libri[i].getNumPagine() == ricercaInt)
					System.out.println((i + 1) + "-" + libri[i].stampaLibro());
			}
			break;
		case 5:
			System.out.println("Inserire codice ISBN da cercare:");
			ricercaInt = scanner.nextInt();
			for (int i = 0; i < libri.length; i++) {
				if (libri[i] != null && libri[i].getCodISBN() == ricercaInt)
					System.out.println((i + 1) + "-" + libri[i].stampaLibro());
			}
			break;
		case 6:
			System.out.println("Inserire prezzo da cercare:");
			double ricerca = scanner.nextDouble();
			for (int i = 0; i < libri.length; i++) {
				if (libri[i] != null && libri[i].getPrezzo() == ricerca)
					System.out.println((i + 1) + "-" + libri[i].stampaLibro());
			}
			break;
		case 7:
			System.out.println("Inserire data di pubblicazione da cercare:  (formato AAAA-MM-GG)");
			String data = scanner.nextLine();
			LocalDate data1 = dateInput(data);
			for (int i = 0; i < libri.length; i++) {
				if (libri[i] != null && libri[i].getDataPubblicazione().equals(data1))
					System.out.println((i + 1) + "-" + libri[i].stampaLibro());
			}
			break;
		default:
			System.out.println("Hai inserito un numero non valido");
		}

	}

	/**
	 * Converte una stringa nel formato "AAAA-MM-GG" in un oggetto LocalDate.
	 * 
	 * @param userInput La stringa rappresentante la data.
	 * @return Oggetto LocalDate corrispondente alla data inserita.
	 */
	public LocalDate dateInput(String userInput) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(userInput, dateFormat);
		return date;
	}

	/**
	 * Salva l'array di libri su un file specifico.
	 * 
	 * @param libri L'array di libri da salvare.
	 */
	public void salvaLibriInFile() {
		String percorsoFile = "databaseBiblioteca.txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(percorsoFile, false))) {
			if (libri != null && libri.length > 0) {
				writer.write("TITOLO/AUTORE/EDITORE/NUMPAGINE/CODISBN/PREZZO/DATAPUBBLICAZIONE");
				writer.newLine();
			}

			for (int i = 0; i < libri.length; i++) {
				if (libri[i] != null) {
					writer.write(libri[i].toString());
					writer.newLine();
				}
			}
			System.out.println("Libri salvati con successo nel file.");
		} catch (IOException e) {
			System.out.println("Errore durante la scrittura nel file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Carica libri da un file specifico nell'array della biblioteca.
	 * 
	 * @param percorsoFile Il percorso del file da cui caricare i libri.
	 */
	public void caricaLibriDaFile() {
		String nomeFile="databaseBiblioteca.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
			reader.readLine();
			String linea = reader.readLine();
			;
			int indiceLibro = 0;

			while (linea != null && indiceLibro < libri.length) {
				Libro libro = convertiRigaInLibro(linea);
				libri[indiceLibro] = libro;
				indiceLibro++;
				linea = reader.readLine();
			}

			System.out.println("Libri caricati con successo dal file.");
		} catch (FileNotFoundException e) {
			System.out.println("Il file non esiste. Messaggio: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Errore durante la lettura del file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Converte una riga di testo in un oggetto Libro.
	 * 
	 * @param linea La riga di testo contenente i dati del libro.
	 * @return Un oggetto Libro corrispondente alla riga di testo.
	 */
	public static Libro convertiRigaInLibro(String linea) {
		String[] separatore = linea.split("/");

		String titolo = separatore[0];
		String autore = separatore[1];
		String editore = separatore[2];
		int numPagine = Integer.parseInt(separatore[3]);
		int codISBN = Integer.parseInt(separatore[4]);
		double prezzo = Double.parseDouble(separatore[5]);
		LocalDate dataPubblicazione = LocalDate.parse(separatore[6]);

		return new Libro(titolo, autore, editore, numPagine, codISBN, prezzo, dataPubblicazione);
	}
}
