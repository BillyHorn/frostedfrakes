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
import com.catalyst.springboot.services.ProjectService;

@RestController
public class ProjectWebServices {

	@Autowired  
	ProjectService projectService;
	
	/**
	 * @param projectService the projectService to set
	 */
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
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
	@RequestMapping(value="/project/get/{email}", method=RequestMethod.GET)
	public List<Project> getProjects(@PathVariable String email){
		Dev dev = devService.getEmployeeByUsername(email);
		return projectService.getByDev(dev);
	}
}
