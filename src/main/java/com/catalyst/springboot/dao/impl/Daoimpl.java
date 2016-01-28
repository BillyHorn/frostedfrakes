package com.catalyst.springboot.dao.impl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.catalyst.springboot.entities.Employee;

public class Daoimpl {

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	//TODO Employee.class
	// check if a perticular username exists
	public Employee checkUserName(String username) {
		return em.createQuery("SELECT c FROM viewName c WHERE c.username = :username ", Employee.class)
				.setParameter("username", username).getSingleResult();
	}
	
	
	/**
	 * Adds a new Employee to the database. 
	 * @param employee
	 * @return 
	 */
	public Employee createEmployeeUserName(Employee employee) {
		em.persist(employee);
		em.flush();
		return employee;
	}
	
	
}
