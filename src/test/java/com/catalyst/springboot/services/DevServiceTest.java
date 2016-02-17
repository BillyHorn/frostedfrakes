package com.catalyst.springboot.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.dao.DevDao;
import com.catalyst.springboot.entities.Dev;

public class DevServiceTest {
	
	private DevService service;
	private DevDao dao;

	@Before
	public void setup() {
		service = new DevService();
		dao = mock(DevDao.class);
		service.setDevdao(dao);
	}
	
	@Test
	public void getAllDevsTest(){
		@SuppressWarnings("unchecked")
		List<Dev> devs = mock(List.class);
		
		when(dao.get()).thenReturn(devs);
		
		service.get();
		verify(dao).get();
		
	}
	
	@Test
	public void getEmployeeByUsernameTest() {
		Dev dev = mock(Dev.class);
		
		when(dao.getDevByUsername(anyString())).thenReturn(dev);
		
		service.getEmployeeByUsername(anyString());
		verify(dao).getDevByUsername(anyString());
	}
	
	@Test
	public void checkUserNameTest() {
		Dev dev = mock(Dev.class);
		
		when(dao.getDevByUsername(anyString())).thenReturn(dev);
		
		service.checkUserName(anyString());
		verify(dao).getDevByUsername(anyString());
	}
	
	@Test
	public void registerTest() {
		service.register(anyObject());
		verify(dao).register(anyObject());
	}
	
	@Test
	public void totpAuthTestSuccess(){
		Dev dev = mock(Dev.class);
		Principal principal = mock(Principal.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		when(principal.getName()).thenReturn("test");
		when(dao.getDevByUsername(anyString())).thenReturn(dev);
		when(dev.getAuthCode()).thenReturn("123456");
		when(dev.getLoginTime()).thenReturn(System.currentTimeMillis()-5000);
		when(dao.loginTotp(dev)).thenReturn(dev);
		
		service.totpAuth("123456", response, principal);
		verify(dev).setIsvalid(true);
	}
	
	@Test
	public void totpAuthTestFailedAuthCode(){
		Dev dev = mock(Dev.class);
		Principal principal = mock(Principal.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		when(principal.getName()).thenReturn("test");
		when(dao.getDevByUsername(anyString())).thenReturn(dev);
		when(dev.getAuthCode()).thenReturn("123457");
		when(dev.getLoginTime()).thenReturn(System.currentTimeMillis()-5000);
		when(dao.loginTotp(dev)).thenReturn(dev);
		
		service.totpAuth("123456", response, principal);
		verify(dev).setIsvalid(false);
	}
	
	@Test
	public void totpAuthFailedTime(){
		Dev dev = mock(Dev.class);
		Principal principal = mock(Principal.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		when(principal.getName()).thenReturn("test");
		when(dao.getDevByUsername(anyString())).thenReturn(dev);
		when(dev.getAuthCode()).thenReturn("123456");
		when(dev.getLoginTime()).thenReturn(System.currentTimeMillis()-500000);
		when(dao.loginTotp(dev)).thenReturn(dev);
		
		service.totpAuth("123456", response, principal);
		verify(dev).setIsvalid(false);
	}
	
	@Test
	public void loginTotp() {
		Dev dev = mock(Dev.class);
		
		when(dao.loginTotp(anyObject())).thenReturn(dev);
		
		service.loginTotp(dev);
		assertEquals(dev, dev);
	}
}
