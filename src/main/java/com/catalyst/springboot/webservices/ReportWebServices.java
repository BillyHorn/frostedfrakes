package com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Project;
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
	@RequestMapping(value="/report/create", method=RequestMethod.POST)
	public Integer addReport(@RequestBody Report report){
		int id = reportService.add(report);
		return id;
	} 
	
	/**
	 * 
	 * 
	 * @return all reports
	 */
	@RequestMapping(value="/report/get", method=RequestMethod.GET)
	public List<Report> getReport(){
		return reportService.getReport();
	}
	
	@RequestMapping(value="/report/get/{email}", method=RequestMethod.GET)
	public List<Report> getReportByDevId(@PathVariable String email){
		Dev dev = devService.getEmployeeByUsername(email);
		return reportService.getReportByDevId(dev);
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
	@RequestMapping(value="/report/{reportId}", method=RequestMethod.GET)
	public Report getReportById(@PathVariable Integer reportId){
		return reportService.getReportById(reportId);
	}
	
	/**
	 * if tech lead, gets the current users
	 * pending reports
	 */
	@RequestMapping(value="/pendingReports/{email}", method = RequestMethod.GET)
	public List<Report> currentUser(@PathVariable String email) {
		Dev dev = devService.getEmployeeByUsername(email);
		List<Project> list= projectService.getTechLeadProjects(dev);
		return reportService.getTechLeadReports(list);
	}
	
	/**
	 * This is an endpoint for updating reports
	 * 
	 * @param report this is the report to be updated
	 */
	@RequestMapping(value = "/report/update", method = RequestMethod.PUT)
	 public void approveOrRejectReport(@RequestBody Report report) {
		reportService.update(report);
	 }
}
