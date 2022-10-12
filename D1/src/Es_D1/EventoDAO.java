package Es_D1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EventoDAO {

	static EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {

		insertEvent(1,"Sagra della porchetta", "01-01-2001", "Si mangia la porchetta buona", "Sagra di paese", 205);

		findEvento(2);

		em.close();

		emf.close();

	}

	public static void findEvento(int id) {

		Evento s = em.find(Evento.class, id);

		if (s != null) {
			System.out.println(s);
		}

	}

	public static void insertEvent(int id,String titolo, String dataEvento, String descrizione, String tipoEvento,
			int numeroMassimoPartecipanti) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("D1");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();

		Evento s = new Evento(id,titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);

		em.persist(s);

		t.commit();

		em.close();
		emf.close();

	}

}
