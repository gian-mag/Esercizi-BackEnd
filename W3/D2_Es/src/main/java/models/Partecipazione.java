package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private int id;

	@ManyToOne
	private Persona persona;

	@ManyToOne
	private Evento evento;

	@Enumerated(EnumType.STRING)
	private Stato stato;

	public Partecipazione() {

	}

	public Partecipazione(Persona _persona, Evento _evento, Stato _stato) {
		stato = _stato;
		evento = _evento;
		stato = _stato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}


}
