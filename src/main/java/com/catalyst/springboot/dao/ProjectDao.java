package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Dev;
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
		System.out.println(project.getName() + " " + project.getTechLeadId().getEmail());
		for (Dev dev : project.getUsers()){
			System.out.println(dev.getEmail());
		}
		em.flush();
		em.persist(project);
		
		
	}
	
	public List<Project> get(){
		return em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
	}
	
//	public void add(Project project){
//		em.persist(project);
//		em.flush();
//	}
}
