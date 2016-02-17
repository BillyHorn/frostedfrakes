package com.catalyst.springboot.webservices;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

	@Test
	public void addNewUserTestFailure() {
		Dev realDev = new Dev();
		Dev expectedDev = new Dev();
		realDev.setEmail("test");
		
		when(dev.getEmail()).thenReturn("not null");
		when(devService.checkUserName(anyString())).thenReturn(realDev);
		
		devWebServices.addNewUser(realDev);
		assertEquals(expectedDev, realDev);
	}
	
	@Test
	public void addNewUserTestSuccess() {
		Dev realDev = new Dev();
		realDev.setEmail("test");
		
		when(dev.getEmail()).thenReturn(null);
		when(devService.checkUserName(anyString())).thenReturn(null);
		
		devWebServices.addNewUser(realDev);
		verify(devService).register(realDev);
	}
	
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
	
	@Test
	public void totpAuthTest(){
		HttpServletResponse httpResponse = mock(HttpServletResponse.class);
		when(devService.totpAuth(anyObject(), anyObject(), anyObject())).thenReturn(httpResponse);
		
		devWebServices.totpAuth(null, null, null);
		
		verify(devService).totpAuth(null, null, null);
	}
}
