package com.catalyst.springboot.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.catalyst.springboot.entities.Dev;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Report;


@Transactional
@Component
public class Daoimpl {

	
	public void addReport(Report report) {
		em.persist(report);
		em.flush();
	}
	
	public List<Report> getReport(){
		return em.createQuery("SELECT r FROM Report r", Report.class).getResultList();
	}
	
	public Report getReportById(Integer reportId){
		return em.createQuery("SELECT r FROM Report r WHERE r.reportId = :reportId", Report.class).setParameter("reportId", reportId).getSingleResult();
	}


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
	 * This function is to update report object in db
	 * 
	 * @param report this is the report to be updated
	 */
	public void update(Report report) {
		em.merge(report);
		em.flush();
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
	
	public List<Report> getReportByDevId(Dev dev) {
		return em.createQuery("SELECT r FROM Report r WHERE r.dev = :dev ", Report.class)
				.setParameter("dev", dev).getResultList();

	}

	
	
}
