package com.catalyst.springboot.services;
import java.util.List;
import com.catalyst.springboot.entities.Report;
import com.catalyst.springboot.entities.User;

public interface Service {
	
	/* addReport: add new expense report to List */
	List<Report> addReport(Report reportIN);

}
