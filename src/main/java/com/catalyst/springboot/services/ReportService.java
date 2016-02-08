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
	
	/**
	 * @param reportDao the reportDao to set
	 */
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
	/**
	 * this function send an update request to the report DAO
	 * 
	 * @param report this is the report to be updated.
	 */
	public void update(Report report) {
		reportDao.update(report);
	}

	/** ADD
	 * add a new report
	 * @param report
	 * @author wPerlichek
	 * @return 
	 */
	public Report add(Report report) {
		//report.setUsers(convertDevs(report.getLineItemsToConvert()));
//		report.setLineItems(convertLineItems(report.getLineItemsToConvert()));
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
	
	
//	public List<Report> getTechLeadReports(List<Project> list) {
//		List<Report> allReports = reportDao.getReport();  
//		List<Report> techLeadReports = new ArrayList<Report>();
//		for (Report report : allReports){
//			for(Project pro: list){
//				if(report.getProject().getProjectId() == pro.getProjectId()){
//					techLeadReports.add(report);
//				}
//			}
//		}
//		return techLeadReports;
//	}
	
	public List<Report> getReportByDevId(String email) {
		// TODO Auto-generated method stub
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
