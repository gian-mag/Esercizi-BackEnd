package Main;

import static ComponenteDipendente.Dipartimento.VENDITE;
import static ComponenteDipendente.Livello.OPERAIO;

import ComponenteDipendente.Dipendente;

public class Main {

	public static void main(String[] args) {
		Dipendente a = new Dipendente(1, "Gionata", OPERAIO, VENDITE );
		a.getInfo();
		a.promotion();
		a.getInfo();
		a.promotion();

		stipendioDelDipendente(a);
		stipendioDelDipendenteConStraordinari(a, 20);
	}

	public static void stipendioDelDipendente(Dipendente dip) {
		dip.stipendioDelDipendente();
	}
	
	public static void stipendioDelDipendenteConStraordinari(Dipendente dip, int ore) {
		dip.setStipendioConStraordinario(ore);
	}
	
}
