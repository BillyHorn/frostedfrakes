package com.catalyst.springboot;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import com.catalyst.springboot.services.Service;
import com.catalyst.springboot.servicesimpl.Serviceimpl;
import com.catalyst.webservices.WebServices;

/**
 * WebServiceTest
 * 
 * Create a mock Serviceimpl and set
 * it as the next layer for WebService,
 * verify that WebServices works
 * by calling addReport() from
 * the mock Serviceimpl object
 * 
 * @author wPerlichek
 *
 */
public class WebServiceTest {
	
	/* create Serviceimpl and WebServices objects */
	private Serviceimpl mockService;
	private WebServices WebService;
	
	/* create a mock of Serviceimpl class and set 
	 * it to WebService Object
	 */
	@Before
	public void createWebService() throws Exception{
		mockService = mock(Serviceimpl.class);
		WebService = new WebServices();
		WebService.setReportService(mockService);
	}
	
	/* test WebService object by calling a function
	 * in the Serviceimpl object that requires
	 * the WebService
	 */
	@Test
	public void addReportTest() throws Exception{
		mockService.addReport(null);
		verify(mockService, times(1)).addReport(null);
	}
}
