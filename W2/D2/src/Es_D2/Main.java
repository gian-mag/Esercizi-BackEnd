package Es_D2;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		HashSet<String> hSetDistinti = new HashSet<String>();
		HashSet<String> hSetDuplicati = new HashSet<String>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Che lunghezza vuoi che l'array abbia?");

		try {

			int length = Integer.parseInt(scanner.nextLine());

			if (length > 0 || length <= 10) {

				for (int i = 0; i < length; i++) {
					System.out.println("Scrivi la parola numero " + i);
					String word = scanner.nextLine();
					if (hSetDistinti.add(word)) {
						hSetDistinti.add(word);
						System.out.println("Parole distinte " + word);
					} else {
						hSetDuplicati.add(word);
						System.out.println("Parole duplicate " + word);
					}

				}
				System.out.println("Parole distinte: ");
				print(hSetDistinti);
				System.out.println("Parole duplicate: ");
				print(hSetDuplicati);
			}
		} catch (NumberFormatException e) {
			System.out.println("Tipo di dato sbagliato " + e.getMessage());
		}
		
		scanner.close();
	}

	public static void print(HashSet<String> s) {
		for (String s1 : s) {
			System.out.println(s1);
		}
	}

}
