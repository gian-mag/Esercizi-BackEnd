package Esercizio1;

import java.util.Arrays;

public class Esercizio1 {
	
	public static void main(String[] args) {
		
		
		
		System.out.println(moltiplica(10,5));
		
		System.out.println(concat("Ciao Epicode sono il numero ",1));
		
		
		int n = 5;
        int[] myArray = {
            1,2,3,5,6
        };
        int x = 4;
        int pos = 4;
        myArray =inserisciInArray(myArray, x, n, pos);
        
        System.out.println("\nArray con " + x + " inserito alla posizione " + pos + ":\n" + Arrays.toString(myArray));
		
	}

	
	public static int moltiplica(int n1, int n2) {
		
		return n1 * n2;
		
	}
	
	public static String concat(String stringa, int intero) {
		
		return stringa + intero;
		
	}

	public static int[] inserisciInArray(int[] myArray, int x,
            int n, int pos) {
		int i;
		int newarr[] = new int[n + 1];

		for (i = 0; i < n + 1; i++) {
			if (i < pos - 1)
				newarr[i] = myArray[i];
			else if (i == pos - 1)
				newarr[i] = x;
			else
				newarr[i] = myArray[i - 1];
		}
return newarr;

};
}
