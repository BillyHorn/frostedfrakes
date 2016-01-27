package com.catalyst.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Transactional
@Component 
public class ProjectDao {

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
//	public void add(Project project){
//		em.persist(project);
//		em.flush();
//	}
}
