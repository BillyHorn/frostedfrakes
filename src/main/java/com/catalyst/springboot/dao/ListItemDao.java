package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.LineItem;

/**
 * Communicates with the database concerning devs.
 * @author kmatthiesen
 *
 */
@Transactional
@Component 
public class ListItemDao {
	
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
	 * This function fetches all the line items.
	 * 
	 * @return The list of line items from the database.
	 */
	public List<LineItem> get(){
		List<LineItem> lineItems = em.createQuery("SELECT l FROM lineitem l", LineItem.class).getResultList();
		return lineItems;
	}

	/**
	 * Gets a user by username
	 * 
	 * @param username The username to get
	 * @return The user object minus the password
	 */
	public LineItem getLineItemByReportId(String reportID) {
		LineItem lineitem = em
				.createQuery("SELECT l from lineitem l WHERE l.reportid = :reportID", LineItem.class)
				.setParameter("reportID", reportID).getSingleResult();
		return lineitem;
	}
	
	
	
	
}
