package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired(required = false)
	private BCryptPasswordEncoder encoder;
	
	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * @param encoder the encoder to set
	 */
	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
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
	public Dev getDevByUsername(String username) {
	Dev dev = null;
		/* you have to try-catch here because .getSingleResult throws an 
		 * exception if it doesn't find anything. wtf is that.
		 */
		try {
			dev = em.createQuery("SELECT d from dev d WHERE d.email = :email", Dev.class)
					.setParameter("email", username).getSingleResult();
		} catch (NoResultException exception) {
			System.out.println("caught that stupid exception");
		}
		return dev;
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
	
	public Dev loginTotp(Dev dev){
		em.merge(dev);
		em.flush();

		return dev;
	}
		
	
}
