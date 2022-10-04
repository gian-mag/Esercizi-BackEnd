package Es_D2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Es2_D1 {

	public static void main(String[] args) {

		ArrayList<Integer> Myarr = genarr();

		dublerevarr(Myarr);

		pariordispari(Myarr, true);

	}

	public static ArrayList<Integer> genarr() {
		Scanner input = new Scanner(System.in);
		boolean loop = false;
		int length = 0;

		System.out.println("Di quanti elemeti deve essere l'array?");

		do {
			try {

				loop = false;

				length = input.nextInt();

			} catch (InputMismatchException e) {
				input.next();
				System.out.println("Eroore");
				loop = true;
			}
		} while (loop);

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			list.add((int) (Math.floor(Math.random() * 100 + 1)));
		}
		input.close();
		return list;
	}

	public static void dublerevarr(ArrayList<Integer> list) {
		ArrayList<String> arr = new ArrayList<>();
		int j = list.size();

		for (int i = 0; i < list.size(); i++) {

			arr.add(list.get(i) + "-" + list.get(j - 1));

			j--;
		}

		System.out.println(arr);

	}

	public static void pariordispari(ArrayList<Integer> list, boolean bool) {
		System.out.println(list);
		if (bool) {
			for (int i = 0; i < list.size(); i++) {
				if (i % 2 == 0) {
					System.out.println("pari " + list.get(i));
				}
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (i % 2 != 0) {
					System.out.println("dispari " + list.get(i));
				}
			}
		}
	}

}
