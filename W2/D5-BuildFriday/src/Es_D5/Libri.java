package Es_D5;

public class Libri extends Oggetto{

	String Nome;
	Generi Genere;
	
	public Libri(String titolo, Integer annoPubblicazione, Integer numeroPagine, String nome, Generi genere) {
		super(titolo, annoPubblicazione, numeroPagine);
//		setNome(nome);
		Nome = nome;
		setGenere(genere);
	}

	public String getNome() {
		return Nome;
	}

//	public void setNome(String nome) {
//		this.Nome = nome;
//	}

	public Generi getGenere() {
		return Genere;
	}

	public void setGenere(Generi genere) {
		this.Genere = genere;
	}
	
	@Override
	public String toString() {
		return "Libro = { Autore: " + getNome() + ", Genere: " + getGenere() + " " + super.toString() + " }";
	}
	
}
