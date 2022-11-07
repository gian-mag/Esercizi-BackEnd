package com.giandomenico.dispositivi.gestionedispositivi.entities;

public enum Assegnamento {

	DISPONIBILE,
	ASSEGNATO,
	IN_MANUTENZIONE,
	DISMESSO;

@Override
public String toString() {
	return this.name();
}
	
}