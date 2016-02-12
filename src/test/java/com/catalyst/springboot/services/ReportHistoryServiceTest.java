package com.catalyst.springboot.services;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;

import com.catalyst.springboot.component.AuthenticationFacade;
import com.catalyst.springboot.dao.ReportHistoryDao;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.ReportHistory;
import com.catalyst.springboot.factories.ReportHistoryFactory;

/**
 * Unit test reportHistoryService
 * @author mKness
 *
 */
public class ReportHistoryServiceTest {

	private ReportHistoryService service;
	private ReportHistoryDao dao;
	private Report report;
	private ReportHistory reportHistory;
	private ReportHistoryFactory reportHistoryFactory;
	private DevService devService;
	private AuthenticationFacade authenticationFacade;
	private Authentication authentication;
	private Dev mockDev;
	
	/**
	 * pre test setup, initialize instance variables
	 * @author mKness
	 */
	@Before
	public void setup() {
		service = new ReportHistoryService();
		devService = mock(DevService.class);
		dao = mock(ReportHistoryDao.class);	
		authenticationFacade = mock(AuthenticationFacade.class);
		reportHistoryFactory = mock(ReportHistoryFactory.class);
		service.setReportHistoryDao(dao);
		service.setReportHistoryFactory(reportHistoryFactory);
		service.setDevService(devService);
		service.setAuthenticationFacade(authenticationFacade);
		report = mock(Report.class);
		reportHistory = mock(ReportHistory.class);
		authentication = mock(Authentication.class);
		mockDev = mock(Dev.class);
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
	
	@Test
	public void createLogTest() {
		ReportHistory mockRH = mock(ReportHistory.class);
		Authentication mockAuth = mock(Authentication.class);
		when(service.authenticationFacade.getAuthentication()).thenReturn(mockAuth);
		when(mockAuth.getName()).thenReturn(null);
		when(service.devService.getEmployeeByUsername(anyString())).thenReturn(mockDev);
		doNothing().when(mockRH).setEditingDev(anyObject());
		doNothing().when(mockRH).setTimeStamp(anyObject());
		doNothing().when(mockRH).setReport(anyObject());
		doNothing().when(mockRH).setAction(anyObject());
		doNothing().when(dao).createLog(mockRH);
		when(service.reportHistoryFactory.newReportHistory()).thenReturn(mockRH);
		service.createLog(report);
		verify(dao).createLog(mockRH);
	}
	
	@Test 
	public void updateLogTest() {
		List<ReportHistory> history = new ArrayList<ReportHistory>();
		
		ReportHistory mockRH = mock(ReportHistory.class);
		Authentication mockAuth = mock(Authentication.class);
		when(service.authenticationFacade.getAuthentication()).thenReturn(mockAuth);
		when(mockAuth.getName()).thenReturn(null);
		when(service.devService.getEmployeeByUsername(anyString())).thenReturn(mockDev);
		when(dao.getReportHistory(anyInt())).thenReturn(history);
		doNothing().when(mockRH).setEditingDev(anyObject());
		doNothing().when(mockRH).setTimeStamp(anyObject());
		doNothing().when(mockRH).setReport(anyObject());
		doNothing().when(mockRH).setAction(anyObject());
		doNothing().when(dao).updateLog(mockRH);
		when(service.reportHistoryFactory.newReportHistory()).thenReturn(mockRH);
		service.updateLog(report);
		verify(dao).updateLog(mockRH);
	}
}