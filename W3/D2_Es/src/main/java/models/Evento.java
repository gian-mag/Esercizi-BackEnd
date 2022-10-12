package models;

import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "evento")
public class Evento {

	@Id
	private int id;

	private String titolo;

	@Column(name="dataevento")
	private String dataEvento;

	private String descrizione;

	@Column(name="tipoevento")
	private String tipoEvento;

	@Column(name="numeromassimopartecipanti")
	private int numeroMassimoPartecipanti;
	
	@OneToMany(mappedBy="evento", cascade = CascadeType.REMOVE)
	private Set<Partecipazione> partecipazioni;
	
	@ManyToOne
	private Location location;

	public Set<Partecipazione> getPartecipazioni() {
		return partecipazioni;
	}

	public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
		this.partecipazioni = partecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Evento() {
	};

	public Evento(String _titolo, String _dataEvento, String _descrizione, String _tipoEvento,
			int _numeroMassimoPartecipanti, Set<Partecipazione> _partecipazioni, Location _location) {
		titolo = _titolo;
		dataEvento = _dataEvento;
		descrizione = _descrizione;
		tipoEvento = _tipoEvento;
		numeroMassimoPartecipanti = _numeroMassimoPartecipanti;
		partecipazioni = _partecipazioni;
		location = _location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	@Override
	public String toString() {

		return titolo + " " + dataEvento + " " + descrizione + " " + tipoEvento + " " + numeroMassimoPartecipanti;
	}

}
