package com.catalyst.springboot.factories;


import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.ReportHistory;


/**
 * creates both update and create logs for Report history table
 * @author mKness
 *
 */
@Component
public class ReportHistoryFactory {

	public ReportHistory newReportHistory()
	{
		return new ReportHistory();
	}	
}
