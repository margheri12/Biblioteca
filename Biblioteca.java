package gestione;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Biblioteca {
	private Libro[] libri;
	public enum DatiLibro {Titolo, Autore, Editore, Numero_Pagine, Codice_ISBN, Prezzo, Data_Pubblicazione};
	
	public Biblioteca() {
		this.libri = new Libro[50];
	}
	
	public void aggiungiLibro(Libro libro) {
		int i = 0;
		boolean inserito = false;
		
		while(i < libri.length && !inserito){
			if(libri[i] == null) {
				libri[i] = libro;
				inserito = true;
				System.out.println("Libro inserito correttamente");
			}
			i++;
		}
	}

	
	public void modificaLibro(int numLibro) {
		Scanner scanner = new Scanner(System.in);
		int scelta;
		double prezzo;
		String modifica;
		DatiLibro[] dati = DatiLibro.values(); 
		LocalDate modificaData;
		System.out.println("Cosa vuoi modificare del libro " + libri[numLibro].getTitolo() + "?");
		for(int i=0; i<DatiLibro.values().length; i++)
			System.out.println(i + "-" + dati[i].name());
		scelta = scanner.nextInt();
		
		switch(scelta) {
			case 1:
				System.out.println("Modifica titolo:");
				modifica = scanner.nextLine();
				libri[numLibro].setTitolo(modifica);
				break;
			case 2: 
				System.out.println("Modifica autore:");
				modifica = scanner.nextLine();
				libri[numLibro].setAutore(modifica);
				break;
			case 3:
				System.out.println("Modifica editore:");
				scanner.nextLine();
				modifica = scanner.nextLine();
				libri[numLibro].setEditore(modifica);
				break;
			case 4:
				System.out.println("Modifica numero pagine:");
				scelta = scanner.nextInt();
				libri[numLibro].setNumPagine(scelta);
				break;
			case 5:
				System.out.println("Modifica codice ISBN:");
				scelta = scanner.nextInt();
				libri[numLibro].setCodISBN(scelta);
				break;
			case 6:
				System.out.println("Modifica prezzo:");
				prezzo = scanner.nextDouble();
				libri[numLibro].setPrezzo(prezzo);
				break;
			case 7:
				System.out.println("Modifica data pubblicazione: (formato AAAA-MM-GG)");
				scanner.nextLine();
				String data = scanner.nextLine();
				LocalDate data1 = dateInput(data);
				libri[numLibro].setDataPubblicazione(data1);
				break;
		}
		
	}
	
	public void rimozioneLibro() {
		System.out.println("Inserire libro da rimuovere");
		int i=0;
		while(libri[i] == null){
			System.out.println((i+1)+ "- " + libri[i].stampaLibro());
			i++;
		}
		Scanner scanner = new Scanner(System.in);
		int rimuovi = scanner.nextInt();
		libri[rimuovi-1] = null;
	}
	
	public void ricercaLibro(int scelta) {
		Scanner scanner = new Scanner(System.in);
		String ricercaString;
		int ricercaInt;
		switch(scelta) {
			case 1:
				
				System.out.println("Inserire titolo da cercare:");
				ricercaString = scanner.nextLine();
				for(int i = 0; i<libri.length;i++) {
					if(libri[i] != null && libri[i].getTitolo().equals(ricercaString))
						System.out.println(i + "-" + libri[i].stampaLibro());
				}
				break;
			case 2:
				System.out.println("Inserire autore da cercare:");
				ricercaString = scanner.nextLine();
				for(int i = 0; i<libri.length;i++) {
					if(libri[i] != null && libri[i].getAutore().equals(ricercaString))
						System.out.println(i + "-" + libri[i].stampaLibro());
				}
				break;
			case 3:
				System.out.println("Inserire editore da cercare:");
				ricercaString = scanner.nextLine();
				for(int i = 0; i<libri.length;i++) {
					if(libri[i] != null && libri[i].getAutore().equals(ricercaString))
						System.out.println(i + "-" + libri[i].stampaLibro());
				}
				break;
			case 4:
				System.out.println("Inserire numero pagine da cercare:");
				ricercaInt = scanner.nextInt();
				for(int i = 0; i<libri.length;i++) {
					if(libri[i] != null && libri[i].getNumPagine() == ricercaInt)
						System.out.println(i + "-" + libri[i].stampaLibro());
				}
				break;
			case 5:
				System.out.println("Inserire codice ISBN da cercare:");
				ricercaInt = scanner.nextInt();
				for(int i = 0; i<libri.length;i++) {
					if(libri[i] != null && libri[i].getCodISBN() == ricercaInt)
						System.out.println(i + "-" + libri[i].stampaLibro());
				}
				break;
			case 6:
				System.out.println("Inserire prezzo da cercare:");
				double ricerca = scanner.nextDouble();
				for(int i = 0; i<libri.length;i++) {
					if(libri[i] != null && libri[i].getPrezzo() == ricerca)
						System.out.println(i + "-" + libri[i].stampaLibro());
				}
				break;
			case 7:
				System.out.println("Inserire data di pubblicazione da cercare:  (formato AAAA-MM-GG)");
				String data = scanner.nextLine();
				LocalDate data1 = dateInput(data);
				for(int i = 0; i<libri.length;i++) {
					if(libri[i] != null && libri[i].getDataPubblicazione().equals(data1))
						System.out.println(i + "-" + libri[i].stampaLibro());
				}
				break;
				
		}
	}
	
	public static LocalDate dateInput(String userInput) {

	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);

	    return date;
	}
	
	public static void salvaLibriInFile(Libro[] libri) {
        String percorsoFile = "databaseBiblioteca.txt"; 
        boolean fileVuoto = false;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(percorsoFile))) {
            fileVuoto = fileReader.readLine() == null;
        } catch (IOException e) {
            System.err.println("Errore durante la verifica del file: " + e.getMessage());
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(percorsoFile, true))) {
            if (fileVuoto) {
                writer.write("TITOLO;AUTORE;EDITORE;NUMPAGINE;CODISBN;PREZZO;DATAPUBBLICAZIONE");
                writer.newLine();
            }

            for (Libro libro : libri) {
                if (libro != null) {
                    writer.write(libro.toString());
                    writer.newLine();
                }
            }

            System.out.println("Libri salvati con successo nel file.");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura nel file: " + e.getMessage());
            e.printStackTrace();
        }
    }
	
	public void caricaLibriDaFile(String percorsoFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(percorsoFile))) {
        	String intestazione = reader.readLine();
            String linea;
            int indiceLibro = 0;

            while ((linea = reader.readLine()) != null && indiceLibro < libri.length) {
                Libro libro = convertiRigaInLibro(linea);
                libri[indiceLibro] = libro;
                indiceLibro++;
            }

            System.out.println("Libri caricati con successo dal file.");
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Libro convertiRigaInLibro(String linea) {
        // Separatore per dividere i campi nel formato "TITOLO;AUTORE;EDITORE;..."
        String[] campi = linea.split(";");

        // Estrai informazioni specifiche dai campi (da personalizzare)
        String titolo = campi[0];
        String autore = campi[1];
        String editore = campi[2];
        int numPagine = Integer.parseInt(campi[3]);
        int codISBN = Integer.parseInt(campi[4]);
        double prezzo = Double.parseDouble(campi[5]);
        LocalDate dataPubblicazione = LocalDate.parse(campi[6]);

        // Crea e restituisci un nuovo oggetto Libro
        return new Libro(titolo, autore, editore, numPagine, codISBN, prezzo, dataPubblicazione);
    }
    
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
//		biblioteca.caricaLibriDaFile("databaseBiblioteca.txt");
		int scelta;
		
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1- Aggiungi un libro");
			System.out.println("2- Modifica un libro");
			System.out.println("3- Rimuovi un libro");
			System.out.println("4- Visualizza un libro");
			System.out.println("ALTRIMENTI INSERISCI QUALSIASI NUMERO PER USCIRE");
			
			scelta = scanner.nextInt();
			scanner.nextLine();
			
			switch(scelta) {
				case 1:
					System.out.println("Titolo:");
					String titolo = scanner.nextLine();
					System.out.println("Autore:");
					String autore = scanner.nextLine();
					System.out.println("Editore:");
					String editore = scanner.nextLine();
					System.out.println("Numero pagine:");
					int pagine = scanner.nextInt();
					System.out.println("Codice ISBN:");
					int ISBN = scanner.nextInt();
					System.out.println("Prezzo:");
					double prezzo = scanner.nextDouble();
					System.out.println("Data pubblicazione: (formato AAAA-MM-GG)");
					scanner.nextLine();
					String data = scanner.nextLine();
					LocalDate data1 = dateInput(data);
					Libro libro = new Libro(titolo,autore,editore,pagine,ISBN,prezzo,data1);
					biblioteca.aggiungiLibro(libro);
					break;
				case 2:
					int i=0;
					System.out.println("Scegli un libro inserendo il numero:");
					while(i<biblioteca.libri.length) {
						if(biblioteca.libri[i] != null)
							System.out.println("Libro " + (i+1) + "\nTitolo=" + biblioteca.libri[i].getTitolo());
						i++;
					}
					int modifica = scanner.nextInt();
					biblioteca.modificaLibro(modifica);
					break;
				case 3: 
					biblioteca.rimozioneLibro();
					break;
				case 4:
					DatiLibro[] dati = DatiLibro.values(); 
					System.out.println("In base a cosa vuoi visualizzare i libri?");
					for(int j=0; j<DatiLibro.values().length; j++)
						System.out.println(j + "-" + dati[j].name());
					int sceltaLibro = scanner.nextInt();
					biblioteca.ricercaLibro(sceltaLibro);
			}
			salvaLibriInFile(biblioteca.libri);
			
		}while(scelta<5 && scelta>0);
	}
}
