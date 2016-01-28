package com.catalyst.springboot.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.services.DevService;
import com.catalyst.springboot.services.ProjectService;

@RestController
public class WebServices {

	@Autowired
	DevService service;
	
	@Autowired 
	ProjectService projectService;
	
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

	@RequestMapping(value="/project/create", method=RequestMethod.POST)
	public void createProject(@RequestBody Project project){
		projectService.add(project);
	}
	
	@RequestMapping(value="/project/get", method=RequestMethod.GET)
	public List<Project> createProject(@RequestBody Object project){
		return projectService.get();
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<Dev> getUsers() {		
		return service.get();
		
	}
	
	
}
