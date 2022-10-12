package it.epicode.be.gestioneventi.model.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.be.gestioneventi.model.Evento;
import it.epicode.be.gestioneventi.model.Genere;
import it.epicode.be.gestioneventi.util.JpaUtil;
import models.es2.Concerto;

public class EventoDAO {
	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);

	public void save(Evento object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
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

	public void refresh(Evento object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	public Evento getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(Evento.class, id);

		} finally {
			em.close();
		}

	}

	public void delete(Evento object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
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

	public static void getConcertiInStreaming(boolean n) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		Query q = em.createQuery("SELECT c FROM Concerto c Where c.inStreaming = :n ");

		q.setParameter("n", n);

		List<Concerto> r = q.getResultList();
		for (Concerto p : r) {
			System.out.println(p.toString());
		}
		em.close();
	}

	public static void getConcertiPerGenere(Genere n) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		Query q = em.createQuery("SELECT c FROM Concerto c Where c.genere = :n ");

		q.setParameter("n", n);

		List<Concerto> r = q.getResultList();
		for (Concerto p : r) {
			System.out.println(p);
		}
		em.close();
	}

}
