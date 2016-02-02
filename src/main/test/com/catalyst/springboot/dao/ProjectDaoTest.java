package com.catalyst.springboot.dao;

<<<<<<< HEAD

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Project;

public class ProjectDaoTest {

	
	private ProjectDao dao;
	private EntityManager mockEm;

=======
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;


public class ProjectDaoTest {

	private ProjectDao dao;
	private EntityManager mockEm;
	
>>>>>>> sprint1
	@Before
	public void setup() {
		dao = new ProjectDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
	}
	
	@Test
<<<<<<< HEAD
	public void addProjectTest(){
		Project project = mock(Project.class);
		
		dao.add(null);
		verify(mockEm).persist(null);
	}
	
	@Test
	public void getAllProjectsTest(){
		TypedQuery<Project> query = mock(TypedQuery.class);
		List<Project> expected = new ArrayList<Project>();
		
		when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(expected);
		
		dao.get();
		verify(query).getResultList();
	}
=======
	public void registerTest() {
		dao.register(null);
		verify(mockEm).persist(null);
	}
>>>>>>> sprint1
}
