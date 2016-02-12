package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.ReportHistory;
import com.catalyst.springboot.services.ReportHistoryService;

/**
 * unit test reporthistory web services
 * @author mKness
 *
 */
public class ReportHistoryWebServicesTest {

	private ReportHistoryWebServices reportHistoryWebServices;
	private ReportHistoryService reportHistoryService;
	private Report report;
	
	@Before
	public void setup(){
		reportHistoryService = mock(ReportHistoryService.class);
		reportHistoryWebServices = new ReportHistoryWebServices();
		reportHistoryWebServices.setReportHistoryService(reportHistoryService);
		report = mock(Report.class);
	}
	
	@Test
	public void getReportHistoryTest()
	{
		List<ReportHistory> reportHistory = new ArrayList<ReportHistory>();
		
		when(reportHistoryWebServices.getReportHistory(report.getReportId())).thenReturn(reportHistory);
		
		reportHistoryWebServices.getReportHistory(report.getReportId());
		verify(reportHistoryService).getReportHistory(report.getReportId());
	}
}
