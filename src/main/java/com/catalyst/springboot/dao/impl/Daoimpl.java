package com.catalyst.springboot.dao.impl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Daoimpl {

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	
}
