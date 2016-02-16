package com.catalyst.springboot.dao;


import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.LineItem;

public class DevDaoTest {

	
	private DevDao dao;
	private EntityManager mockEm;
	private Dev dev;

	@Before
	public void setup() {
		dao = new DevDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
		dev = mock(Dev.class);
	}
	
	
	
	@Test
	public void getTest(){
		@SuppressWarnings("unchecked")
		TypedQuery<Dev> mockTypedQuery = mock(TypedQuery.class);

		List<Dev> expected = new ArrayList<Dev>();

		when(mockEm.createQuery(anyString(), eq(Dev.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		dao.get();

		verify(mockTypedQuery).getResultList();
	}
	
	@Test
	public void getDevByUsernameTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<Dev> mockTypedQuery = mock(TypedQuery.class);

		Dev expected = new Dev();

		when(mockEm.createQuery(anyString(), eq(Dev.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(expected);

		dao.getDevByUsername("test");

		verify(mockTypedQuery).setParameter(eq("email"), eq("test"));
	}
	 // should add sad path for get dev by username to test catching exception
	@Test 
	public void registerTest() {
		
	}
}
