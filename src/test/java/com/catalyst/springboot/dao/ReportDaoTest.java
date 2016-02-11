package com.catalyst.springboot.dao;

import static org.mockito.Mockito.*;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Report;

public class ReportDaoTest {
	
	private ReportDao reportDao;
	private EntityManager em;
	private Report report;

	@Before
	public void setup(){
		reportDao = new ReportDao();
		em = mock(EntityManager.class);
		report = mock(Report.class);
	}
	
	/**
	 * @author kmatthiesen
	 */
	@Test
	public void updateTest() {
		
	}
}
