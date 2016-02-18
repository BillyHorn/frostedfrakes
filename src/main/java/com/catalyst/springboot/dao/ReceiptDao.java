package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Receipt;

/**
 * a data access object to communicate with the database on all things
 * concerning receipts
 * 
 * @author atatro
 *
 */
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
	
	/**
	 * sends a CREATE receipt request to the db
	 * @param receipt
	 */
	public void addReceipt(Receipt receipt){
		em.persist(receipt);
		em.flush();
	}
	
	public void delete(Integer id) {
		Receipt receipt = em.find(Receipt.class, id);
		em.remove(receipt);
		em.flush();
	}
	
	/**
	 * sends a READ receipt request, specifying by it's unique id
	 * 
	 * @param id the id of the receipt to be searched for
	 * @return the receipt associated with the above id
	 */
	public Receipt getReceiptById(Integer id) {
		return em.createQuery("SELECT r FROM Receipt r WHERE r.receiptId = :receiptId", Receipt.class)
					.setParameter("receiptId", id).getSingleResult();
	}

	/**
	 * sends a READ receipt request to the db, specifying by it's attached
	 * lineitem
	 * 
	 * @param lineItemId the id of the lineitem to be searched
	 * @return a list of associated receipt objects
	 */
	public List<Receipt> getReceiptByLineItemId(Integer lineItemId) {
		return em.createQuery("SELECT r FROM Receipt r WHERE r.lineItem.lineItemId = :lineItemId", Receipt.class)
				.setParameter("lineItemId", lineItemId)
				.getResultList();
	}

}
