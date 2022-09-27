package Esercizio3;

public class Carrello {

	public static void main(String[] args) {
		Clientello c1 = new Clientello("0123124", "mario", "flavio", "test@test.it", "05/07/2011");
		Articolino a1 = new Articolino("001", "uanm", 20, 5);
		Carrellino car1 = new Carrellino(c1, new Articolino[] {a1, a1, a1, a1});
	}
	
}

class Carrellino {
	String codice;
	int articoliTot;
	double costoTot;

	Carrellino( Clientello _codice, Articolino[] _articoli) {
		// codice = new Clientello("0123124", "mario", "flavio", "test@test.it", "05/07/2011");
		codice = _codice.codiceCliente;
		getArticoli(_articoli);
	}
	
	public void getArticoli( Articolino[] articoli) {
		//articoliTot = new Articolino("001", "uanm", 20, 5);
		articoliTot = articoli.length;
		
		for(Articolino s : articoli) {
			costoTot += s.prezzo;
		}
		System.out.println("Il costo totale degli articoli è: " + costoTot);
	}
	
}

class Articolino {
	public String codiceArticolo;
	public String descrizioneArticolo;
	public double prezzo;
	static int disponibili;

	Articolino(String _codiceArticolo, String _descrizioneArticolo, double _prezzo, int _disponibili) {
		codiceArticolo = _codiceArticolo;
		descrizioneArticolo = _descrizioneArticolo;
		prezzo = _prezzo;
		disponibili = _disponibili;
	}

}

class Clientello {
	public String codiceCliente;
	private String nome;
	private String cognome;
	private String email;
	private String data;

	Clientello(String _codiceCliente, String _nome, String _cognome, String _email, String string) {
		codiceCliente = _codiceCliente;
		nome = _nome;
		cognome = _cognome;
		email = _email;
		data = string;
	}
}
