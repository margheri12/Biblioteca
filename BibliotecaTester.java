package gestione;

import java.time.LocalDate;
import java.util.Scanner;

public class BibliotecaTester {
	/**
	 * Metodo main per eseguire il programma della biblioteca.
	 * 
	 * @param args Gli argomenti della riga di comando.
	 */
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.caricaLibriDaFile();
		Scanner scanner = new Scanner(System.in);
		int scelta = 0;
		do {
			System.out.println("-------------------------");
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
				biblioteca.salvaLibriInFile();
				break;

			case 2:
				System.out.println("-------------------------");
				biblioteca.modificaLibro();
				break;

			case 3:
				System.out.println("-------------------------");
				biblioteca.rimozioneLibro();
				break;

			case 4:
				biblioteca.ricercaLibro();
			}
		} while (scelta < 5 && scelta > 0);
	}
}