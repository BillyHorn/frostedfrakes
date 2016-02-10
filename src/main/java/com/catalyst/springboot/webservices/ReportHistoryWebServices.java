package com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.ReportHistory;
import com.catalyst.springboot.services.ReportHistoryService;

/**
 * endpoints for accessing reporthistory
 * @author mKness
 *
 */
@RestController
public class ReportHistoryWebServices {

	@Autowired
	ReportHistoryService reportHistoryService;
	
	/**
	 * simple setter for the reporthistory service
	 * @param reportHistoryService
	 * @author mKness
	 */
	public void setReportHistoryService(ReportHistoryService reportHistoryService) {
		this.reportHistoryService = reportHistoryService;
	}
	
	/**
	 * endpoint for getting the report history of a single report
	 * 
	 * @param reportId the report that is having its history fetched
	 * @return the list of report histories corresponding to the given report
	 * @author mKness
	 */
	@RequestMapping(value="/reportHistory/{reportId}", method=RequestMethod.GET)
	public List<ReportHistory> getReportHistory(@PathVariable Integer reportId) {
		return reportHistoryService.getReportHistory(reportId);
	}
}
