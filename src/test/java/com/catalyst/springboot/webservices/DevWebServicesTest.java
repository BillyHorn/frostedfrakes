package com.catalyst.springboot.webservices;


import static org.mockito.Mockito.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.services.DevService;

/**
 * 
 * @author mKness
 *
 */
public class DevWebServicesTest {
	
	private DevWebServices devWebServices;
	private DevService devService;
	private Dev dev;
	private Principal principal;
	
	@Before
	public void setup() {
		devWebServices = new DevWebServices();
		devService = mock(DevService.class);
		devWebServices.setService(devService);
		dev = mock(Dev.class);
		principal = mock(Principal.class);
	}

	/*@Test
	public void addNewUserTest() {
		Dev realDev = new Dev();
		realDev.setEmail("test");
		
		when(devService.checkUserName(anyString())).thenReturn(null);
		
		when(devWebServices.addNewUser(anyObject())).thenReturn(realDev);
		
		devWebServices.addNewUser(realDev);
		verify(devService).register(realDev);
	}*/
	
	@Test
	public void getUsersTest() {
		List<Dev> devs = new ArrayList<Dev>();
		
		when(devWebServices.getUsers()).thenReturn(devs);
		
		devWebServices.getUsers();
		verify(devService).get();
	}
	
	@Test
	public void currentUserTest() {
		when(principal.getName()).thenReturn("test");
		devWebServices.currentUser(principal);
		verify(devService).getEmployeeByUsername("test");
	}
}
