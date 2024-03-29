package com.catalyst.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import com.catalyst.springboot.entities.Dev;
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
	public List<Project> getByDev(Dev dev){
		List<Project> list = em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
		List<Project> projects = new ArrayList<Project>();
		for (Project proj : list){
			if (proj.getUsers().contains(dev)){
				projects.add(proj);
			}
		}
		return projects;
	}
	
	

	/**
	 * check if a particular Developer exists
	 * 
	 * @param email
	 * @return
	 */
	public Dev checkUserName(String email) {

		try {
			return em.createQuery("SELECT c FROM dev c WHERE c.email = :email ", Dev.class).setParameter("email", email)
					.getSingleResult();
		} catch (NoResultException noResult) {
			return null;
		}

	}

	

	public List<Project> getTechLeadProjects(Dev dev) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT p FROM Project p WHERE p.techLeadId = :dev", Project.class)
				.setParameter("dev", dev).getResultList();
	}

}



