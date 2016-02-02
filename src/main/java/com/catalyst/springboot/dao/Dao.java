package com.catalyst.springboot.dao;
import java.util.List;
import com.catalyst.springboot.entities.Report;


public interface Dao {

	/**
	 * addReport()
	 * 
	 * Send a report from DAO to DB
	 * after it has been received from
	 * Service layer
	 * 
	 * @author wPerlichek
	 *
	 */
	void addReport(Report report);

	
	/**
	 * add a new User to storage.
	 * @param user
	 */
//	void add(User user);
	
	/**
	 * Retrieves all employees currently in storage.
	 * @return
	 */

}
