package com.catalyst.springboot.dao;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

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
		TypedQuery<ReportHistory> query = mock(TypedQuery.class);
		List<ReportHistory> expected = new ArrayList<ReportHistory>();
		
		when(mockEm.createQuery(anyString(), eq(ReportHistory.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(expected);
		
		verify(query).getResultList();
	}
}
