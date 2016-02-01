package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Dev;

/**
 * Communicates with the database concerning devs.
 * @author kmatthiesen
 *
 */
@Transactional
@Component 
public class DevDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * Gets the list of users minus the passwords from the database. 
	 * 
	 * @return The list of users from the database.
	 */
	public List<Dev> get(){
		return em.createQuery("SELECT d.email, d.role, d.id FROM dev d", Dev.class).getResultList();
	}
	
	
}
