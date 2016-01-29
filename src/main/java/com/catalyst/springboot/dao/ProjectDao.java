package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Project;

@Transactional
@Component 
public class ProjectDao {

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void add(Project project) {
		
		em.persist(project);
		
		
	}
	
	public List<Project> get(){
		return em.createQuery("SELECT p FROM Project p LEFT JOIN FETCH p.devs", Project.class).getResultList();
	}
	
//	public void add(Project project){
//		em.persist(project);
//		em.flush();
//	}
}
