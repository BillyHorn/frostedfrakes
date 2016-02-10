package com.catalyst.springboot;
import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.services.ReportService;


/**
 * ServiceimplTest
 * 
 * Create a mock DAO and add it 
 * to Service. Test
 * the addReport function of 
 * Service
 * 
 * @author wPerlichek
 *
 */
public class ServiceimplTest {
	
	/* create Serviceimpl and Dao objects */
	private ReportService serviceTarget;
	//private Daoimpl mockDao;
	
	/* assign a mock dao to the Serviceimpl object */
	@Before
	public void serviceTestSetup(){
		serviceTarget = new ReportService();
		//mockDao = mock(Daoimpl.class);
		//serviceTarget.setReportDao(mockDao);
	}
	
	/* use the Serviceimpl object to add a report verify success */
	@Test
	public void testAddReport(){
		serviceTarget.add(null);
		//verify(mockDao, times(1)).addReport(null);
	}
	
}
