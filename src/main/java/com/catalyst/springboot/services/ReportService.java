package com.catalyst.springboot.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.springboot.dao.ReportDao;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.mail.EmailHandler;


@Service
public class ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	EmailHandler emailHandler;
	
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
	 * this function send an update request to the report DAO
	 * 
	 * @param report this is the report to be updated.
	 */
	public void update(Report report) {
		Report repor = reportDao.update(report);
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
	 * @param report
	 * @author wPerlichek
	 * @return 
	 */
	public Report add(Report report) {
		return reportDao.addReport(report);
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
}
