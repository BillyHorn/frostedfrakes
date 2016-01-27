package com.catalyst.springboot.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.User;
import com.catalyst.springboot.services.Service;


@RestController
public class WebServices {

	
//TODO	
/*	
	@Autowired
	private UserService userService;
	
	 public void setReportService(UeportService reportService) {
		this.reportService = reportService;
	}
	 
*/	 

//TODO   check value from  front end 	
	@RequestMapping(value="/userregestration", method=RequestMethod.POST)
	public void addUserRegestration(@RequestBody User newuser){
		
		// return Service.add(newuser);
	} 
	
}
