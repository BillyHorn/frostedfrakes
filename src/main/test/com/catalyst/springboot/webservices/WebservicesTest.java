package com.catalyst.springboot.webservices;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import com.catalyst.springboot.dao.ProjectDao;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.webservices.WebServices;

public class WebservicesTest {

	private ProjectDao mockDao;
	private WebServices webservices;
	private Dev mockDev;
	
	@Before
	public void createWebServices() throws Exception {
		mockDao = mock(ProjectDao.class);
		webservices = new WebServices();
		webservices.setDao(mockDao);
		
	}
	
	@Test
	public void addNewUserTest() throws Exception {
		//webservices.addNewUser(null);
		when(mockDev.getEmail()).thenReturn("test");
		when(mockDao.checkUserName(anyString())).thenReturn(mockDev);
		
		verify(mockDao, times(1)).checkUserName(null);
		verify(mockDao,times(1)).register(null);
		
	}
	
	
}
