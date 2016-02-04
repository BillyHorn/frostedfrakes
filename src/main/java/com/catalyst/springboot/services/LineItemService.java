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

}
