package com.catalyst.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Dev;

@Transactional
@Component
public class ProjectDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * check if a particular Developer exists
	 * 
	 * @param email
	 * @return
	 */
	public Dev checkUserName(String email) {

		try {
			return em.createQuery("SELECT c FROM dev c WHERE c.email = :email ", Dev.class).setParameter("email", email)
					.getSingleResult();
		} catch (NoResultException noResult) {
			return null;
		}

	}

	/**
	 * Adds a new Developer to the database.
	 * 
	 * @param dev
	 * @return
	 */
	public Dev register(Dev dev) {
		em.persist(dev);
		em.flush();
		return dev;
	}
}