package com.catalyst.springboot.webservices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.dao.ProjectDao;
import com.catalyst.springboot.entities.Dev;

import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.DevService;
import com.catalyst.springboot.services.ProjectService;
import com.catalyst.springboot.services.ReportService;

/**
 * Controls the webserivces used to direct the api calls.
 * 
 * @author kmatthiesen
 *
 */
@RestController
public class WebServices {

	@Autowired
	private ProjectDao dao;

	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(ProjectDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Dev addNewUser(@RequestBody Dev dev) {
		String email = dev.getEmail();	
		Dev value = dao.checkUserName(email);	

		if (value != null) {			 
			String message= "User Name Exists";
			System.out.println("----------->webservice message "+message);
			return null; 
		} else {
			dao.register(dev);
			String message= "Regestration Sucess";
			System.out.println("--------->webservice "+message);
			return  dev;			
		}
	}
	
	@Autowired
	DevService service;
	
	@Autowired  
	ProjectService projectService;
	
	@Autowired 
	ReportService reportService;
	
	/**
	 * @param projectService the projectService to set
	 */
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(DevService service) {
		this.service = service;
	}

	
	/*
	 * @param reportService the reportService to set
	 */
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	public ReportService getReportService () {
		return this.reportService;
	}

	/**
	 * Api used to create a project.
	 * 
	 * @param project The project to be created.
	 */
	@RequestMapping(value="/project/create", method=RequestMethod.POST)
	public void createProject(@RequestBody Project project){
		projectService.add(project);
	}
	
	/**
	 * API used to get all projects.
	 * 
	 * @return The list of all projects in the database.
	 */
	@RequestMapping(value="/project/get", method=RequestMethod.GET)
	public List<Project> getProject(){
		return projectService.get();
	}
	
	/**
	 * API used to get all users.
	 * 
	 * @return The list of all users in the database.
	 */
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<Dev> getUsers() {		
		return service.get();
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
	public void addReport(@RequestBody Report report){
		  reportService.add(report);
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
}

