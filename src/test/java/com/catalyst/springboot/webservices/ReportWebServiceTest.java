package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.ReportService;

/**
 * 
 * @author mKness
 *
 */
public class ReportWebServiceTest {

	private ReportWebServices reportWebServices;
	private ReportService reportService;
	private Report report;
	
	@Before
	public void setup(){
		reportWebServices = new ReportWebServices();
		reportService = mock(ReportService.class);
		reportWebServices.setReportService(reportService);
		report = mock(Report.class);
	}
	
	@Test
	public void addReportTest() {
		
	}
	
	@Test
	public void getReportTest() {
		List<Report> reports = new ArrayList<Report>();
		
		when(reportWebServices.getReport()).thenReturn(reports);
		
		reportWebServices.getReport();
		verify(reportService).getReport();
	}
	
	@Test
	public void getReportByDevIdTest() {
		List<Report> reports = new ArrayList<Report>();
		
		when(reportWebServices.getReportByDevId(anyString())).thenReturn(reports);
		
		reportWebServices.getReportByDevId(anyString());
		verify(reportService).getReportByDevId(anyString());
	}
	
	@Test
	public void putReportTest() {
		
	}
	
	@Test
	public void getReportByIdTest() {
		
		when(reportWebServices.getReportById(anyInt())).thenReturn(report);
		
		reportWebServices.getReportById(anyInt());
		verify(reportService).getReportById(anyInt());
	}
	
	@Test
	public void currentUserTest()
	{
		List<Report> reports = new ArrayList<Report>();
		
		when(reportWebServices.currentUser(anyString())).thenReturn(reports);
		
		reportWebServices.currentUser(anyString());
		verify(reportService).getTechLeadReport(anyString());
	}
}
