package Es_D5;

public class Riviste extends Oggetto{
	
	Periodicità Periodicità;

	public Riviste(String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicità periodicità) {
		super(titolo, annoPubblicazione, numeroPagine);
		setPeriodicità(periodicità);
	}

	public Periodicità getPeriodicità() {
		return Periodicità;
	}

	public void setPeriodicità(Periodicità periodicità) {
		Periodicità = periodicità;
	}
	
	
	@Override
	public String toString() {
		return "Rivista = { Periodicità: " + getPeriodicità() + " " + super.toString() + " }";
	}
	
}
