package Es_D1;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Es_2 {

	private static final Logger logger = LoggerFactory.getLogger(Es_2.class);

	static int kmTot, litro;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean flag = true;

		while (flag) {
			System.out.println("Quanti km hai percorso oggi?");
			try {
				kmTot = Integer.parseInt(scanner.nextLine());
				if (kmTot != 0) {
					System.out.println("Quanti litri de benza c'hai messo?");

					litro = Integer.parseInt(scanner.nextLine());
					if (litro == 0) {
						logger.error("Senza benza non parte");
					} else {
						System.out.println("Hai consumato " + getKmPerLitro(kmTot, litro) + "km per litro oggi");
						flag = false;
					}
				} else {
					logger.error("Bro oggi hai risparmiato 5 euro per litro di benzina");
				}

			} catch (Exception e) {
				logger.error("Errore: stai passando una stringa invece di un numero. " + e.getMessage());
			}

		}

		scanner.close();

	}

	public static int getKmPerLitro(int _km, int _litro) {
		int kmPerLitro = _km / _litro;
		return kmPerLitro;
	}

}
