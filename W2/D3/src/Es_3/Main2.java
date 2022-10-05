package Es_3;

public class Main2 {

	public static void main(String[] args) throws InterruptedException {

		int[] list = new int[3000];
		int[] list1 = new int[1000];
		int[] list2 = new int[1000];
		int[] list3 = new int[1000];

		for (int i = 0; i < list.length; i++) {
			list[i] = (int) Math.floor(Math.random() * 10 + 1);
		}

		for (int i = 0; i < list1.length; i++) {
			list1[i] = list[i];
		}
		for (int i = 0; i < list2.length; i++) {
			list2[i] = list[i + 1000];
		}
		for (int i = 0; i < list3.length; i++) {
			list3[i] = list[i + 2000];
		}

		ArrSom1 s1 = new ArrSom1(list1);
		ArrSom1 s2 = new ArrSom1(list2);
		ArrSom1 s3 = new ArrSom1(list3);

		s1.start();
		s1.join();
		s2.start();
		s2.join();
		s3.start();
		s3.join();

		System.out.println(s1.somma + s2.somma + s3.somma);

	}
}
