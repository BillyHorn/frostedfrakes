package com.catalyst.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.ReportHistoryDao;
import com.catalyst.springboot.entities.ReportHistory;

/**
 * 
 * @author mKness
 *
 */
@Service
public class ReportHistoryService {

	@Autowired
	ReportHistoryDao reportHistoryDao;
	
	/**
	 * simple setter for the reporthistoryDao
	 * @param reportHistoryDao
	 * @author mKness
	 */
	public void setReportHistoryDao(ReportHistoryDao reportHistoryDao) {
		this.reportHistoryDao = reportHistoryDao;
	}

	/**
	 * gets and returns the list of report histories corresponding to the given reportId
	 * 
	 * @param reportId
	 * @return
	 * @author mKness
	 */
	public List<ReportHistory> getReportHistory(Integer reportId) {
		return reportHistoryDao.getReportHistory(reportId);
	}
}
