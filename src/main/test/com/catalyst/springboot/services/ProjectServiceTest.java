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
	private Dev dev;
	private Project project;
	private Converters convert;
	
	@Before
	public void setup() {
		service = new ProjectService();
		convert = mock(Converters.class);
		dao = mock(ProjectDao.class);
		dev = mock(Dev.class);
		project = mock(Project.class);
		service.setProjectDao(dao);
		service.setConvert(convert);
	}
	
	@Test
	public void getAllProjects(){
		List<Project> projects = new ArrayList<Project>();
		
//		when(dao.get()).thenReturn(projects);
		
//		service.get();
//		verify(dao).get();
	
	}
	
	@Test
	public void addProjectTest(){
		Set<Dev> devSet = mock(Set.class);
		List<Dev> devsToConvert = mock(List.class);
		devsToConvert = Arrays.asList(dev);
		Iterator iterator = mock(Iterator.class);
		
		
		when(project.getDevsToConvert()).thenReturn(devsToConvert);

		when(iterator.hasNext()).thenReturn(true, false);
		when(convert.convertDevs((List<Dev>) anyObject())).thenReturn(devSet);

		
		
		service.add(project);
		verify(dao).add(project);
	}
	

}