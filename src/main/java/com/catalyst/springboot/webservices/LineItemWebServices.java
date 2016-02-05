package com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.services.LineItemService;

@RestController
public class LineItemWebServices {

	@Autowired
	LineItemService lineItemService;
	
	/**
	 * 
	 * @param lineItemService
	 */
	public void setLineItemService(LineItemService lineItemService) {
		this.lineItemService = lineItemService;
	}
	
	/**
	 * 
	 * @param reportId used to grab all lineitems assoicated with given report
	 * @return the list of lineitems assoicated with the given reportId
	 */
	@RequestMapping(value="/lineitems/{reportId}", method=RequestMethod.GET)
	public List<LineItem> getLineItemsByReportId(@PathVariable Integer reportId)
	{
		return lineItemService.getLineItemsByReportId(reportId);
	}
	
	/** UPDATE
	 * 
	 * @param lineItem merges the lineItem into the db
	 */
	@RequestMapping(value="/lineitems", method=RequestMethod.PUT)
	public void updateLineItem(@RequestBody LineItem lineItem)
	{
		lineItemService.updateLineItem(lineItem);
	}
	
	/** DELETE
	 * 
	 * @param lineItem the lineitem being removed from the db
	 */
	@RequestMapping(value="/lineitems/{lineItemId}", method=RequestMethod.DELETE)
	public void deleteLineItem(@PathVariable Integer lineItemId)
	{
		lineItemService.deleteLineItem(lineItemId);
	}
	
	/** 
	 * 
	 * @param lineItem the lineitem being removed from the db
	 */
	@RequestMapping(value="/lineitems/pending/{id}", method=RequestMethod.GET)
	public List<LineItem> getPendingLineItems(@PathVariable Integer id)
	{
		return lineItemService.getPendingLineItems(id);
	}
}
