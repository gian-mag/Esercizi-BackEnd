package Es_D2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Es3_D1 {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> hmap = new HashMap<>();
		boolean flag = true;

		while (flag) {
			System.out.println(
					"Cosa vuoi fare nella rubrica?\n 0) Per uscire \n 1) Aggiungi contatto\n 2) Rimuovi contatto\n 3) Trova numero per nome\n 4) Trova contatto per numero\n 5) Mostra tutti i contatti\n ");
			int opzione = Integer.parseInt(scanner.nextLine());
			System.out.println("Hai scelto l'opzione: " + opzione + "\n");

			switch (opzione) {

			case 0:
				System.out.println("Sei uscito dalla rubrica");
				flag = false;
				break;

			case 1:
				System.out.println("Inserisci il nome di un nuovo contatto");
				try {
					String nome = scanner.nextLine();
					System.out.println("Inserisci il numero");
					Integer numero = Integer.parseInt(scanner.nextLine());
					addCoppiaValore(nome, numero, hmap);
					System.out.println("Hai aggiunto il contatto. ");
					for (@SuppressWarnings("rawtypes")
					Map.Entry mEntry : hmap.entrySet()) {
						System.out.print("Nome: " + mEntry.getKey() + " & Numero Telefonico: \n");
						System.out.println(mEntry.getValue() + "\n");
					}
				} catch (NumberFormatException e) {
					System.out.println("Il numero inserito non è valido. " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Il nome inserito non è valido. " + e.getMessage());
				}
				break;

			case 2:
				System.out.println("Rimuovi un contatto");
				try {
					System.out.println("Inserisci il nome del contatto che vuoi eliminare");
					String nome = scanner.nextLine();
					removeContatto(nome, hmap);
				} catch (Exception e) {
					System.out.println("Il nome inserito non è valido. " + e.getMessage());
				}
				break;

			case 3:
				System.out.println("Stai cercando il numero di un tuo contatto? Inserisci il nome");
				try {
					String nome = scanner.nextLine();
					trovaContatto(nome, hmap);
				} catch (Exception e) {
					System.out.println("Il nome inserito non è valido. " + e.getMessage());
				}
				break;

			case 4:
				System.out.println(
						"Stai cercando il numero di un tuo contatto ma non sai il suo nome? Inserisci il numero");
				try {
					Integer numero = Integer.parseInt(scanner.nextLine());
					findContattobynumber(numero, hmap);
				} catch (Exception e) {
					System.out.println("Il nome inserito non è valido. " + e.getMessage());
				}
				break;

			case 5:
				System.out.println("Questa è la tua lista di contatti");
				for (@SuppressWarnings("rawtypes")
				Map.Entry mEntry : hmap.entrySet()) {
					System.out.print("nome: " + mEntry.getKey() + " & numero: ");
					System.out.println(mEntry.getValue() + "\n");
				}
				break;

			default:
				System.out.println("Scegli un'opzione valida!");
				break;

			}

		}
		scanner.close();
	}

	public static void addCoppiaValore(String string, Integer numeroTel, HashMap<String, Integer> hM) {
		hM.put(string, numeroTel);
	}

	public static void removeContatto(String string, HashMap<String, Integer> hM) {
		if (hM.containsKey(string)) {
			hM.remove(string);
			System.out.println("Hai rimosso il contatto. ");
		} else {
			System.out.println("Non c'è il contatto!");
		}

	}

	public static void trovaContatto(String string, HashMap<String, Integer> hM) {
		if (hM.containsKey(string)) {
			int var = hM.get(string);
			System.out.println("Il numero di " + string + " è " + var);
		} else {
			System.out.println("Non c'è il contatto!");
		}

	}

	public static void findContattobynumber(int number, HashMap<String, Integer> hM) {

		if (hM.containsValue(number)) {
			Set entrySet = hM.entrySet();
			Iterator it = entrySet.iterator();
			while (it.hasNext()) {
				Map.Entry contatto = (Map.Entry) it.next();

				if (contatto.getValue().equals(number)) {
					System.out.println("Nome = " + contatto.getKey());
				}

			}
		} else {
			System.out.println("nessun contatto trovato");
		}

	}

}
