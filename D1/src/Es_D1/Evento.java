package Es_D1;

import javax.persistence.Entity;
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

	public Evento() {
	};

	public Evento(int _id, String _titolo, String _dataEvento, String _descrizione, String _tipoEvento,
			int _numeroMassimoPartecipanti) {
		super();
		id = _id;
		titolo = _titolo;
		dataEvento = _dataEvento;
		descrizione = _descrizione;
		tipoEvento = _tipoEvento;
		numeroMassimoPartecipanti = _numeroMassimoPartecipanti;
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
