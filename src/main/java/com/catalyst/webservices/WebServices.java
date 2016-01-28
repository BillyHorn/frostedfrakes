package com.catalyst.webservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.catalyst.springboot.dao.Dao;
import com.catalyst.springboot.entities.Report;

@RestController
public class WebServices {

	
	@Autowired
	private Dao reportService;

	public void setReportService(Dao reportService) {
		this.reportService = reportService;
	}
     
	/**
	 * POST
	 * Add a new report from the home page
	 */
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public void addReport(@RequestBody Report report){
		  reportService.addReport(report);
	} 
	
}
