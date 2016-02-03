package com.catalyst.springboot.services;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.springboot.dao.Dao;
import com.catalyst.springboot.dao.impl.Daoimpl;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Report;


@Service
public class ReportService {
	
	@Autowired
	private Daoimpl reportDao;
	
	/**
	 * @param reportDao the reportDao to set
	 */
	public void setReportDao(Daoimpl reportDao) {
		this.reportDao = reportDao;
	}

	/** ADD
	 * add a new report
	 * @param report
	 * @author wPerlichek
	 */
	public void add(Report report) {
		//report.setUsers(convertDevs(report.getLineItemsToConvert()));
//		report.setLineItems(convertLineItems(report.getLineItemsToConvert()));
		reportDao.addReport(report);
	}
	
	/* PLEASE DO NOT DELETE wPerlichek */
//	public Set<LineItem> convertLineItems(List<LineItem> LineItemToConvert){
//		Set<LineItem> lineItems = new HashSet<LineItem>();
//		for (LineItem lineItem : LineItemToConvert){
//			lineItems.add(lineItem);
//		}
//		return lineItems;
//	}
	/* /PLEASE DO NOT DELETE wPerlichek */
	
	
	/** GET
	 * get available reports
	 * @param none
	 * @author wPerlichek
	 */
	public List<Report> getReport(){
		return reportDao.getReport();
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
}
