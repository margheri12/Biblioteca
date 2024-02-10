package gestione;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * La classe Biblioteca rappresenta un gestore di libri con funzionalità di aggiunta, modifica, rimozione e ricerca.
 * I libri vengono gestiti attraverso un array di oggetti Libro.
 */
public class Biblioteca {

    public static Libro[] libri;
    public enum DatiLibro {Titolo, Autore, Editore, Numero_Pagine, Codice_ISBN, Prezzo, Data_Pubblicazione};

    /**
     * Costruttore della classe Biblioteca.
     * Inizializza l'array di libri con una dimensione predefinita di 50.
     */
    public Biblioteca() {
        this.libri = new Libro[50];
    }

    /**
     * Aggiunge un libro all'array di libri della biblioteca.
     * @param libro Il libro da aggiungere.
     */
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

    /**
     * Modifica un libro dell'array di libri in base all'input dell'utente.
     * @param numLibro Indice del libro da modificare.
     */
    public void modificaLibro(int numLibro) {
        Scanner scanner = new Scanner(System.in);
        int scelta;
        String modifica;
        DatiLibro[] dati = DatiLibro.values(); 
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
                double prezzo = scanner.nextDouble();
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
        scanner.close();
    }

    /**
     * Rimuove un libro dall'array di libri in base all'input dell'utente.
     */
    public void rimozioneLibro() {
        System.out.println("Inserire libro da rimuovere");
        int i=0;
        while(libri[i] != null){
            System.out.println((i+1)+ "- " + libri[i].stampaLibro());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int rimuovi = scanner.nextInt();
        libri[rimuovi-1] = null;
        scanner.close();
    }

    /**
     * Ricerca libri nell'array in base alla scelta specificata dall'utente.
     * @param scelta Tipo di ricerca (1: titolo, 2: autore, ..., 7: data di pubblicazione).
     */
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
                        System.out.println((i+1) + "-" + libri[i].stampaLibro());
                }
                break;
            case 2:
                System.out.println("Inserire autore da cercare:");
                ricercaString = scanner.nextLine();
                for(int i = 0; i<libri.length;i++) {
                    if(libri[i] != null && libri[i].getAutore().equals(ricercaString))
                        System.out.println((i+1) + "-" + libri[i].stampaLibro());
                }
                break;
            case 3:
                System.out.println("Inserire editore da cercare:");
                ricercaString = scanner.nextLine();
                for(int i = 0; i<libri.length;i++) {
                    if(libri[i] != null && libri[i].getAutore().equals(ricercaString))
                        System.out.println((i+1) + "-" + libri[i].stampaLibro());
                }
                break;
            case 4:
                System.out.println("Inserire numero pagine da cercare:");
                ricercaInt = scanner.nextInt();
                for(int i = 0; i<libri.length;i++) {
                    if(libri[i] != null && libri[i].getNumPagine() == ricercaInt)
                        System.out.println((i+1) + "-" + libri[i].stampaLibro());
                }
                break;
            case 5:
                System.out.println("Inserire codice ISBN da cercare:");
                ricercaInt = scanner.nextInt();
                for(int i = 0; i<libri.length;i++) {
                    if(libri[i] != null && libri[i].getCodISBN() == ricercaInt)
                        System.out.println((i+1) + "-" + libri[i].stampaLibro());
                }
                break;
            case 6:
                System.out.println("Inserire prezzo da cercare:");
                double ricerca = scanner.nextDouble();
                for(int i = 0; i<libri.length;i++) {
                    if(libri[i] != null && libri[i].getPrezzo() == ricerca)
                        System.out.println((i+1) + "-" + libri[i].stampaLibro());
                }
                break;
            case 7:
                System.out.println("Inserire data di pubblicazione da cercare:  (formato AAAA-MM-GG)");
                String data = scanner.nextLine();
                LocalDate data1 = dateInput(data);
                for(int i = 0; i<libri.length;i++) {
                    if(libri[i] != null && libri[i].getDataPubblicazione().equals(data1))
                        System.out.println((i+1) + "-" + libri[i].stampaLibro());
                }
                break;
                
        }
        scanner.close();
    }

    /**
     * Converte una stringa nel formato "AAAA-MM-GG" in un oggetto LocalDate.
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
     * @param libri L'array di libri da salvare.
     */
    public static void salvaLibriInFile(Libro[] libri) {
        String percorsoFile = "databaseBiblioteca.txt"; 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(percorsoFile, false))) {
            if (libri != null && libri.length > 0) {
                writer.write("TITOLO/AUTORE/EDITORE/NUMPAGINE/CODISBN/PREZZO/DATAPUBBLICAZIONE");
                writer.newLine();
            }

            for (Libro libro : libri) {
                if (libro != null) {
                    writer.write(libro.toString());
                    writer.newLine();
                }
            }
            System.out.println("Libri salvati con successo nel file.");
        }
        catch(IOException e) {   	
            System.err.println("Errore durante la scrittura nel file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Carica libri da un file specifico nell'array della biblioteca.
     * @param percorsoFile Il percorso del file da cui caricare i libri.
     */
    public static void caricaLibriDaFile(String percorsoFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(percorsoFile))) {
            String intestazione = reader.readLine();
            String linea;
            int indiceLibro = 0;
            linea = reader.readLine();

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
