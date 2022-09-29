package ComponenteDipendente;
import static ComponenteDipendente.Livello.*;
import static ComponenteDipendente.Dipartimento.*;

public class Dipendente {
	

	private static double stipendioBase = 1000;
	
	private static double stipendio;

	private static int matricola;

	private static String nome;

	private int importoOrarioStraordinario;

	private static Livello Livello;

	private static Dipartimento Dipartimento;

	public Dipendente(int _matricola, Dipartimento _Dipartimento) {
		stipendio = stipendioBase;
		importoOrarioStraordinario = 30;
		Livello = OPERAIO;
	}
	
	public Dipendente(int _matricola, String _nome, Livello _livello, Dipartimento _Dipartimento) {
		matricola = _matricola;
		nome = _nome;
		importoOrarioStraordinario = 30;
		Livello = _livello;
		Dipartimento = _Dipartimento;
		stipendio = setStipendio();
	}
	
	private double setStipendio() {
		
		if(Livello == IMPIEGATO) {
			stipendio = stipendioBase*1.2;
		} else if(Livello == QUADRO) {
			stipendio = stipendioBase*1.5;
		} else if(Livello == DIRIGENTE) {
			stipendio = stipendioBase*2;
		} else {
			stipendio = stipendioBase*1.2;
		}
		return stipendio;
	}

	public void getInfo() {
		System.out.println("Dipende " + nome + ", " + "numero matricola " + matricola + " del dipartimento: " + Dipartimento + ".\n" + "Ha un CCLN di livello " + Livello + " e percepisce: " + stipendio +" euro mensili.");
	
	}
	
	public void promotion(){
        if(Livello == DIRIGENTE){
            System.out.println("avidoooo");
        } else if (Livello == QUADRO) {
            Livello = DIRIGENTE;
        }else if (Livello == IMPIEGATO) {
            Livello = QUADRO;
        }else {Livello = IMPIEGATO;}

        setStipendio();
    }
	
	public void stipendioDelDipendente() {
		System.out.println("Lo stipendio è di: " + stipendio);
	}
	
	public void setStipendioConStraordinario(int ore) {
		double stipendioTotale;
		stipendioTotale = stipendio + importoOrarioStraordinario*ore;
		
		System.out.println("Lo stipendio è di: " + stipendioTotale + " al netto di straordinari.");
	}
	
}
