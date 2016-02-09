package com.catalyst.springboot.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.springboot.dao.ReportDao;
import com.catalyst.springboot.entities.Project;
import com.catalyst.springboot.entities.Report;


@Service
public class ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private ReportHistoryService reportHistoryService;
	
	/**
	 * @param reportDao the reportDao to set
	 */
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
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
		reportDao.update(report); // TODO throw in try
		reportHistoryService.updateLog(report);
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
}
