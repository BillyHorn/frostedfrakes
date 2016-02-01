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
		List<Dev> devs = mock(List.class);
		
		when(dao.get()).thenReturn(devs);
		
		service.get();
		verify(dao).get();
		
	}
}
