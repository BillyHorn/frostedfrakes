package com.catalyst.springboot.dao;

import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
