package Es_3;

public class ArrSom1 extends Thread {
	private int[] arr;
	public int somma;

	public ArrSom1(int[] _arr) {
		arr = _arr;
	}

	public void run() {

		for (int i = 0; i < arr.length; i++) {
			somma += arr[i];
			System.out.println(somma);
		}

		System.out.println("somma finita: " + somma);

	}

}

	