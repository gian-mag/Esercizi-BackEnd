package Main;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.*;

public class Main {

	private static Persona persona1;

	public static void main(String[] args) {
		
		
		
		Location l = new Location("Bitte", "Segrate");
		
		LocationDAO.save(l);
		
		
		
		Evento e1 = new Evento();
		
		Partecipazione p1 = new Partecipazione(persona1, e1, Stato.CONFERMATA);
		persona1 = new Persona("Gianni", "Pinotto", "test@test.test", "10-10-1990", Sesso.Maschio,
				p1);
		
		PersonaDAO.save(persona1);
//		Evento e1 = new Evento("Sagra delle polpette", "10-10-2010", "Bone le polpette alla griglia", "Sagra",
//				10, Set<Partecipazione> _partecipazioni, );
//		
	}
	
}
