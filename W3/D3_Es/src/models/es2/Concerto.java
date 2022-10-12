package models.es2;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import it.epicode.be.gestioneventi.model.Evento;
import it.epicode.be.gestioneventi.model.Genere;

@Entity
public class Concerto extends Evento {

	private boolean inStreaming;

	@Enumerated(EnumType.STRING)
	private Genere genere;

	public Concerto() {

	}

	public Concerto(boolean inStreaming, Genere genere) {
		this.inStreaming = inStreaming;
		this.genere = genere;
	}

	public boolean isInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	
	public String toString() {
		return String.format("Concerto di tipo : %s è in streaming adesso! %n", genere);
	}

}
