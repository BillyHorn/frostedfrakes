package com.catalyst.springboot.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.dao.ProjectDao;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Project;

import javassist.bytecode.Descriptor.Iterator;

public class ProjectServiceTest {

	private ProjectService service;
	private ProjectDao dao;
	private ProjectService mockService;
	private Dev dev;
	private Project project;
	
	@Before
	public void setup() {
		service = new ProjectService();
		dao = mock(ProjectDao.class);
		service.setProjectDao(dao);
		mockService = mock(ProjectService.class);
		dev = mock(Dev.class);
		project = mock(Project.class);
	}
	
	@Test
	public void getAllProjects(){
		List<Project> projects = new ArrayList<Project>();
		
		when(dao.get()).thenReturn(projects);
		
		service.get();
		verify(dao).get();
	
	}
	
	@Test
	public void addProjectTest(){
		Set<Dev> devSet = mock(Set.class);
		List<Dev> devsToConvert = mock(List.class);
		devsToConvert = Arrays.asList(dev);
		Iterator iterator = mock(Iterator.class);
		
		
		when(project.getDevsToConvert()).thenReturn(devsToConvert);
		when(service.convertDevs(anyObject())).thenReturn(devSet);
		when(iterator.hasNext()).thenReturn(true, false);
		
		
		service.add(project);
		verify(dao).add(project);
	}
	
	@Test
	public void ConvertDevsTest(){
		Set<Dev> devs = mock(Set.class);
		List<Dev> devsToConvert = mock(List.class);
		devsToConvert = Arrays.asList(dev);
		Iterator iterator = mock(Iterator.class);
		
		when(iterator.hasNext()).thenReturn(true, false);
		
		service.convertDevs(devsToConvert);
		assertEquals(devs, devs);
		
	}
}