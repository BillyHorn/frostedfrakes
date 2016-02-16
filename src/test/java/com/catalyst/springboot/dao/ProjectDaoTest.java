package com.catalyst.springboot.dao;


import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Project;



public class ProjectDaoTest {

	private ProjectDao dao;
	private EntityManager mockEm;
	private Dev dev;
	
	@Before
	public void setup() {
		dao = new ProjectDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
		dev = mock(Dev.class);
	}
	
	@Test
	public void addTest(){		
		dao.add(null);
		verify(mockEm).persist(null);
	}
	
	@Test
	public void getByDevTest(){
		@SuppressWarnings("unchecked")
		TypedQuery<Project> mockTypedQuery = mock(TypedQuery.class);

		List<Project> expected = new ArrayList<Project>();

		when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		dao.getByDev(dev);

		verify(mockTypedQuery).getResultList();
	}

	@Test
	public void getTechLeadProjectsTest() {
		@SuppressWarnings("unchecked")
		TypedQuery<Project> mockTypedQuery = mock(TypedQuery.class);

		List<Project> expected = new ArrayList<Project>();

		when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyObject())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		dao.getTechLeadProjects(dev);

		verify(mockTypedQuery).setParameter(eq("dev"), eq(dev));
	}
	
}
