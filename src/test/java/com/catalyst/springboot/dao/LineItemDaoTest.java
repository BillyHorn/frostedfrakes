package com.catalyst.springboot.dao;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.LineItem;

/**
 * 
 * @author mKness
 *
 */
public class LineItemDaoTest {

	private LineItemDao dao;
	private EntityManager mockEm;
	private LineItem lineItem;
	
	@Before
	public void setup(){
		dao = new LineItemDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
		lineItem = mock(LineItem.class);
	}
	
	@Test
	public void getTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<LineItem> mockTypedQuery = mock(TypedQuery.class);

		List<LineItem> expected = new ArrayList<LineItem>();

		when(mockEm.createQuery(anyString(), eq(LineItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		dao.get();

		verify(mockTypedQuery).getResultList();
	}
	
	@Test
	public void getLineItemByReportIdTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<LineItem> mockTypedQuery = mock(TypedQuery.class);

		LineItem expected = new LineItem();

		when(mockEm.createQuery(anyString(), eq(LineItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(expected);

		dao.getLineItemByReportId(1);

		verify(mockTypedQuery).setParameter(eq("reportID"), eq(1));
	}
	
	@Test
	public void updateLineItemTest() {
		dao.updateLineItem(null);
		verify(mockEm).merge(null);
	}
	
	@Test
	public void deleteLineItemTest() {
		dao.deleteLineItem(null);
		verify(mockEm).remove(null);
	}
	
	@Test
	public void getPendingLineItemsTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<LineItem> mockTypedQuery = mock(TypedQuery.class);

		LineItem expected = new LineItem();

		when(mockEm.createQuery(anyString(), eq(LineItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(expected);

		dao.getPendingLineItems(1);

		verify(mockTypedQuery).setParameter(eq("id"), eq(1));
	}
}
