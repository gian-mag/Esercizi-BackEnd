package models.es2;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import it.epicode.be.gestioneventi.model.*;


@Entity
public class GaraDiAtletica extends Evento {

	@ManyToMany
	private Set<Persona> persone;

	@ManyToOne
	private Persona vincitore;

	public GaraDiAtletica() {
	};

	public GaraDiAtletica(Set<Persona> persone, Persona vincitore) {
		this.persone = persone;
		this.vincitore = vincitore;
	}

	public Set<Persona> getPersone() {
		return persone;
	}

	public void setPersone(Set<Persona> persone) {
		this.persone = persone;
	}

	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}

}
