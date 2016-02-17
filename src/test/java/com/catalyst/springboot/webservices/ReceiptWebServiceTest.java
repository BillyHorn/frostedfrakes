package com.catalyst.springboot.webservices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Receipt;
import com.catalyst.springboot.services.LineItemService;
import com.catalyst.springboot.services.ReceiptService;

public class ReceiptWebServiceTest {
	
	private ReceiptWebServices webServices;
	private ReceiptService service;
	
	@Before
	public void setup(){
		webServices = new ReceiptWebServices();
		service = mock(ReceiptService.class);
		webServices.setReceiptService(service);
	}
	
	// this test is clearly garbage. it's gonna need some love.
//	@Test
//	public void getReceiptImageTest(){
//		
//	}
	
	@Test
	public void getReceiptByLineItemIdTest(){
		webServices.getReceiptByLineItemId(anyInt());
		verify(service).getReceiptByLineItemId(anyInt());
	}
	
	@Test
	public void getReceiptByIdTest(){
		webServices.getReceiptById(anyInt());
		verify(service).getReceiptById(anyInt());
	}
}
