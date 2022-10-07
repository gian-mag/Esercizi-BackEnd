package Es_D5;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

	private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

	static List<Oggetto> oList = new ArrayList<Oggetto>();

	static Periodicità periodicità;

	static Generi generi;

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean flag = true;

		System.out.println("Benvenuto nell'Archivio Comunale di Canicattì\n");

		while (flag) {

			try {
				System.out.println("----Scegli le operazioni da eseguire: ----\n ");
				System.out.println(
						"Premi: \n 0) Per uscire \n 1) Aggiungi una pubblicazione\n 2) Rimuovi pubblicazione\n 3) Ricerca una pubblicazione\n 4) Salva pubblicazione nell'archivio\n 5) Stampa pubblicazioni dall'archivio\n ");
				Integer opzione = Integer.parseInt(scanner.nextLine());
				System.out.println("Hai scelto l'opzione: " + opzione + "\n");

				switch (opzione) {

				case 0:
					System.out.println("Sei uscito dall'archivio!");
					flag = false;
					break;

				case 1:
					System.out.println("----Cosa vuoi pubblicare? ----\n ");
					System.out.println(
							"Premi: \n 1) Aggiungi un nuovo libro\n 2) Aggiungi una nuova rivista\n");
					int tipoDiPubblicazione = Integer.parseInt(scanner.nextLine());

					addPubblicazione(tipoDiPubblicazione);

					break;

				case 2:
					try {
						System.out.println("----Che pubblicazione vuoi eliminare? ----\n ");
						System.out.println("Inserisci il Codice Univoco ISBN\n ");
						Long codiceISBN = (long) Integer.parseInt(scanner.nextLine());
						delPubblicazioni(codiceISBN);
						System.out.println("Pubblicazione rimossa dal database");
						System.out.println(oList.toString());
						Pubblicazione.setArchivio(oList);
					} catch (Exception e) {
						logger.error("Il libro non si trova nell'archivio");
					}

					break;

				case 3:
					System.out.println("----Stai cercando una pubblicazione? ----\n ");
					System.out.println(
							"Premi: \n 1) Ricerca per Codice Univoco IBSN\n 2) Ricerca per anno di pubblicazione\n 3) Ricerca per autore\n");
					int scegliTra = Integer.parseInt(scanner.nextLine());
					search(scegliTra);
					break;

				case 4:

					Pubblicazione.setArchivio(oList);

					break;

				case 5:

					Pubblicazione.getArchivioTxt();
					System.out.println(Pubblicazione.getArchivioTxt());

					break;

				default:
					System.out.println("Scegli un'opzione valida!");
					break;
				}

			} catch (NumberFormatException e) {
				logger.error("Non hai inserito un'opzione valida. Riprova!\n");
			}

		}

		scanner.close();

	}

	public static void addPubblicazione(int tipoDiPubblicazione) {

		switch (tipoDiPubblicazione) {
		case 1:

			try {
				System.out.println("---- Inserisci i dati del libro ----");
				System.out.println("---- Titolo ----");
				String titolo = scanner.nextLine();
				System.out.println("---- Anno di pubblicazione ----");
				Integer annoPubblicazione = Integer.parseInt(scanner.nextLine());
				System.out.println("---- Numero di pagine ----");
				Integer numeroPagine = Integer.parseInt(scanner.nextLine());
				System.out.println("---- Nome dell'autore ----");
				String nome = scanner.nextLine();
				System.out.println("---- Genere del libro ----");
				setGeneri();
				Oggetto obj = new Libri(titolo, annoPubblicazione, numeroPagine, nome, generi);
				oList.add(obj);
				
				System.out.println("Libro inserito con successo!");
				System.out.println(oList.toString());
				Pubblicazione.setArchivio(oList);
			} catch (Exception e) {
				logger.error("Hai inserito dei campi non validi");
			}

			break;
		case 2:

			try {
				System.out.println("---- Inserisci i dati della rivista ----");
				System.out.println("---- Titolo ----");
				String titolo = scanner.nextLine();
				System.out.println("---- Anno di pubblicazione ----");
				Integer annoPubblicazione = Integer.parseInt(scanner.nextLine());
				System.out.println("---- Numero di pagine ----");
				Integer numeroPagine = Integer.parseInt(scanner.nextLine());
				System.out.println("---- Periodicità ----");
				setPeriodicità();
				Oggetto obj = new Riviste(titolo, annoPubblicazione, numeroPagine, periodicità);
				oList.add(obj);
				System.out.println("Rivista inserita con successo!");
				System.out.println(oList.toString());
			} catch (Exception e) {
				logger.error("Hai inserito dei campi non validi");
			}

			break;
		}

	}

	public static void delPubblicazioni(Long codiceISBN) {

		Predicate<Oggetto> ISBN = oL -> oL.getCodiceISBN() != codiceISBN;

		List<Oggetto> index = oList.stream().filter(ISBN).collect(Collectors.toList());

		oList = index;

	}

	public static void search(Integer scegliTra) {
		switch (scegliTra) {
		case 1:
			try {
				System.out.println("----Stai cercando un libro? ----\n ");
				System.out.println("Inserisci il Codice Univoco ISBN\n ");
				Long codiceISBN = (long) Integer.parseInt(scanner.nextLine());
				searchForISBN(codiceISBN);
				System.out.println("Trovato");
				System.out.println(oList.toString());
			} catch (Exception e) {
				logger.error("Qualcosa è andato storto!");
			}
			break;
		case 2:
			try {
				System.out.println("----Stai cercando un libro? ----\n ");
				System.out.println("Inserisci anno di pubblicazione\n ");
				Integer annoPubblicazione = Integer.parseInt(scanner.nextLine());
				searchForPublishing(annoPubblicazione);
				System.out.println("Trovato");
				System.out.println(oList.toString());
			} catch (Exception e) {
				logger.error("Qualcosa è andato storto!");
			}
			break;
		case 3:
			try {
				System.out.println("----Stai cercando un libro? ----\n ");
				System.out.println("Inserisci Autore\n ");
				String autore = scanner.nextLine();
				searchForAuthor(autore);
				System.out.println("Trovato");
				System.out.println(oList.toString());
			} catch (Exception e) {
				logger.error("Qualcosa è andato storto!");
			}

			break;

		}
	}

	public static void searchForISBN(Long codiceISBN) {

		Predicate<Oggetto> ISBN = oL -> oL.getCodiceISBN() == codiceISBN;

		List<Oggetto> index = oList.stream().filter(ISBN).collect(Collectors.toList());

		System.out.println(index.toString());

	}

	public static void searchForPublishing(Integer annoPubblicazione) {

		Predicate<Oggetto> published = oL -> oL.getAnnoPubblicazione() == annoPubblicazione;

		List<Oggetto> oListStream = oList.stream().filter(published).collect(Collectors.toList());

		System.out.println(oListStream.toString());
	}

	public static void searchForAuthor(String autore) {


//		Predicate<Oggetto> searchBook = oL -> oL instanceof Libri;
//
//		Predicate<Libri> searchAuthor = oL -> oL.getNome() == autore;
		
//		Predicate<Libri> mappino = oL -> oL == (Libri) oL;

//		List<Libri> oListStreamAuthor = oList.stream().filter(searchBook).map(oL -> (Libri) oL).filter(searchAuthor).collect(Collectors.toList());
		
		List<Oggetto> oListStreamAuthor = oList.stream().filter(oL -> oL instanceof Libri).map(oL -> (Libri) oL).filter((oL -> oL.getNome() == autore)).collect(Collectors.toList());

		System.out.println(oListStreamAuthor.toString());
	}

	public static void setPeriodicità() {

		System.out.println("---- Scegli tra:  \n 1) SETTIMANALE \n 2) MENSILE \n 3) SEMESTRALE");
		int period = Integer.parseInt(scanner.nextLine());

		switch (period) {
		case 1:
			periodicità = Es_D5.Periodicità.SETTIMANALE;
			break;

		case 2:
			periodicità = Es_D5.Periodicità.MENSILE;
			break;

		case 3:
			periodicità = Es_D5.Periodicità.SEMESTRALE;
			break;
		}

	}

	public static void setGeneri() {

		System.out.println("---- Scegli tra:  \n 1) HORROR \n 2) FANTASY \n 3) GIALLO \n 4) POLIZIESCO");
		int period = Integer.parseInt(scanner.nextLine());

		switch (period) {
		case 1:
			generi = Es_D5.Generi.HORROR;
			break;

		case 2:
			generi = Es_D5.Generi.FANTASY;
			break;

		case 3:
			generi = Es_D5.Generi.GIALLO;
			break;

		case 4:
			generi = Es_D5.Generi.POLIZIESCO;
			break;
		}

	}

}
