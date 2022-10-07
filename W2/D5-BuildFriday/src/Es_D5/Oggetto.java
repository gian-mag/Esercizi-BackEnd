package Es_D5;

public abstract class Oggetto {

	protected Long CodiceISBN;
	private String Titolo;
	private Integer AnnoPubblicazione;
	private Integer NumeroPagine;
	static Long instances = (long)1;
		
	public Oggetto(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
		this.CodiceISBN = instances;
		instances++;
		setTitolo(titolo);
		AnnoPubblicazione = annoPubblicazione;	
		setNumeroPagine(numeroPagine);
	}
	
	public Long getCodiceISBN() {
		return CodiceISBN;
	}
//
//	public void setCodiceISBN(Long codiceISBN) {
//		CodiceISBN = codiceISBN;
//	}

	public String getTitolo() {
		return Titolo;
	}

	public void setTitolo(String titolo) {
		Titolo = titolo;
	}

	public Integer getAnnoPubblicazione() {
		return AnnoPubblicazione;
	}

//	public void setAnnoPubblicazione(Integer annoPubblicazione) {
//		AnnoPubblicazione = annoPubblicazione;
//	}

	public Integer getNumeroPagine() {
		return NumeroPagine;
	}

	public void setNumeroPagine(Integer numeroPagine) {
		NumeroPagine = numeroPagine;
	}
	
	@Override
	public String toString() {
		return  "CodiceISBN: " + getCodiceISBN() + ", Titolo: " + getTitolo() + ", Anno di pubblicazione: "
				+ getAnnoPubblicazione() + ", Numero di pagine: " + getNumeroPagine();
				
	}
	
}
