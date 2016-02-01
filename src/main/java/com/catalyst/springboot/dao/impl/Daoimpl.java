package com.catalyst.springboot.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.dao.ProjectDao;
import com.catalyst.springboot.dao.Dao;
import com.catalyst.springboot.entities.Report;

@Transactional
@Component
public class Daoimpl {

	
	public void addReport(Report report) {
		em.persist(report);
		em.flush();
	}
	
	public List<Report> getReport(){
		return em.createQuery("SELECT r.reportId, r.dev.email, r.lineItems FROM Report r", Report.class).getResultList();
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
