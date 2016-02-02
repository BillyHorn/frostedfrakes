package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
	
	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	

	/**
	 * Gets the list of users minus the passwords from the database. 
	 * 
	 * @return The list of users from the database.
	 */
	public List<Dev> get(){
//		Session session = Application.sessionFactory.getCurrentSession();
//		List<Dev> devs = session.createCriteria(Dev.class).setProjection(Projections.projectionList()
//				.add(Projections.property("email"), "email")
//				.add(Projections.property("devid"), "devid")
//				.add(Projections.property("role"), "role"))
//				.setResultTransformer(Transformers.aliasToBean(Dev.class)).list();
//		return devs;
		List<Dev> devs = em.createQuery("SELECT d FROM dev d", Dev.class).getResultList();
//		for (Dev dev : devs) {
//			dev.setPassword(null);
//		}
		return devs;
	}


	public Dev getEmployeeByUsername(String username) {
		Dev dev = em.createQuery("SELECT d from dev d WHERE d.email = :email", Dev.class)
				.setParameter("email", username).getSingleResult();
		return dev;
	}
	
	
	
	
}
