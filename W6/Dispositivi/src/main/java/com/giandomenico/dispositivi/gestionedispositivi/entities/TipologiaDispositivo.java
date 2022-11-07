package com.giandomenico.dispositivi.gestionedispositivi.entities;

public enum TipologiaDispositivo {

	SMARTPHONE, TABLET, LAPTOP;

	@Override
	public String toString() {
		return this.name();
	}
}
