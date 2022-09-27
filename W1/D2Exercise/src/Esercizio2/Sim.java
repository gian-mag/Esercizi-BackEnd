package Esercizio2;

public class Sim {

	public static void main(String[] args) {
		CartaSim sim1 = new CartaSim("0123456789", 20);
		
		sim1.showCall("987654321", 10);
	}
	
}

class CartaSim {

	String numeroTelefono;
	double credito;
	Telefono minutiChiamata;
	
	CartaSim(String numero, double _credito ) {
		numeroTelefono = numero;
		credito = _credito;
		getDati();
	}
	
	public void getDati() {
		System.out.println("I dati della mia Sim sono: " + numeroTelefono + " con un credito di: " + credito);
	}
	
	public void showCall(String __numero, int _durata) {
		Telefono minutiChiamata = new Telefono(__numero, _durata);
		System.out.println("Chiamata effettuata al numero: " + minutiChiamata.numero + " di minuti: " + minutiChiamata.durata);
	}
}

class Telefono {
	
	String numero;
	int durata;
	
	Telefono(String _numero, int _durata) {
		numero = _numero;
		durata  = _durata;
	}	
}