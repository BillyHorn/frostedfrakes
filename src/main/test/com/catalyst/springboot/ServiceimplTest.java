package com.catalyst.springboot;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import com.catalyst.springboot.dao.Dao;
import com.catalyst.springboot.servicesimpl.Serviceimpl;

public class ServiceimplTest {
	
	private Serviceimpl serviceTarget;
	private Dao mockDao;
	
	@Before
	public void serviceTargetTest(){
		mockDao = mock(Dao.class);
		serviceTarget = new Serviceimpl();
		mockDao.addReport(null);
	}
	

}
