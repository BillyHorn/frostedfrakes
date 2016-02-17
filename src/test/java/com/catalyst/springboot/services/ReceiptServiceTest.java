package com.catalyst.springboot.services;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.dao.ReceiptDao;
import com.catalyst.springboot.entities.LineItem;

public class ReceiptServiceTest {
	
	LineItemService lineItemService;
	ReceiptService service;
	ReceiptDao dao;
	
	@Before
	public void setup() {
		service = new ReceiptService();
		lineItemService = mock(LineItemService.class);
		dao = mock(ReceiptDao.class);
		service.setReceiptDao(dao);
		service.setLineItemService(lineItemService);
	}
	
	@Test
	public void addReceiptTest() {
		service.addReceipt(anyObject());
		verify(dao).addReceipt(anyObject());
	}
	
	@Test
	public void getReceiptByLineItemId() {
		service.getReceiptByLineItemId(anyInt());
		verify(dao).getReceiptByLineItemId(anyObject());
	}
	
	@Test
	public void getReceiptById() {
		service.getReceiptById(anyInt());
		verify(dao).getReceiptById(anyObject());
	}
	
	
}
