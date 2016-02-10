package com.catalyst.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Receipt;

@Transactional
@Component 
public class ReceiptDao {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * simple setter for the Entity Manager
	 * 
	 * @param em this is the em to be set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void addReceipt(Receipt receipt){
		em.persist(receipt);
		em.flush();
	}

	public Receipt getReceipt() {
		return em.createQuery("SELECT r FROM Receipt r", Receipt.class).getResultList().get(0);
	}

}
