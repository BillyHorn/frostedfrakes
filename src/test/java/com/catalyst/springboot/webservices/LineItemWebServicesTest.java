package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.ReportHistory;
import com.catalyst.springboot.services.LineItemService;

/**
 * 
 * @author mKness
 *
 */
public class LineItemWebServicesTest {

	private LineItemWebServices lineItemWebServices;
	private LineItemService lineItemService;
	private LineItem lineItem;
	
	@Before
	public void setup(){
		lineItemWebServices = new LineItemWebServices();
		lineItemService = mock(LineItemService.class);
		lineItem = mock(LineItem.class);
		lineItemWebServices.setLineItemService(lineItemService);
	}
	
	@Test
	public void getLineItemsByReportIdTest() {
		List<LineItem> lineItems = new ArrayList<LineItem>();
		
		when(lineItemWebServices.getLineItemsByReportId(anyInt())).thenReturn(lineItems);
		
		lineItemWebServices.getLineItemsByReportId(anyInt());
		verify(lineItemService).getLineItemsByReportId(anyInt());
	}
	
	@Test
	public void updateLineItemTest() {
		
	}
	
	@Test
	public void deleteLineItemTest() {
		lineItemWebServices.deleteLineItem(anyInt());
		verify(lineItemService).deleteLineItem(anyInt());
	}
	
	@Test
	public void getPendingLineItemsTest(){
		List<LineItem> lineItems = new ArrayList<LineItem>();
		
		when(lineItemWebServices.getPendingLineItems(anyInt())).thenReturn(lineItems);
		
		lineItemWebServices.getPendingLineItems(anyInt());
		verify(lineItemService).getPendingLineItems(anyInt());
	}
}
