package com.catalyst.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.LineItem;


public class LineItemDaoTest {

	private LineItemDao lineItemDao;
	private EntityManager mockEm;
	
	@Before
	public void setup() {
		lineItemDao = new LineItemDao();
		mockEm = mock(EntityManager.class);
		lineItemDao.setEm(mockEm);
	}
	
	@Test
	public void getTest() {
		TypedQuery<LineItem> query = mock(TypedQuery.class);
		List<LineItem> expected = new ArrayList<LineItem>();
		
		when(mockEm.createQuery(anyString(), eq(LineItem.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(expected);
		
		verify(query).getResultList();
	}
	
	@Test
	public void getLineItemByReportIdTest() {
		// Integer reportID = mock(Integer.class); // dont know if this is needed
		TypedQuery<LineItem> query = mock(TypedQuery.class);
		List<LineItem> expected = new ArrayList<LineItem>();
		
		when(mockEm.createQuery(anyString(), eq(LineItem.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(expected);
		
		verify(query).getResultList();
	}
}
