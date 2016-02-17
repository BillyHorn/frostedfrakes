package com.catalyst.springboot.dao;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Receipt;

/**
 * an array of tests for our receipt dao
 * 
 * @author atatro
 *
 */
public class ReceiptDaoTest {

	private ReceiptDao dao;
	private EntityManager mockEm;
	private Receipt receipt;

	@Before
	public void setup() {
		dao = new ReceiptDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
		receipt = mock(Receipt.class);
	}

	@Test
	public void getReceiptByIdTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<Receipt> mockTypedQuery = mock(TypedQuery.class);

		Receipt expected = new Receipt();

		when(mockEm.createQuery(anyString(), eq(Receipt.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(expected);

		dao.getReceiptById(1);

		verify(mockTypedQuery).getSingleResult();
	}

	@Test
	public void getReceiptByLineItemIdTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<Receipt> mockTypedQuery = mock(TypedQuery.class);

		List<Receipt> expected = new ArrayList<Receipt>();

		when(mockEm.createQuery(anyString(), eq(Receipt.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		dao.getReceiptByLineItemId(1);

		verify(mockTypedQuery).getResultList();
	}

	@Test
	public void addReceiptTest() {
		dao.addReceipt(null);
		verify(mockEm).persist(null);
	}

}
