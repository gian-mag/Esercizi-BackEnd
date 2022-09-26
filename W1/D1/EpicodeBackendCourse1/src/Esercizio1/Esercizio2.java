package Esercizio1;

import java.util.Scanner;

public class Esercizio2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Scrivi 1 ");
		String scrivi1 = scanner.nextLine();
		
		System.out.println("Scrivi 2 " + scrivi1);
		String scrivi2 = scanner.nextLine();
		
		System.out.println("Scrivi 3 " + scrivi1 + scrivi2);
		String scrivi3 = scanner.nextLine();
		
		System.out.println("Scrivi 4 " + scrivi1 + scrivi2 + scrivi3);
		
		scanner.close();
		
	}
		
	
}
