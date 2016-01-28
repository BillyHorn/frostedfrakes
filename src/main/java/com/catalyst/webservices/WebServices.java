package com.catalyst.webservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.dao.impl.Daoimpl;
import com.catalyst.springboot.entities.Employee;

@RestController
public class WebServices {

	@Autowired
	private Daoimpl dao;

	// TODO check for mapping value
	// Front end  : expecting Employee as Json . 
	//should have username password and role as user (default) 
	
	@RequestMapping(value = "/regesterNewEmployee", method = RequestMethod.POST)
	public Employee addNewUser(@RequestBody Employee employee) {

		String username = employee.getUsername();
		Employee value = dao.checkUserName(username);
		if (value != null) {
			String message= "User Name Exists";
			return value; 
		} else {
			String message= "Regestration Sucess";
			return  dao.createEmployeeUserName(employee);
			
		}
		
	}
}
