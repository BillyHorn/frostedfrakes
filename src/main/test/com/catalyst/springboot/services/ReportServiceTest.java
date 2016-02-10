package com.catalyst.springboot.services;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.ReportDao;
import com.catalyst.springboot.entities.Report;

/**
 * 
 * @author mKness
 *
 */

public class ReportServiceTest {

	private ReportService reportService;
	private ReportDao reportDao;
	private ReportHistoryService reportHistoryService;
	private Report report;
	
	@Before
	public void Setup() {
		reportService = new ReportService();
		reportDao = mock(ReportDao.class);
		reportHistoryService = mock(ReportHistoryService.class);
		reportService.setReportDao(reportDao);
		reportService.setReportHistoryService(reportHistoryService);
		report = mock(Report.class);
	}
	
	@Test
	public void updateTest() {
		doNothing().when(reportHistoryService).updateLog(anyObject());
		
		reportService.update(report);
		verify(reportDao).update(report);
	}
	
	@Test
	public void addTest() {
		doNothing().when(reportHistoryService).createLog(report);
		
		reportService.add(anyObject());
		verify(reportDao).addReport(anyObject());
	}
	
	@Test
	public void getReportTest() {
		@SuppressWarnings("unchecked")
		List<Report> reports = mock(List.class);
		
		when(reportDao.getReport()).thenReturn(reports);
		
		reportService.getReport();
		verify(reportDao).getReport();
	}
	
	@Test
	public void getReportByDevIdTest() {
		@SuppressWarnings("unchecked")
		List<Report> reports = mock(List.class);
		
		when(reportDao.getReportByDevId(anyString())).thenReturn(reports);
		
		reportService.getReportByDevId(anyString());
		verify(reportDao).getReportByDevId(anyString());
	}
	
	@Test
	public void getReportByIdTest() {
		when(reportDao.getReportById(anyInt())).thenReturn(report);
		
		reportService.getReportById(anyInt());
		verify(reportDao).getReportById(anyInt());
	}
	
	@Test
	public void getTechLeadReportTest() {
		@SuppressWarnings("unchecked")
		List<Report> reports = mock(List.class);
		
		when(reportDao.getTechLeadReport(anyString())).thenReturn(reports);
		
		reportService.getTechLeadReport(anyString());
		verify(reportDao).getTechLeadReport(anyString());
	}
}
