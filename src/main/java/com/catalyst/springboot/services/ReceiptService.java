package com.catalyst.springboot.services;

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

	public Receipt getReceipt() {
		return receiptDao.getReceipt();
	}
	
}
