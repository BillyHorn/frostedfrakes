package com.catalyst.springboot.factories;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author mKness
 *
 */
public class ReportHistoryFactoryTest {

	ReportHistoryFactory reportHistoryFactory;
	
	@Before
	public void setup() {
		reportHistoryFactory = new ReportHistoryFactory();
	}
	
	@Test
	public void newReportHistoryTest() {
		reportHistoryFactory.newReportHistory();
	}
}
