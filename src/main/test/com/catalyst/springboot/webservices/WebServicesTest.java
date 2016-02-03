package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.services.DevService;
import com.catalyst.springboot.services.ProjectService;

public class WebServicesTest {
	
	private DevService devService;
	private ProjectService projectService;
	private WebServices webService;

	@Before
	public void setup(){
		devService = mock(DevService.class);
		projectService = mock(ProjectService.class);
		webService = new WebServices();
		webService.setProjectService(projectService);
		webService.setService(devService);
	}
	
	@Test
	public void createProjectTest(){
		webService.createProject(null);
		verify(projectService).add((Project) eq(null));
	}
	
	@Test
	public void getProjectTest(){
		List<Project> projList = new ArrayList<Project>();
		
		when(projectService.get()).thenReturn(projList);
		
		webService.getProjects();
		verify(projectService).get();
	}
	
	@Test
	public void getUsersTest(){
		List<Dev> devs = new ArrayList<Dev>();
		
		when(devService.get()).thenReturn(devs);
		
		webService.getUsers();
		verify(devService).get();
	}
}
