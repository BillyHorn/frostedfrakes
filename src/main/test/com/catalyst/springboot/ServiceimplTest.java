package com.catalyst.springboot;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import com.catalyst.springboot.dao.Dao;
import com.catalyst.springboot.servicesimpl.Serviceimpl;

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
	private Serviceimpl serviceTarget;
	private Dao mockDao;
	
	/* assign a mock dao to the Serviceimpl object */
	@Before
	public void serviceTestSetup(){
		serviceTarget = new Serviceimpl();
		mockDao = mock(Dao.class);
		serviceTarget.setReportDao(mockDao);
	}
	
	/* use the Serviceimpl object to add a report  verify success */
	@Test
	public void testAddReport(){
		serviceTarget.addReport(null);
		verify(mockDao, times(1)).addReport(null);
	}
	
}
