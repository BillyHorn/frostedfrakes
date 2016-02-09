package com.catalyst.springboot.services;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.dao.ReportHistoryDao;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.ReportHistory;

/**
 * Unit test reportHistoryService
 * @author mKness
 *
 */
public class ReportHistoryServiceTest {

	private ReportHistoryService service;
	private ReportHistoryDao dao;
	private Report report;
	
	/**
	 * pre test setup, initialize instance variables
	 * @author mKness
	 */
	@Before
	public void setup() {
		service = new ReportHistoryService();
		dao = mock(ReportHistoryDao.class);
		service.setReportHistoryDao(dao);
		report = mock(Report.class);
	}
	
	/** 
	 * Test the getting of reporthistory for a particular report
	 * @author mKness
	 */
	@Test
	public void getReportHistoryTest(){
		List<ReportHistory> reportHistory = mock(List.class);
		
		when(dao.getReportHistory(report.getReportId())).thenReturn(reportHistory);
		
		service.getReportHistory(report.getReportId());
		verify(dao).getReportHistory(report.getReportId());
	}
}
