package com.catalyst.springboot.services;
import java.util.List;
import com.catalyst.springboot.entities.Report;



public interface Service {
	
	
	/**
	 * addReport() INTERFACE
	 * 
	 * Send a report to the DAO layer
	 * after it has been received from
	 * WebServices
	 * 
	 * @author wPerlichek
	 *
	 */
	public void addReport(Report reportIN);

}
