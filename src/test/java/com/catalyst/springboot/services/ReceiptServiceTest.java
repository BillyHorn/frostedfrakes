package com.catalyst.springboot.services;

import static org.mockito.Mockito.*;

import org.junit.Before;

import com.catalyst.springboot.dao.ReceiptDao;

public class ReceiptServiceTest {
	
	LineItemService lineItemService;
	ReceiptService service;
	ReceiptDao dao;
	
	@Before
	public void setup() {
		service = new ReceiptService();
		lineItemService = new LineItemService();
		dao = mock(ReceiptDao.class);
		service.setReceiptDao(dao);
		service.setLineItemService(lineItemService);
	}
	
	public void addReceiptTest() {
		service.addReceipt(anyObject());
		verify(dao).addReceipt(anyObject());
	}
}
