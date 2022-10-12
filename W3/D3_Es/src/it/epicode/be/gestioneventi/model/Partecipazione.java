package it.epicode.be.gestioneventi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Partecipazione {

	@Id
	@SequenceGenerator(name = "partecipazione_seq", sequenceName = "partecipazione_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partecipazione_seq")
	private Long id;

	@ManyToOne
	private Persona persona;

	@ManyToOne
	private Evento evento;

	@Enumerated(EnumType.STRING)
	private StatoPartecipazione stato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public StatoPartecipazione getStato() {
		return stato;
	}

	public void setStato(StatoPartecipazione stato) {
		this.stato = stato;
	}
}
