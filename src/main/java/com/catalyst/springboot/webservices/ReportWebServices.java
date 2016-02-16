package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.ReportService;

@RestController
public class ReportWebServices {

	@Autowired 
	ReportService reportService;
	
	/**
	 * @param reportService the reportService to set
	 */
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	/**
	 * POST - addReport()
	 * use Serviceimpl object reportService to
	 * add a new report the the service layer
	 * using a report that was obtained via
	 * RestController
	 * 
	 * @author wPerlichek
	 *
	 */
	@RequestMapping(value="/report", method=RequestMethod.POST)
	public Integer addReport(@RequestBody Report report){
		return reportService.add(report).getReportId();
	} 
	
	/**
	 * 
	 * 
	 * @return all reports
	 */
	@RequestMapping(value="/report", method=RequestMethod.GET)
	public List<Report> getReport(){
		return reportService.getReport();
	}
	
	@RequestMapping(value="/report/email/{email}", method=RequestMethod.GET)
	public List<Report> getReportByDevId(@PathVariable String email){
		return reportService.getReportByDevId(email);
	}
	
	/** 
	 * gets a report from the viewReport page and merge it into the db
	 * 
	 * @param report to be merged into the db
	 */
	@RequestMapping(value="/report", method=RequestMethod.PUT)
	public void putReport(@RequestBody Report report) {
		reportService.update(report);
	}
	
	/**
	 * 
	 * @param reportId the spacific report to be returned
	 * @return the report
	 */
	@RequestMapping(value="/report/id/{reportId}", method=RequestMethod.GET)
	public Report getReportById(@PathVariable Integer reportId){
		return reportService.getReportById(reportId);
	}
	
	/**
	 * if tech lead, gets the current users
	 * pending reports
	 */
	@RequestMapping(value="/report/pending/{email}", method = RequestMethod.GET)
	public List<Report> currentUser(@PathVariable String email) {
//		Dev dev = devService.getEmployeeByUsername(email);
//		List<Project> list= projectService.getTechLeadProjects(dev);
		return reportService.getTechLeadReport(email);
	}
	
	/**
	 * gets rejected and approved reports with corresponding techlead id/email
	 * @author Steffy 
	 * 
	 */
	@RequestMapping(value="/report/reviewed/{email}", method = RequestMethod.GET)
	public List<Report> approvedAndRejected(@PathVariable String email){
		return reportService.getallPreviousReports(email);
	}
	
	/* to be included in ReportwebservicesTest 
	 
	 public void approvedAndRejectedTest() throws Exception {
	 List<Report> reportList = new  ArrayList<Report>();
	 
	when(mockreportService.getallPreviousReports(anyString())).thenReturn(reportList);
	 
	 }
	       
	       */
}
