package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

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
	
}
