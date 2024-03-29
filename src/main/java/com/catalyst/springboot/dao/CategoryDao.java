package com.catalyst.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.Category;
import com.catalyst.springboot.entities.LineItem;

@Transactional
@Component 
public class CategoryDao {

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
	
	public List<Category> getCategoies() {
		return em.createQuery("SELECT c FROM category c",Category.class).getResultList();
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
}
