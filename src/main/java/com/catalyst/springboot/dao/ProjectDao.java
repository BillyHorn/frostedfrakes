package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Project;


/**
 * Communicates with the database regarding projects.
 * @author kmatthiesen
 *
 */
@Transactional
@Component
public class ProjectDao {

	
	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void add(Project project) {
		em.flush();
		em.persist(project);
		
		
	}
	
	/**
	 * Gets a list of all projects from the database.
	 * 
	 * @return The list of projects from the database.
	 */
	public List<Project> get(){
		return em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
	}
	
	@Autowired(required = false)
	private BCryptPasswordEncoder encoder;
	
	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
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
	 * with encrypted password 
	 * @param dev
	 * @return
	 */
	public Dev register(Dev dev) {
		String encryptedPass = encoder.encode(dev.getPassword());
		dev.setPassword(encryptedPass);
		em.persist(dev);
		em.flush();
		return dev;
	}

}



