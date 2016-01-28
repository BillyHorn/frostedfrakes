package com.catalyst.springboot;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



import org.junit.Before;

import com.catalyst.springboot.services.Service;
import com.catalyst.springboot.servicesimpl.Serviceimpl;
import com.catalyst.webservices.WebServices;


public class WebServiceTest {
	
	private Serviceimpl mockService;
	private WebServices WebService;
	
	@Before
	public void createWebService() throws Exception{
		mockService = mock(Serviceimpl.class);
		WebService = new WebServices();
		WebService.setReportService(mockService);
	}
	

}
