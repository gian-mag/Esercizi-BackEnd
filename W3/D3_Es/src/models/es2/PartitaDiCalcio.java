package models.es2;

import javax.persistence.Entity;

import it.epicode.be.gestioneventi.model.Evento;

@Entity
public class PartitaDiCalcio extends Evento {

	private String squadraDiCasa;

	private String squadraOspite;

	private String squadraVincente;

	private int numGolSqCs;

	private int numGolSqOs;

	public PartitaDiCalcio() {
	}

	public PartitaDiCalcio(String squadraDiCasa, String squadraOspite, String squadraVincente, int numGolSqCs,
			int numGolSqOs) {
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.numGolSqCs = numGolSqCs;
		this.numGolSqOs = numGolSqOs;
	}

	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public int getNumGolSqCs() {
		return numGolSqCs;
	}

	public void setNumGolSqCs(int numGolSqCs) {
		this.numGolSqCs = numGolSqCs;
	}

	public int getNumGolSqOs() {
		return numGolSqOs;
	}

	public void setNumGolSqOs(int numGolSqOs) {
		this.numGolSqOs = numGolSqOs;
	}

}
