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
	DevService devService;
	
	@Autowired
	private IAuthenticationFacade authenticationFacade;
	
	/**
	 * simple setter for the reporthistoryDao
	 * @param reportHistoryDao
	 * @author mKness
	 */
	public void setReportHistoryDao(ReportHistoryDao reportHistoryDao) {
		this.reportHistoryDao = reportHistoryDao;
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
	public void createLog(Report rtnReport) {
		ReportHistory reportHistory = new ReportHistory();
		reportHistory.setEditingDev(rtnReport.getDev());
		reportHistory.setTimeStamp(getTimestamp());
		reportHistory.setReport(rtnReport);
		reportHistory.setAction("0"); // created action
		reportHistoryDao.createLog(reportHistory);
	}

	/**
	 * add an entry for the update of a report
	 * 	needs to create the reportHistory object
	 * @param report the report being logged
	 */
	public void updateLog(Report report) {
		ReportHistory reportHistory = new ReportHistory();
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
		/*if(state.equals("1")){
			state = "Saved";
		}
		else if (state.equals("2")) {
			state = "Submitted";
		} 
		else if (state.equals("3")) {
			state = "Rejected";
		} 
		else if (state.equals("4")) {
			state = "Approved";
		}*/
		return state;
	}
	
	private Dev getEditingDev()
	{
		Authentication authentication = authenticationFacade.getAuthentication();
        return devService.getEmployeeByUsername(authentication.getName());
	}
}
