package com.catalyst.springboot.services;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.dao.LineItemDao;

/**
 * test line item service
 * @author mKness
 *
 */
public class LineItemServiceTest {
	
	private LineItemService service;
	private LineItemDao dao;

	@Before
	public void setup() {
		service = new LineItemService();
		dao = mock(LineItemDao.class);
		service.setLineItemDao(dao);
	}
	
	@Test
	public void getLineItemsByReportIdTest() {
		service.getLineItemsByReportId(anyInt());
		verify(dao).getLineItemByReportId(anyInt());
	}
	
	@Test
	public void updateLineItemTest() {
		service.updateLineItem(anyObject());
		verify(dao).updateLineItem(anyObject());
	}
	
	@Test
	public void deleteLineItemTest() {
		service.deleteLineItem(anyInt());
		verify(dao).deleteLineItem(anyInt());
	}
	
	@Test
	public void getPendingLineItemsTest() {
		service.getPendingLineItems(anyInt());
		verify(dao).getPendingLineItems(anyInt());
	}
}
