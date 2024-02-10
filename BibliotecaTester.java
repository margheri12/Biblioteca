package gestione;

import java.time.LocalDate;
import java.util.Scanner;

import gestione.Biblioteca.DatiLibro;

public class BibliotecaTester {
	/**
	 * Metodo main per eseguire il programma della biblioteca.
	 * 
	 * @param args Gli argomenti della riga di comando.
	 */
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		Biblioteca.caricaLibriDaFile("databaseBiblioteca.txt");
		System.out.println("-------------------------");

		Scanner scanner = new Scanner(System.in);
		int scelta = 0;
		do {
			System.out.println("****MENU' BIBILIOTECA****");
			System.out.println("-------------------------");
			System.out.println("1- Aggiungi un libro");
			System.out.println("2- Modifica un libro");
			System.out.println("3- Rimuovi un libro");
			System.out.println("4- Visualizza un libro");
			System.out.println("ALTRIMENTI INSERISCI QUALSIASI NUMERO PER USCIRE");
			System.out.println("-------------------------");

			scelta = scanner.nextInt();
			scanner.nextLine();

			if (scanner.hasNextInt()) {
				scelta = scanner.nextInt();
				scanner.nextLine();
				switch (scelta) {
				case 1:
					System.out.println("-------------------------");
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
					LocalDate data1 = biblioteca.dateInput(data);
					System.out.println("-------------------------");
					Libro libro = new Libro(titolo, autore, editore, pagine, ISBN, prezzo, data1);
					biblioteca.aggiungiLibro(libro);
					Biblioteca.salvaLibriInFile(Biblioteca.libri);
					break;

				case 2:
					int i = 0;
					System.out.println("-------------------------");
					System.out.println("Scegli il libro da modificare inserendo il numero:");
					System.out.println("-------------------------");

					while (i < Biblioteca.libri.length) {
						if (Biblioteca.libri[i] != null)
							System.out.println((i + 1) + "- Titolo=" + Biblioteca.libri[i].getTitolo());
						i++;
					}

					int modifica = scanner.nextInt();
					biblioteca.modificaLibro(modifica);
					Biblioteca.salvaLibriInFile(Biblioteca.libri);
					break;
					
				case 3:
					System.out.println("-------------------------");
					biblioteca.rimozioneLibro();
					Biblioteca.salvaLibriInFile(Biblioteca.libri);
					break;

				case 4:
					DatiLibro[] dati = DatiLibro.values();
					System.out.println("-------------------------");
					System.out.println("In base a cosa vuoi visualizzare i libri?");
					System.out.println("-------------------------");

					for (int j = 0; j < DatiLibro.values().length; j++)
						System.out.println((j + 1) + "-" + dati[j].name());

					int sceltaLibro = scanner.nextInt();
					biblioteca.ricercaLibro(sceltaLibro);
				}
			}			

		} while (scelta < 5 && scelta > 0);

	}
}
