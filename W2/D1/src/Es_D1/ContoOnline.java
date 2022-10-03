package Es_D1;

class ContoOnLine extends ContoCorrente {
	private double maxPrelievo;

	ContoOnLine(String titolare, double saldo, double maxP) {
		super(titolare, saldo);
		this.maxPrelievo = maxP;
	}

	public void stampaSaldo() {

		System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
				+ " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	}

	public void preleva(double x) throws BancaException {

		if (x <= maxPrelievo) {
			super.preleva(x);
		}
		if (x > maxPrelievo) {
			throw new BancaException("Il prelievo non è disponibile", maxPrelievo);
		}
	}
}