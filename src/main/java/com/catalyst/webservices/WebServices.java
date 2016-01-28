package com.catalyst.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.dao.impl.Daoimpl;
import com.catalyst.springboot.entities.Dev;


@RestController
public class WebServices {

	@Autowired
	private Daoimpl dao;

	// TODO check for mapping value
	// Front end  : expecting Employee as Json . 
	//should have username password and role as user (default) 
	
	@RequestMapping(value = "/regesterNewEmployee", method = RequestMethod.POST)
	public Dev addNewUser(@RequestBody Dev dev) {

		String email = dev.getEmail();
		Dev value = dao.checkUserName(email);
		if (value != null) {
			String message= "User Name Exists";
			return value; 
		} else {
			String message= "Regestration Sucess";
			return  dao.register(dev);
			
		}
		
	}
}
