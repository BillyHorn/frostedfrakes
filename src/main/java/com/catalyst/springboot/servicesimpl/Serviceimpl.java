package com.catalyst.springboot.servicesimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.catalyst.springboot.dao.Dao;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.services.Service;

public class Serviceimpl implements Service {
	
	@Autowired
	private Dao reportDao;
	
	/**
	 * @param reportDao the reportDao to set
	 */
	public void setReportDao(Dao reportDao) {
		this.reportDao = reportDao;
	}

	/**
	 * addReport()
	 * 
	 * add the report to the DAO layer
	 * 
	 * @author wPerlichek
	 *
	 */
	public void addReport(Report reportIN) {
		reportDao.addReport(reportIN);
	}

}
