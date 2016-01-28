package com.catalyst.springboot;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import com.catalyst.springboot.dao.Dao;
import com.catalyst.springboot.servicesimpl.Serviceimpl;


/**
 * 
 * 
 * @author wPerlichek
 *
 */
public class ServiceimplTest {
	
	private Serviceimpl serviceTarget;
	private Dao mockDao;
	
	@Before
	public void serviceTestSetup(){
		serviceTarget = new Serviceimpl();
		mockDao = mock(Dao.class);
		serviceTarget.setReportDao(mockDao);
	}
	
	@Test
	public void testAddReport(){
		serviceTarget.addReport(null);
		verify(mockDao, times(1)).addReport(null);
	}
	
}
