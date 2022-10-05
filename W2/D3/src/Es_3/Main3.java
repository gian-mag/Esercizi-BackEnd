package Es_3;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		RegistroPresenze registro = new RegistroPresenze();

		do {
			System.out.println("Ecco l'elenco delle presenze");
			System.out.println(registro.getPresenze());

			System.out.println("Aggiungi una presenza");

			try {
				System.out.println("Nome: ");
				String nome = scanner.nextLine();
				System.out.println("Numero presenze: ");
				int numero = scanner.nextInt();
				registro.addPresenze(nome, numero);
				scanner.nextLine();

			} catch (Exception e) {
				System.out.println("ops, qualcosa è andato storto");
				scanner.nextLine();
			}
		} while (loop);

		scanner.close();
	}
}