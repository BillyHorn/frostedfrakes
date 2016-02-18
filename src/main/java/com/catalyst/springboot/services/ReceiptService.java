package com.catalyst.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.ReceiptDao;
import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Receipt;

/**
 * This class holds the services for Receipt objects.
 * 
 * @author atatro
 *
 */
@Service
public class ReceiptService {

	// our Dao object, for communicating service requests to the db
	@Autowired
	ReceiptDao receiptDao;
	
	// and a lineitem service object
	@Autowired
	private LineItemService lineItemService;
	
	/**
	 * a simple setter for the lineitem service object
	 * 
	 * @param lineItemService the lineitemservice to be set
	 */
	public void setLineItemService(LineItemService lineItemService) {
		this.lineItemService = lineItemService;
	}
	
	/**
	 * a simple setter for the ReceiptDao object
	 * 
	 * @param receiptDao the Dao to be set
	 */
	public void setReceiptDao (ReceiptDao receiptDao) {
		this.receiptDao = receiptDao;
	}
	
	public void delete(Integer id) {
		receiptDao.delete(id);
	}
	
	/**
	 * this method passes CREATE request to the Dao
	 * 
	 * @param receipt the receipt to be CREATEd
	 */
	public void addReceipt (Receipt receipt) {
		receiptDao.addReceipt(receipt);
	}

	/**
	 * this method takes in requisite pieces of a receipt and compiles them in
	 * to a whole, passing it in to the addReceipt method above.
	 * 
	 * @param imageByteArray this is the image data for the receipt
	 * @param receiptName this is a name for the receipt
	 * @param lineItemId this is the id of the lineitem to be included
	 */
	public void sendReceiptData(byte[] imageByteArray, String receiptName, Integer lineItemId) {
		
		/*
		 *  Hibernate is annoying and doesn't let you just pass in an id,
		 *  even thought that is what it's going to store in the db. so fine,
		 *  I'll get you the associated lineitem and then you can throw it out
		 *  again. fine.
		 */
		LineItem lineItem = lineItemService.getLineItemById(lineItemId);
		
		// build that receipt
		Receipt receipt = new Receipt(imageByteArray, receiptName, lineItem);
		
		// and send it through
		receiptDao.addReceipt(receipt);
		
	}

	/**
	 * this method grabs a list of line items from the dao, selected by the id
	 * of the associated lineitem
	 * 
	 * @param id the id of the line item to be searched for
	 * @return a list of associated receipts
	 */
	public List<Receipt> getReceiptByLineItemId(Integer id) {
		return receiptDao.getReceiptByLineItemId(id);
	}

	/**
	 * this method retrieves a receipt selected by it's unique id
	 * 
	 * @param lineItemId the id to be searched for
	 * @return the receipt associated
	 */
	public Receipt getReceiptById(Integer lineItemId) {
		return receiptDao.getReceiptById(lineItemId);
	}
	
}
