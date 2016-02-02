package com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	
	/**
	 * @param reportService the reportService to set
	 */
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	 /**
	 * Api used to create a project.
	 * 
	 * @param project The project to be created.
	 */
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
	public List<Project> getProjects(){
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
	
	@RequestMapping(value="/report/get", method=RequestMethod.GET)
	public List<Report> getReport(){
		return reportService.getReport();
	}
	
}
