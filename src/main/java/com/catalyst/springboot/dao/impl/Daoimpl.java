package com.catalyst.springboot.dao.impl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.dao.ProjectDao;
import com.catalyst.springboot.dao.Dao;
import com.catalyst.springboot.entities.Report;


public class Daoimpl implements Dao {

	
	public void addReport(Report report) {
		// logic here 
	}


	/*@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		*/

//public class Daoimpl {

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;

	}
	
	/**
	 * check if a particular Developer exists
	 * @param email
	 * @return
	 */
	public Dev checkUserName(String email) {
		return em.createQuery("SELECT c FROM dev c WHERE c.email = :email ", Dev.class)
				.setParameter("email", email).getSingleResult();
	}
	
	
	/**
	 * Adds a new Developer to the database. 
	 * @param dev
	 * @return 
	 */
	public Dev register(Dev dev) {
		em.persist(dev);
		em.flush();
		return dev;
	}

	
	
}
