package Esercizio1;

public class Esercizio3 {

public static void main(String[] args) {
		
		System.out.println(perimetroRettangolo(10, 4));
		
		System.out.println(pariDispari(5));
		
		System.out.println(areaTriangolo(10, 10, 3));
		
	}

public static double perimetroRettangolo(double latoA, double latoB) {
	return (latoA + latoB)*2;
}

public static String pariDispari(int numero1) {

	if(numero1 % 2 == 0) {
		return "pari";
	} else {
		return "dispari";
	}
}

public static double areaTriangolo(double latoA, double latoB, double latoC) {
	double pT = (latoA + latoB + latoC)/2;
	return Math.sqrt(pT*(pT - latoA)*(pT - latoB)*(pT - latoC));
}

}
