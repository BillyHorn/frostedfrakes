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
import com.catalyst.springboot.entities.ReportHistory;

/**
 * Unit test ReportHistoryDao
 * @author mKness
 *
 */
public class ReportHistoryDaoTest {

	private ReportHistoryDao dao;
	private EntityManager mockEm;
	private ReportHistory reportHistory;
	
	/**
	 * pre test setup, initialize instance variables
	 * @author mKness
	 */
	@Before
	public void setup() {
		dao = new ReportHistoryDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
		reportHistory = mock(ReportHistory.class);
	}
	
	/**
	 * test the creating a log function
	 * @author mKness
	 */
	@Test
	public void createLogTest(){
		dao.createLog(null);
		verify(mockEm).persist(null);
	}
	
	/**
	 * @author mKness
	 */
	@Test
	public void updateLogTest(){
		dao.updateLog(null);
		verify(mockEm).persist(null);
	}
	/**
	 * test the get functionality
	 * @author mKness
	 */
	@Test
	public void getReportHistoryTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<ReportHistory> mockTypedQuery = mock(TypedQuery.class);

		List<ReportHistory> expected = new ArrayList<ReportHistory>();

		when(mockEm.createQuery(anyString(), eq(ReportHistory.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		dao.getReportHistory(1);

		verify(mockTypedQuery).setParameter(eq("reportId"), eq(1));
	}
}
