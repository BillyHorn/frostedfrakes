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
import com.catalyst.springboot.entities.Report;

public class ReportDaoTest {
	
	private ReportDao reportDao;
	private EntityManager em;
	private Report report;

	@Before
	public void setup(){
		reportDao = new ReportDao();
		em = mock(EntityManager.class);
		reportDao.setEm(em);
		report = mock(Report.class);
	}
	
	/**
	 * @author kmatthiesen
	 * @author mKness
	 */
	@Test
	public void addReportTest() {
		reportDao.addReport(null);
		verify(em).persist(null);
	}
	
	@Test
	public void getReportTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<Report> mockTypedQuery = mock(TypedQuery.class);

		List<Report> expected = new ArrayList<Report>();

		when(em.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		reportDao.getReport();

		verify(mockTypedQuery).getResultList();
	}
	
	@Test
	public void getReportByIdTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<Report> mockTypedQuery = mock(TypedQuery.class);

		Report report = new Report();

		when(em.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(report);

		reportDao.getReportById(1);

		verify(mockTypedQuery).setParameter(eq("reportId"), eq(1));
	}
	
	@Test
	public void getTechLeadReportTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<Report> mockTypedQuery = mock(TypedQuery.class);

		List<Report> expected = new ArrayList<Report>();

		when(em.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		reportDao.getTechLeadReport("test");

		verify(mockTypedQuery).setParameter(eq("email"), eq("test"));
	}
	
	@Test
	public void updateTest() {
		reportDao.update(null);
		verify(em).merge(null);
	}
	
	@Test
	public void getReportByDevIdTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<Report> mockTypedQuery = mock(TypedQuery.class);

		List<Report> expected = new ArrayList<Report>();

		when(em.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		reportDao.getReportByDevId("test");

		verify(mockTypedQuery).setParameter(eq("email"), eq("test"));
	}
	
	/**
	 * @author spallipatt
	 */
	@Test
	public void getallPreviousReportsTest(){
		
		TypedQuery<Report> mockTypedQuery = mock(TypedQuery.class);
		List<Report> expected = new ArrayList<Report>();
		when(em.createQuery(anyString(), eq(Report.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
	}
	
}
