package EsercizioD5;

public abstract class Multimedia {

	protected String titolo;
	
	protected int durata;
	
	public Multimedia(String _titolo) {
		titolo = _titolo;
	}
	
	public Multimedia(String _titolo, int _durata) {
		titolo = _titolo;
		durata = _durata;
	}
	
	protected void play() {
		
	};
	
	public String getTitolo() {
        return titolo;
    }
	
	public int getDurata() {
        return durata;
    }
}
