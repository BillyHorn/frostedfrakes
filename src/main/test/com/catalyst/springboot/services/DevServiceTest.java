package com.catalyst.springboot.services;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
}
