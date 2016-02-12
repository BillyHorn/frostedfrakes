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
public class LineItemDao {
	
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
	 * This function returns a single line item selected by its id
	 * 
	 * @author atatro
	 * @param lineItemId the id to search for
	 * @return the line item selected from the above id
	 */
	public LineItem getLineItemById(Integer lineItemId){
		return em.createQuery("SELECT l FROM lineitem l WHERE l.lineItemId = :lineItemId", LineItem.class)
				.setParameter("lineItemId", lineItemId).getSingleResult();
	}

	/**
	 * @param reportID the id of the report that we want to get lineitems for
	 * @return the list of lineitems assoiciated with the given reportID
	 */
	public List<LineItem> getLineItemByReportId(Integer reportID) {
			return em.createQuery("SELECT l from lineitem l WHERE l.report.reportId = :reportID", LineItem.class)
					.setParameter("reportID", reportID).getResultList();
	}

	/**
	 * 
	 * @param lineItem the lineItem to merge into the db
	 */
	public void updateLineItem(LineItem lineItem) {
		em.merge(lineItem);
		em.flush();
	}

	/**
	 * 
	 * @param lineItem the lineitem being removed from the db
	 */
	public void deleteLineItem(Integer lineItemId) {
		LineItem lineItem = em.find(LineItem.class, lineItemId);
		em.remove(lineItem);
		em.flush();
	}

	public List<LineItem> getPendingLineItems(Integer id) {
		return em.createQuery("SELECT l from lineitem l WHERE l.report.project.techLeadId.devId = :id", LineItem.class)
				.setParameter("id", id).getResultList();
	}
	
	
	
	
}
