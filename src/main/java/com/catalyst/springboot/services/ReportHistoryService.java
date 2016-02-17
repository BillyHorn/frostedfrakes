package com.catalyst.springboot.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.component.IAuthenticationFacade;
import com.catalyst.springboot.dao.ReportHistoryDao;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.ReportHistory;
import com.catalyst.springboot.factories.ReportHistoryFactory;

/**
 * 
 * @author mKness
 *
 */
@Service
public class ReportHistoryService {

	@Autowired
	ReportHistoryDao reportHistoryDao;
	
	@Autowired
	ReportHistoryFactory reportHistoryFactory;
	
	@Autowired
	DevService devService;
	
	@Autowired
	IAuthenticationFacade authenticationFacade;

	/**
	 * simple setter for the reporthistoryDao
	 * @param reportHistoryDao
	 * @author mKness
	 */
	public void setReportHistoryDao(ReportHistoryDao reportHistoryDao) {
		this.reportHistoryDao = reportHistoryDao;
	}

	/**
	 * 
	 * @param reportHistoryFactory
	 */
	public void setReportHistoryFactory(ReportHistoryFactory reportHistoryFactory){
		this.reportHistoryFactory = reportHistoryFactory;
	}
	
	/**
	 * simple setter for the devService
	 * @param devService
	 * @author mKness
	 */
	public void setDevService(DevService devService) {
		this.devService = devService;
	}
	
	/**
	 * simple setter for the facade
	 * @param authenticationFacade
	 * @author mKness
	 */
	public void setAuthenticationFacade(IAuthenticationFacade authenticationFacade) {
		this.authenticationFacade = authenticationFacade;
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

	/**
	 * add an entry for the creation of a report
	 * 	needs to create the reportHistory object
	 * @param rtnReport the report that is getting logged
	 * @author mKness
	 */
	public void createLog(Report report) {
		ReportHistory reportHistory = reportHistoryFactory.newReportHistory();
		reportHistory.setEditingDev(getEditingDev());
		reportHistory.setTimeStamp(getTimestamp());
		reportHistory.setReport(report);
		reportHistory.setAction("0");
		reportHistoryDao.createLog(reportHistory);
	}

	/**
	 * add an entry for the update of a report
	 * 	needs to create the reportHistory object
	 * @param report the report being logged
	 */
	public void updateLog(Report report) {
		ReportHistory reportHistory = reportHistoryFactory.newReportHistory();
		reportHistory.setEditingDev(getEditingDev());
		reportHistory.setTimeStamp(getTimestamp());
		reportHistory.setReport(report);
		reportHistory.setAction(getAction(report));
		reportHistoryDao.updateLog(reportHistory);
	}
	
	
	/**
	 * helper function to get the current time stamp
	 * @return the current timestamp
	 * @author mKness
	 */
	private Timestamp getTimestamp() {
		java.util.Date date = new java.util.Date();
		return new Timestamp(date.getTime());
	}
	
	/**
	  * helper function to return a string based on the state of the given report
	  * 
	  * @param report the report being logged
	  * @return the string representation of the action taken
	  * @author mKness
	  */
	 private String getAction(Report report) {
	  String state = report.getState();
	  ReportHistory old = getLatestHistory(report.getReportId());
	  if(state.equals("1") && old.getAction().equals("2")) {
	   state = "-1";
	  }
	  return state;
	 }
	
	/**
	 * helper function to get the current user from spring security
	 * @return the current user
	 * @author mKness
	 */
	private Dev getEditingDev()
	{
		Authentication authentication = authenticationFacade.getAuthentication();
        return devService.getEmployeeByUsername(authentication.getName());
	}
	
	/**
	  * helper function 
	  * @param reportId is the reportId of the report we want the latest history for
	  * @return 
	  */
	 private ReportHistory getLatestHistory(Integer reportId) {
	  List<ReportHistory> history = reportHistoryDao.getReportHistory(reportId);
	  ReportHistory rtnHistory = null;
	  for(ReportHistory rh : history) {
	   if(rtnHistory == null) {
	    rtnHistory = rh;
	   }
	   else if(rh.getTimeStamp().compareTo(rtnHistory.getTimeStamp()) > 0) {
	    rtnHistory = rh;
	   }
	  }
	  return rtnHistory;
	 }
}
