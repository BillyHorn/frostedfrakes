package com.catalyst.springboot.webservices;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.services.DevService;
import com.catalyst.springboot.services.ProjectService;

/**
 * 
 * @author mKness
 *
 */
public class ProjectWebServicesTest {

	private ProjectWebServices projectWebServices;
	private ProjectService projectService;
	private DevService devService;
	private Project project;
	private Dev dev;
	
	@Before
	public void setup(){
		projectWebServices = new ProjectWebServices();
		projectService = mock(ProjectService.class);
		devService = mock(DevService.class);
		project = mock(Project.class);
		dev = mock(Dev.class);
		projectWebServices.setDevService(devService);
		projectWebServices.setProjectService(projectService);
	}
	
	@Test
	public void createProjectTest(){
		projectWebServices.createProject(anyObject());
		verify(projectService).add(anyObject());
	}
	
	@Test
	public void getProjectsTest(){
		List<Project> projects = new ArrayList<Project>();
		
		when(devService.getEmployeeByUsername(anyString())).thenReturn(dev);
		
		when(projectWebServices.getProjects(anyString())).thenReturn(projects);
		
		projectWebServices.getProjects(anyString());
		verify(projectService).getByDev(dev);
	}
}
