package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonaDAO.class);

	public static void save(Persona object) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	public void refresh(Persona object) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	public Persona getById(Long id) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(Persona.class, id);

		} finally {
			em.close();
		}

	}

	public void delete(Persona object) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}
	}
	
}
