package com.catalyst.springboot.dao;

import java.util.List;

import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.User;

public interface Dao {

	/**
	 * add a new report to the DB
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
