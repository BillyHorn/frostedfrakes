package com.catalyst.springboot.dao;


import static org.mockito.Mockito.*;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Project;



public class ProjectDaoTest {

	private ProjectDao dao;
	private EntityManager mockEm;
	
	@Before
	public void setup() {
		dao = new ProjectDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
	}
	
	@Test
	public void addProjectTest(){
		Project project = mock(Project.class);
		
		dao.add(null);
		verify(mockEm).persist(null);
	}
	
	/*@Test
	public void getAllProjectsTest(){
		TypedQuery<Project> query = mock(TypedQuery.class);
		List<Project> expected = new ArrayList<Project>();
		
		when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(expected);
		
		//dao.getByDev(dev)
		verify(query).getResultList();
	}*/

	/*@Test
	public void registerTest() {
		verify(mockEm).persist(null);
	}*/
}
