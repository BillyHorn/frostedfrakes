package com.catalyst.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.LineItemDao;
import com.catalyst.springboot.entities.LineItem;

/**
 *  Services relevant to lineitems
 * @author mkness
 *
 */
@Service
public class LineItemService {
	
	@Autowired
	LineItemDao lineItemDao;
	
	/**
	 * simple setter for line item dao
	 */
	public void setLineItemDao(LineItemDao lineItemDao) {
		this.lineItemDao = lineItemDao;
	}

	/**
	 * 
	 * @param reportId used to get all lineitems associated with that report
	 * @return the list of items associated with the given reportId
	 */
	public List<LineItem> getLineItemsByReportId(Integer reportId) {
		return lineItemDao.getLineItemByReportId(reportId);
	}

	/**
	 * 
	 * @param lineItem the lineItem to be merged into db
	 */
	public void updateLineItem(LineItem lineItem) {
		lineItemDao.updateLineItem(lineItem);
	}

	/**
	 * 
	 * @param lineItem the lineItem to be deleted from the db
	 */
	public void deleteLineItem(Integer lineItemId) {
		lineItemDao.deleteLineItem(lineItemId);
	}

	/**
	 * 
	 * @param id the id of the tech lead we are getting pending lineitems for
	 * @return returns the list of pending lineitems for the corresponding tech lead
	 */
	public List<LineItem> getPendingLineItems(Integer id) {
		return lineItemDao.getPendingLineItems(id);
	}
	
	/**
	 * returns a line item selected by its id
	 * 
	 * @author atatro
	 * @param lineItemId the id to search by
	 * @return the corresponding line item
	 */
	public LineItem getLineItemById(Integer lineItemId) {
		return lineItemDao.getLineItemById(lineItemId);
	}

}
