package Es_D1;

public class Banca {

	public static void main(String args[]) {
		ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

		System.out.println("Saldo conto: " + conto1.restituisciSaldo());

		try {
			conto1.preleva(1000750.5);

			System.out.println("Saldo conto: " + conto1.restituisciSaldo());
		} catch (Exception e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}

		ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 50350.0, 1500);

		conto2.stampaSaldo();

		try {
			conto2.preleva(2000);

			conto2.stampaSaldo();

		} catch (Exception e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}
	}
}
