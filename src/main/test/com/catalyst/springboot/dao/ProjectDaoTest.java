package com.catalyst.springboot.dao;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;


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
	public void registerTest() {
		dao.register(null);
		verify(mockEm).persist(null);
	}
}
