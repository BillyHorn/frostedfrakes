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
	
	@Test
	public void getReceiptImageTest(){
		assertTrue(true);
	}
}
