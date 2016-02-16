package com.catalyst.springboot.services;
import java.util.List;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.springboot.dao.ReportDao;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.mail.EmailHandler;


@Service
public class ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private EmailHandler emailHandler;

	@Autowired
	private ReportHistoryService reportHistoryService;

	
	/**
	 * @param reportDao the reportDao to set
	 */
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
	/**
	 * @param emailHandler the emailHandler to set
	 */
	public void setEmailHandler(EmailHandler emailHandler) {
		this.emailHandler = emailHandler;
	}
		
	/**
	 * simple setter for report history service
	 * used for logging creating and editing reports to the reporthistory table
	 * @param reportHistoryService 
	 * @author mKness
	 */
	public void setReportHistoryService(ReportHistoryService reportHistoryService) {
		this.reportHistoryService = reportHistoryService;

	}
	
	/**
	 * this function send an update request to the report DAO
	 * also calls the reportHistoryService to create a log of the change @author mKness
	 * 
	 * @param report this is the report to be updated.
	 */
	public void update(Report report) {
	if(report.getState().equals("3")|| report.getState().equals("4")){
		report.setTimestamp(getTimestamp());
	}
		Report repor = reportDao.update(report);
		reportHistoryService.updateLog(report);
		if (repor.getState().equals("2")){
			emailHandler.youSubmitted(repor.getProject().getTechLeadId().getEmail(), repor.getProject().getName());
			emailHandler.reportSubmitted(repor.getDev().getEmail(), repor.getProject().getName());
		}
		else if (repor.getState().equals("3")){
			emailHandler.reportRejected(repor.getProject().getTechLeadId().getEmail(), repor.getProject().getName(), repor.getRejectionNotes());
		}
		else if (repor.getState().equals("4")){
			emailHandler.reportApproved(repor.getProject().getTechLeadId().getEmail(), repor.getProject().getName());
		}		
	}

	/** ADD
	 * add a new report
	 * 
	 * 	also creates an entry in reporthistory for the creation of a report @author mKness
	 * 
	 * @param report
	 * @author wPerlichek
	 * @return 
	 */
	public Report add(Report report) { // TODO throw in try
		Report rtnReport =  reportDao.addReport(report);
		reportHistoryService.createLog(rtnReport);
		return rtnReport;

	}	
	
	/** GET
	 * get available reports
	 * @param none
	 * @author wPerlichek
	 */
	public List<Report> getReport(){
		return reportDao.getReport();
	}

	public List<Report> getReportByDevId(String email) {
		return reportDao.getReportByDevId(email);
	}
	
	/** GET
	 * get a single report based on id
	 * @param reportId, the id of the report to return
	 * @return the report
	 * @author mKness
	 */
	public Report getReportById(Integer reportId)
	{
		return reportDao.getReportById(reportId);
	}

	public List<Report> getTechLeadReport(String email) {
		return reportDao.getTechLeadReport(email);
	}
/**
 * SteffyJ
 * @param email
 * @return
 */
	public List<Report> getallPreviousReports(String email) {

		return reportDao.getallPreviousReports(email);
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
}
