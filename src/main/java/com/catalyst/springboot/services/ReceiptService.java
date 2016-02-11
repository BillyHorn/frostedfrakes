package com.catalyst.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.ReceiptDao;
import com.catalyst.springboot.entities.Receipt;

@Service
public class ReceiptService {

	@Autowired
	ReceiptDao receiptDao;
	
	/**
	 * @param receiptDao the Dao to be set
	 */
	public void setReceiptDao (ReceiptDao receiptDao) {
		this.receiptDao = receiptDao;
	}
	
	public void addReceipt (Receipt receipt) {
		receiptDao.addReceipt(receipt);
	}

	public void sendImage(byte[] imageByteArray) {
		
		Receipt receipt = new Receipt(imageByteArray);
		
		receiptDao.addReceipt(receipt);
		
	}

	public List<Receipt> getReceiptByLineItemId(Integer id) {
		return receiptDao.getReceiptByLineItemId(id);
	}

	public Receipt getReceiptById(Integer lineItemId) {
		return receiptDao.getReceiptById(lineItemId);
	}
	
}
