package com.catalyst.springboot.dao;


import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Dev;

public class DevDaoTest {

	
	private DevDao dao;
	private EntityManager mockEm;

	@Before
	public void setup() {
		dao = new DevDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
	}
	
	
	
	@Test
	public void getAllDevsTest(){
		TypedQuery<Dev> query = mock(TypedQuery.class);
		List<Dev> expected = new ArrayList<Dev>();
		
		when(mockEm.createQuery(anyString(), eq(Dev.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(expected);
		
		dao.get();
		verify(query).getResultList();
	}
}
