package Es_D1;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Es_1 {

	private static final Logger logger = LoggerFactory.getLogger(Es_1.class);

	public static void main(String[] args) {

		int[] arr = new int[] { randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber() };

		System.out.println(Arrays.toString(arr));

		Scanner scanner = new Scanner(System.in);

		boolean flag = true;

		while (flag) {
			System.out.println("A che posizione vuoi aggiungere un elemento?");
			try {
				int posizione = Integer.parseInt(scanner.nextLine());
				if (posizione > arr.length - 1 || posizione < 0) {
					logger.error("Stai provando ad aggiungere elementi in posizioni non esistenti\n Riprova");
				} else {
					System.out.println("Alla posizione " + posizione + " che elemento vuoi aggiungere?");
					try {
						int elemento = Integer.parseInt(scanner.nextLine());
						if (elemento != 0) {
							System.out.println(
									"Stai aggiungendo l'elemento " + elemento + " alla posizione numero " + posizione);
							arr[posizione] = elemento;
							System.out.println(Arrays.toString(arr));
						} else {
							System.out.println("Stai uscendo dal ciclo");
							flag = false;
						}
					} catch (NumberFormatException e) {
						logger.error("Errore: stai passando una stringa invece di un numero. " + e.getMessage());
					}
				}

			} catch (Exception e) {
				logger.error("Errore: stai passando una stringa invece di un numero. " + e.getMessage());
			}

		}

		scanner.close();
	}

	public static int randomNumber() {
		int max = 10;
		int min = 1;
		int range = max - min + 1;
		int number = (int) (Math.random() * range) + min;
		return number;
	}

}
