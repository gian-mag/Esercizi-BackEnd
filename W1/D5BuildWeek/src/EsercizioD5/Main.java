package EsercizioD5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * Immagine i = new Immagine("Ciccio", 1);
		 * 
		 * i.show(); i.aumentaLuminosità(5); i.show(); i.abbassaLuminosità(2); i.show();
		 * i.abbassaLuminosità(3);
		 * 
		 * Audio a = new Audio("Cocci", 5, 7);
		 * 
		 * a.play(); a.alzaVolume(6); a.play();
		 * 
		 * Video v = new Video("Ciccu", 5, 6, 1);
		 * 
		 * v.play(); v.abbassaVolume(4); v.aumentaLuminosità(2); v.play();
		 * 
		 */

		int tipoDiMedia;

		Multimedia[] file = new Multimedia[5];

		Scanner scanner = new Scanner(System.in);

		System.out.println("---Lettore Multimediale---");
		System.out.println("Si riempie il lettore con 5 file multimediali \n");

		for (int i = 1; i <= 5; i++) {
			// uso una flag per il while
			boolean check = true;

			while (check) {
				System.out.println(
						"Che tipologia di file multimediale vuoi inserire?\n 0) Per uscire \n 1) Immagine\n 2) Audio\n 3) Video\n ");
				System.out.println("File multimediale numero: " + i + "\n" + "\nFile di tipo:");
				tipoDiMedia = Integer.parseInt(scanner.nextLine());
				
				
				String titolo;
				int durata, luminosità, volume;

				switch (tipoDiMedia) {
				case 0: 
					System.out.println("Sei uscito");
					check = false;
					i = 5;
					break;
				case 1:
					System.out.println("Titolo dell'immagine");
					titolo = scanner.nextLine();
					System.out.println("Imposta la luminosità");
					luminosità = Integer.parseInt(scanner.nextLine());
					file[i] = new Immagine(titolo, luminosità);
					check = false;
					break;

				case 2:
					System.out.println("Titolo dell'Audio. ");
					titolo = scanner.nextLine();
					System.out.println("Durata dell'Audio " + titolo);
					durata = Integer.parseInt(scanner.nextLine());
					System.out.println("Imposta il volume");
					volume = Integer.parseInt(scanner.nextLine());
					file[i] = new Audio(titolo, volume, durata);
					check = false;
					break;

				case 3:

					System.out.println("Titolo Video. ");
					titolo = scanner.nextLine();
					System.out.println("Durata Video " + titolo + ".");
					durata = Integer.parseInt(scanner.nextLine());
					System.out.println("Imposta il volume");
					volume = Integer.parseInt(scanner.nextLine());
					System.out.println("Imposta la luminosità");
					luminosità = Integer.parseInt(scanner.nextLine());
					file[i] = new Video(titolo, volume, durata, luminosità);
					check = false;
					break;

				default:
					System.out.println("Scegli un numero valido!");
					break;

				}

			}

		}
		System.out.println("Hai finito gli elementi da inserire!");
		scanner.close();
	}

}
