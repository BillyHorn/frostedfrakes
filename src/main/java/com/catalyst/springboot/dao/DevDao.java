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
		List<Dev> devs = em.createQuery("SELECT d FROM dev d", Dev.class).getResultList();
		return devs;
	}

	/**
	 * Gets a user by username
	 * 
	 * @param username The username to get
	 * @return The user object minus the password
	 */
	public Dev getEmployeeByUsername(String username) {
		Dev dev = em.createQuery("SELECT d from dev d WHERE d.email = :email", Dev.class)
				.setParameter("email", username).getSingleResult();
		return dev;
	}


	
	
	
	
}
