package com.catalyst.springboot.dao;


import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Dev;

import javassist.bytecode.Descriptor.Iterator;

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
	
	
	
	/*@Test
	public void getAllDevsTest(){
		TypedQuery<Dev> query = mock(TypedQuery.class);
		List<Dev> devsToConvert = new ArrayList<Dev>();
		devsToConvert = Arrays.asList(dev);
		Iterator iterator = mock(Iterator.class);
		
		
		
		when(mockEm.createQuery(anyString(), eq(Dev.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(devsToConvert);
		when(iterator.hasNext()).thenReturn(true, false);
		
		dao.get();
		verify(iterator).hasNext();
	}*/
}
